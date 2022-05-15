# 네이버 오픈 API를 이용한 영화 정보 애플리케이션 만들기
by. Sujin Kim
## 시작하기에 앞서
이번 기술 블로그에서는 [네이버 개발자 센터](https://developers.naver.com/main/)에서 제공하는 **네이버 오픈 API**를 사용하는 방법에 대해서 알려드리고자 합니다.
오픈 API란, API 중에서 플랫폼의 기능 또는 콘텐츠를 외부에서 웹 프로토콜(HTTP)로 호출해 사용할 수 있게 개방(open)한 API를 의미합니다.
현재 네이버 오픈 API로 활용할 수 있는 기술에는 네아로(네이버 아이디로 로그인), 지도, 검색이 있으며, Clova의 음성 인식 기술과 음성 합성 기술, 얼굴 인식 기술, Papago의 기계 번역 기술 등이 있습니다.  


### 예제 애플리케이션 소개
이번 포스트에서는 **영화 정보 애플리케이션**을 만들 것입니다. 사용자로부터 영화 검색어를 입력받은 후, 네이버 오픈 API 호출을 통해 검색어와 일치하는 영화 정보를 불러와 테이블뷰에 표시합니다. 그리고 원하는 영화를 터치하면 각 영화의 세부 정보를 보여줍니다.
![Application Example Image](/tb000_media/0-1.png)
구현하고자 하는 핵심 기능은 **네이버의 검색 API**를 사용한 영화 검색 기능입니다. 영화 포스터 이미지 다운로드는 **비동기 작업**을 사용해 다운로드 작업을 뒤로 미루고, 포스터 이미지가 모두 다운로드 될 때까지 기다릴 필요 없이 바로 검색 결과를 확인할 수 있도록 테이블 뷰를 구성합니다. 마지막으로, **HTTP Request**를 사용하여 영화의 세부 정보를 보여주는 사파리 뷰를 구성합니다.



## 시작하기
### STEP 0. 스타터 프로젝트 다운로드
시작하기에 앞서 [GitHub](https://github.com/gfsusan/NaverAPIExample)에서 스타터 프로젝트를 다운로드하여 각 단계를 따라가시면 됩니다.
프로젝트를 처음부터 만드시고 싶으신 분들은 아래 사진과 같이 UI를 구성하시면 됩니다. 프로젝트를 만드실 때에는 **애플리케이션 이름**과 **애플리케이션 Bundle ID**를 기억해 두었다가 오픈API 신청 시 기입하시기 바랍니다.
![Application UI](/tb000_media/0-2.png)



### STEP 1. 네이버 오픈 API

#### 애플리케이션 등록
네이버 오픈 API를 사용하기 위해서는 네이버로부터 **클라이언트 아이디**와 **클라이언트 시크릿**을 발급받아야 합니다. 이는 네이버 오픈API 사용자가 인증된 사용자인지 확인하는 고유한 아이디와 비밀번호로, 네이버 개발자센터의 **애플리케이션 등록** 메뉴에서 [애플리케이션을 등록](https://developers.naver.com/apps/#/register)하면 발급되는 값입니다.

![Issue ClientID and ClientSecret](/tb000_media/1-1.png)
위와 같이 **애플리케이션 이름**을 프로젝트명과 동일하게 작성한 다음, **사용 API**를 **검색**으로 설정합니다. 마지막으로 **비로그인 오픈API 서비스 환경**에서 **iOS 설정**을 추가한 다음, Xcode 프로젝트 생성 시 **애플리케이션의 Bundle ID**를 정확하게 입력합니다.   


#### 클라이언트 아이디와 클라이언트 시크릿
애플리케이션 등록을 마치고 나면, [내 애플리케이션](https://developers.naver.com/apps/#/list) 항목 아래 등록한 애플리케이션의 목록이 나타납니다. 자신의 애플리케이션명을 클릭하면, 애플리케이션 정보가 나타나며, 자신의 **클라이언트 아이디**와 **클라이언트 시크릿**을 확인할 수 있습니다.
![Check CliendID and ClientSecret](/tb000_media/1-2.png)


#### 코드
먼저, [Model.swift](https://github.com/gfsusan/NaverAPIExample/blob/master/NaverAPIExample/NaverAPIExample/Model.swift)를 만들어 `Movie` 클래스를 만들어 줍니다.

``` Swift
import Foundation
import UIKit

class Movie {
    var title:String?
    var link:String?
    var imageURL:String?
    var image:UIImage?
    var pubDate:String?
    var director:String?
    var actors:String?
    var userRating:String?

    init() {

    }
}
```

모든 속성은 `Movie` 객체를 생성한 후에 값을 입력해줄 것이기 때문에, Optional로 처리합니다.   


두 번째는 [SearchViewController.swift](https://github.com/gfsusan/NaverAPIExample/blob/master/NaverAPIExample/NaverAPIExample/SearchViewController.swift)입니다.
``` Swift
class SearchViewController: UIViewController {
    @IBAction func searchButtonPressed(_ sender: Any) {
        if let query = searchTextField.text {
            performSegue(withIdentifier: "searchSegue", sender: self)
        }
    }

    // MARK: - Navigation
    override func prepare(for segue: UIStoryboardSegue, sender: Any?) {
        // Get the new view controller using segue.destinationViewController.
        // Pass the selected object to the new view controller.
        if let moviesVC = segue.destination as? MoviesTableViewController {
            if let text = searchTextField.text {
                moviesVC.queryText = text
            }
        }
    }

}
```

먼저 `SearchVC`에서 `MoviesTableVC`로 향하는 `segue`를 연결해두고, '검색' 버튼을 눌렀을 때 `segue`를 실행합니다. `prepareForSegue()` 메소드에서는 `MoviesTableVC`의 `queryText` 필드에 텍스트 필드의 내용을 저장해줌으로써 다음 뷰로 검색어를 넘겨줍니다.  

검색어를 입력 받고 결과를 표시하는 방법으로 뷰에 Search Bar를 만들어 두고  `UISearchController`를 이용하는 방법이 있습니다. 이 방법을 사용하면 한 개의 뷰에서 검색어를 입력하고 그 결과를 받아올 수 있습니다. 하지만 이번 블로그에서는 네이버 API를 사용하여 HTML 요청을 전송하는 방법에 초점을 맞추기 위해서 검색어를 입력하는 부분과 검색 결과를 출력하는 부분을 분리하였습니다. `UISearchController`에 대한 정보를 더 얻고 싶으시다면 [Apple Developer](https://developer.apple.com/documentation/uikit/uisearchcontroller) 페이지를 참고하시기 바랍니다.


세 번째는 [MoviesTableViewController.swift](https://github.com/gfsusan/NaverAPIExample/blob/master/NaverAPIExample/NaverAPIExample/MoviesTableViewController.swift)입니다.
``` Swift
class MoviesTableViewController: UITableViewController, XMLParserDelegate{
    let clientID        = "huN1_ueBcLHV9AnTNwpi"    // ClientID
    let clientSecret    = "kb3OGCZ9rC"              // ClientSecret

    var queryText:String?                  // SearchVC에서 받아 오는 검색어
    var movies:[Movie]      = []           // API를 통해 받아온 결과를 저장할 array

    var strXMLData: String?         = ""   // xml 데이터를 저장
    var currentTag: String?  	    = ""   // 현재 item의 element를 저장
    var currentElement: String      = ""   // 현재 element의 내용을 저장
    var item: Movie?                = nil  // 검색하여 만들어지는 Movie 객체
}
```
우선, 위와  같이 `MoviesTableViewController`에게 `XMLParserDelegate` 프로토콜을 적용합니다.  
다음으로 네이버 개발자 센터에서 발급받은 **클라이언트 아이디**와 **클라이언트 시크릿**을 변수에 저장합니다.


#### XML 데이터의 예
``` xml
< HTTP/1.1 200 OK
< Server: nginx
< Date: Mon, 26 Sep 2016 01:39:37 GMT
< Content-Type: text/xml;charset=utf-8
< Transfer-Encoding: chunked
< Connection: keep-alive
< Keep-Alive: timeout=5
< Vary: Accept-Encoding
< X-Powered-By: Naver
< Cache-Control: no-cache, no-store, must-revalidate
< Pragma: no-cache
<
<?xml version="1.0" encoding="UTF-8"?>
<rss version="2.0">
    <channel>
        <title>Naver Open API - blog ::'리뷰'</title>
        <link>http://search.naver.com</link>
        <description>Naver Search Result</description>
        <lastBuildDate>Mon, 26 Sep 2016 10:39:37 +0900</lastBuildDate>
        <total>8714891</total>
        <start>1</start><display>10</display>
        <item>
            <title>명예훼손 없이 <b>리뷰</b>쓰기</title>
            <link>http://openapi.naver.com/l?AAABWLyw6CMBREv+ayNJe2UrrogvJwg8aYKGvACiSUalNR/t6azGLO5Mzrrd0moVSQJZDl/6I4KIxGpx9y9P4JNANShXSzHXZLu2q3660Jw2bt0k1+aF1rgFYXfZ+c7j3QorYDkCT4JxuIEEyRUYGcxpGXMeMs3VPBOUEWGXntynUW03k7ohBYfG+mOdRqbPL6E84/apnqgaEAAAA=</link>
            <description>명예훼손 없이 <b>리뷰</b>쓰기 우리 블로그하시는 분들께는 꽤 중요한 내용일 수도 있습니다 그것도 주로 <b>리뷰</b> 위주로 블로그를 진행하신 분이라면 더욱 더 말이죠
                오늘 포스팅은, 어떻게 하면 객관적이고 좋은 <b>리뷰</b>를... </description>
            <bloggername>건짱의 Best Drawing World2</bloggername>
            <bloggerlink>http://blog.naver.com/yoonbitgaram</bloggerlink>
            <postdate>20161208</postdate>
        </item>
        ...
    </channel>
</rss>
```

`strXMLData`에는 https://openapi.naver.com 에 요청한 쿼리에 대한 응답인 xml 데이터가 저장됩니다. **xml 데이터**는 위와 같은 형식으로 이루어져 있습니다. 우리가 주의 깊게 볼 부분은 `<item>` 태그로 둘러싸여 있는 부분입니다. title, link, subtitle, pubDate, director, actor, userRating 등에 해당하는 내용을 **element**라고 부르며, 각 element는 `<title>리틀 포레스트</title>`과 같이 **태그**로 둘러싸여 있습니다. 이제 이 데이터를 Parse(분석, 또는 쪼갬)하여 `Movie`객체를 생성할 것입니다. `currentTag`는 현재 tag를 알려주는 변수이고, `currentElement`은 현재 element에 해당하는 데이터를 저장하게 될 변수입니다. `item`은 `Movie`의 객체로, 한 개의 `item`을 Parsing에 성공하면 하나의 객체가 완성되는 것입니다.

#### XML 파서의 종류
XML 문서 내의 데이터를 읽어내는 XML 파서는 SAX(XML용 간편 API) 타입과 DOM(문서객체모델) 타입이 있습니다.
#####1. SAX(Simple API for XML)
SAX 타입의 파서는 이름 그대로 간단한 API를 제공하며, 순차적으로 XML 문서의 내용을 파싱합니다. iOS SDK에서 기본적으로 제공되는 클래스인 `XMLParser`가 SAX 타입의 파서입니다.

#####2. DOM(Document Object Model)
DOM 타입의 파서는 문서 전체를 읽어 메모리에 트리 구조로 올려 놓고 원하는 요소(Element)에 바로 접근할 수 있도록 만든 파서입니다. DOM 타입의 파서는 iPhone SDK의 파운데이션 프레임워크에 없습니다. 따라서 DOM 타입의 파서를 사용하기 위해서는 조금 더 하위 수준의 libxml2를 이용하거나, 외부 라이브러리를 이용해야 합니다.

SAX 타입은 XML 데이터를 순차적으로 읽어나가면서 원하는 요소를 걸러내도록 되어 있기 때문에 거추장스럽고 시간은 많이 걸리지만 사용하는 메모리 양은 적은 편이며, DOM 타입은 그 반대로 빠르지만 메모리를 많이 사용합니다. 이번 애플리케이션에서는 적은 메모리를 사용할 수 있도록 SAX 타입의 `XMLParser`를 사용하도록 하겠습니다.

####코드
##### searchMovies()
``` Swift
    func searchMovies() {
        // movies 초기화
        movies = []

        // queryText가 없으면 return
        guard let query = queryText else {
            return
        }

        let urlString = "https://openapi.naver.com/v1/search/movie.xml?query=" + query
        let urlWithPercentEscapes = urlString.addingPercentEncoding(withAllowedCharacters: NSCharacterSet.urlQueryAllowed)
        let url = URL(string: urlWithPercentEscapes!)

        var request = URLRequest(url: url!)
        request.addValue("application/xml; charset=utf-8", forHTTPHeaderField: "Content-Type")
        request.addValue(clientID, forHTTPHeaderField: "X-Naver-Client-Id")
        request.addValue(clientSecret, forHTTPHeaderField: "X-Naver-Client-Secret")

        let task = URLSession.shared.dataTask(with: request) { data, response, error in
            // 에러가 있으면 리턴
            guard error == nil else {
                print(error)
                return
            }

            // 데이터가 비었으면 출력 후 리턴
            guard let data = data else {
                print("Data is empty")
                return
            }

            // 데이터 초기화
            self.item?.actors = ""
            self.item?.director = ""
            self.item?.imageURL = ""
            self.item?.link = ""
            self.item?.pubDate = ""
            self.item?.title = ""
            self.item?.userRating = ""

            // Parse the XML
            let parser = XMLParser(data: Data(data))
            parser.delegate = self
            let success:Bool = parser.parse()
            if success {
                print(self.strXMLData)
            } else {
                print("parse failure!")
            }
        }
        task.resume()
    }

```
**10-12**: 요청 텍스트를 담아 `url`을 생성합니다. Line 10의 코드를 작성하는 이유는 `query` 문자열 안에 url에 허용되지 않는 문자가 들어있을 때 인코딩을 통해서 HTTP 요청을 보낼 때 문제가 생기지 않도록 하는 것입니다.   
**14-17**: `URLRequest`를 생성합니다. URL 요청에는 앞서 발급받은 클라이언트 아이디와 클라이언트 시크릿을 함께 전송합니다.  
**19-30**: URL Connection `Task`를 생성합니다. 에러가 있거나, 데이터가 비어있으면 리턴합니다. 그리고 `item`을 초기화합니다.  
**42-49**: `parse()` 메소드를 호출하여 xml parsing을 시작합니다. `parse()`메소드를 호출하게 되면, `parserDidStartElement()`, `parserFoundCharacters()`, `parserDidEndElement()` 메소드가 차례로 호출됩니다.  



##### parserDidStartElement()
``` Swift
    func parser(_ parser: XMLParser, didStartElement elementName: String, namespaceURI: String?, qualifiedName qName: String?, attributes attributeDict: [String : String] = [:]) {
        if elementName == "title" || elementName == "link" || elementName == "image" || elementName == "pubDate" || elementName == "director" || elementName == "actor" || elementName == "userRating" {
            currentElement = ""
            if elementName == "title" {
                item = Movie()
            }
        }
    }
```
이 메소드는 parser가 시작태그를 발견했을 때 호출됩니다. 태그는 `elementName`에 매개변수로 주어집니다. 태그가 title, link, image, pubDate, director, actor, 또는 userRating과 일치하면 `currentElement`를 초기화하고, 첫 번째 태그인 title과 일치하면 새로운 Movie 객체를 생성합니다.



##### parserFoundCharacers()
``` Swift
    func parser(_ parser: XMLParser, foundCharacters string: String) {
        currentElement += string
    }
```
이 메소드는 `parserDidStartElement()` 다음으로 호출됩니다. 시작 태그를 인식한 후 데이터를 읽었음을 의미하는데, 간단하게 `currentElement`에 `string`의 내용을 덧붙여줍니다.



##### parserDidEndElement()
``` Swift
    func parser(_ parser: XMLParser, didEndElement elementName: String, namespaceURI: String?, qualifiedName qName: String?) {
        if elementName == "title" {
            item?.title = currentElement.replacingOccurrences(of: "<[^>]+>", with: "", options: .regularExpression, range: nil)
        } else if elementName == "link" {
            item?.link = currentElement
        } else if elementName == "image" {
            item?.imageURL = currentElement
        } else if elementName == "pubDate" {
            item?.pubDate = currentElement
        } else if elementName == "director" {
            item?.director = currentElement
            if item?.director != "" {
                item?.director?.removeLast()
            }
        } else if elementName == "actor" {
            item?.actors = currentElement
            if item?.actors != "" {
                item?.actors?.removeLast()
            }
        } else if elementName == "userRating" {
            item?.userRating = currentElement
            movies.append(self.item!)
            DispatchQueue.main.async {
                self.tableView.reloadData()
            }
        }
    }
```
이 메소드는 `parserFoundCharaters()` 다음으로 호출되며, 끝 태그를 인식했다는 의미입니다. 이 메소드에서는 현재 태그에 해당하는 Movie의 속성을 지정해줍니다. 예를 들어, </title>을 발견했으면 `item?.title = currentElement`을 해줍니다. Line 3에서 *replacingOccurrences*를 해주는 것은 검색API에서 검색어와 일치하는 문자열을 볼드체 태그로 감싸서 응답을 주기 때문에 태그를 제거해 주는 작업입니다.  
**10-14**와 **15-19** 같은 경우에는 다수의 인물을 구분하기 위해 "|" 문자를 구별자로 사용하는데, 문자열의 마지막에 불필요한 "|"를 삭제해주는 작업입니다.   
**20-25**에는 `item`을 `movies` 배열에 추가해주고, 테이블뷰를 새로고침합니다. `DispatchQueue.main.async`에 대해서는 **STEP 2** 에서 다룹니다.



### STEP 2. 비동기 작업
다음은 **비동기 작업**에 대해서 알아봅시다.
쇼핑 애플리케이션 사용 경험을 떠올려 보면, 테이블 뷰에 콘텐츠가 로딩된 후, 상품 이미지가 하나 둘 씩 나타나는 것을 보신 적이 있을 것입니다. 이는 웹으로부터 사진을 다운로드하느라 뷰가 늦게 로딩되는 것을 방지하기 위해서, 기본 이미지를 먼저 띄워 놓고, 백그라운드에서 이미지 다운로드가 완료되는 즉시 이미지를 뷰에 나타내는 것입니다. 따라서 비동기 작업 큐(Queue)에 사진 다운로드와 같은 작업을 넣어 두고, 뷰(UI)가 먼저 로딩된 후에 차례로 다운로드 작업을 완료해 나가는 것입니다.   
이번 단계에서는 `MoviesTableVC`가 로딩된 이후에 차례로 영화의 포스터 이미지를 다운로드 받아 테이블 뷰에 표시하는 기능을 구현할 것입니다. 우선 [Model.swift](https://github.com/gfsusan/NaverAPIExample/blob/master/NaverAPIExample/NaverAPIExample/Model.swift)의 `getPosterImage()` 메소드를 구현하고, [MoviesTableViewController.swift](https://github.com/gfsusan/NaverAPIExample/blob/master/NaverAPIExample/NaverAPIExample/MoviesTableViewController.swift)의 `tableView(cellForRowAt)` 메소드를 살펴봅시다.


##### Model.swift
``` Swift
    func getPosterImage() {
        guard imageURL != nil else {
            return nil
        }
        if let url = URL(string: imageURL!) {
            if let imgData = try? Data(contentsOf: url) {
                if let image = UIImage(data: imgData) {
		    self.image = image
                }
            }
        }
        return
    }
```
여기서는 `movie` 객체의 `imageURL`이 존재하는지 먼저 확인한 다음, `imageURL`을 가지고 `URL` 객체를 생성하여 이를 가지고 이미지 데이터를 불러옵니다. 이미지 데이터를 사용해서 `UIImage`를 생성하고, `self.image`에 저장합니다.  


##### MoviesTableViewController.swift의 `cellForRowAt()` 메소드
``` Swift
// 포스터 이미지를 다운로드하는 DispatchQueue 생성
let posterImageQueue = DispatchQueue(label: "posterImage")

    override func tableView(_ tableView: UITableView, cellForRowAt indexPath: IndexPath) -> UITableViewCell {
        let cell = tableView.dequeueReusableCell(withIdentifier: "movieCellIdentifier", for: indexPath) as! MoviesTableViewCell
        let movie = movies[indexPath.row]

        // cell 구성 부분 생략

        // Async activity
        // 영화 포스터 이미지 불러오기
        if let posterImage = movie.image {
            cell.posterImageView.image = posterImage
        } else {
            cell.posterImageView.image = UIImage(named: "noImage")
            posterImageQueue.async(execute: {
                movie.getPosterImage()
                guard let thumbImage = movie.image else {
                    return
                }
                DispatchQueue.main.async {
                    cell.posterImageView.image = thumbImage
                }
            })
        }
        return cell
    }

```
**1-2**: 포스터 이미지를 다운로드하기 위한 비동기 작업 큐를 생성합니다. 큐의 레이블은 "posterImage"로 하겠습니다.
**12-13**: `image`가 이미 존재하면 즉시 이미지를 `cell`에 나타냅니다.  
**14-17**: 이미지가 다운로드 되어 있지 않으면, 디폴트 이미지를 `cell`에 먼저 나타내고 `posterImageQueue`에 이미지 다운로드 작업을 넣습니다.
**18-20**: 이미지 다운로드에 실패했을 경우를 대비하여 `thumbImage`에 guard를 두어 해당 블럭을 빠져나가도록 합니다.
**21-23**: 이미지 다운로드 작업이 완료되면 포스터 이미지를 `cell`에 나타내는 작업을 `main` 큐에 넣습니다. 뷰(View) 업데이트 작업은 `main` 큐에서 하도록 [Apple Developer](https://developer.apple.com/documentation/code_diagnostics/main_thread_checker)에 명시되어 있는데, 뷰 업데이트 작업을 메인 큐가 아닌 곳에서 했을 때 뷰가 업데이트 되지 않는 현상, 데이터 결함, 앱 충돌 등의 현상이 발생할 수 있기 때문입니다.


### STEP 3. SFSafariViewController 사용
이제 셀을 터치했을 때 영화의 세부정보를 볼 수 있는 사파리 뷰를 구성할 차례입니다.

##### MoviesTableViewController.swift
``` Swift
override func tableView(_ tableView: UITableView, didSelectRowAt indexPath: IndexPath) {
    if let urlString = movies[indexPath.row].link {
        if let url = URL(string: urlString) {
            let svc = SFSafariViewController(url: url)
            self.present(svc, animated: true, completion: nil)
        }
    }
}
```
**3**: 해당 인덱스의 `movie` 객체의 urlString에 해당하는 주소를 가지고 `URL` 객체를 생성합니다.
**4**: `SFSafariViewController` 객체를 생성합니다. 사파리 뷰에서 영화 내용을 띄울 수 있도록 앞서 만든 `URL` 객체를 생성자에 기입합니다.
**5**: 생성한 사파리 뷰를 Modal로 띄워 줍니다.



## 마치며
지금까지 네이버 오픈API 중 '영화 검색'기능을 사용하는 방법에 대해서 배웠습니다. 이외에도 네이버에서 제공하는 오픈API에는 네아로(네이버 아이디로 로그인), 지도, 검색이 있으며, Clova의 음성 인식 기술과 음성 합성 기술, 얼굴 인식 기술, Papago의 기계 번역 기술 등 여러가지가 있습니다. 이 기술 블로그를 바탕으로 여러분의 애플리케이션을 더욱 더 발전시켜 보시기 바랍니다! :)


iPhoneSDK 튜토리얼 2, 2012년 4월, 윤성관 고준일) 참조
