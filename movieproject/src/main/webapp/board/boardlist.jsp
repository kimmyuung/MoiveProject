<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../header.jsp" %>

<br></br><br></br>
         <section class="mt-4 mb-3 pt-4 pb-4" style="max-width:1080px;">
            <p class="lead">공지사항</p>
            <hr>
             <!-- 테이블 형태의 공지사항 작성 -->
            <table class="table table-striped">
              <thead>
                <tr>
                  <th class="mobile" style="width:55px; text-align:center;">번호</th>
                  <th style="text-align:center;">제목</th>
                  <th class="mobile" style="width:80px; text-align:center;">작성자</th>
                  <th class="mobile" style="width:120px; text-align:center;">날짜</th>
                </tr>
              </thead>
              <tbody>
                <tr>
                 <!-- 글의 순서에 따라 번호를 붙이는 게시물 형식 만들기 -->
                  <td style="text-align: center;">3</td>
                  <td>신규 영화 시사회 참여자를 모집합니다.</td>
                  <td style"text-align: center;">운영자</td>
                  <td style="text-align: center;">2018-05-05</td>
                </tr>
                <tr>
                  <td style="text-align: center;">2</td>
                  <td>영화 예매 웹 사이트에 오신 것을 환영합니다.</td>
                  <td style="text-align: center;">운영자</td>
                  <td style="text-align: center;">2018-05-04</td>
                </tr>
                <tr>
                  <td style="text-align: center;">1</td>
                  <td><a href="qna.jsp">많이 묻는 질문</a></td>
                  <td style="text-align: center;">운영자</td>
                  <td style="text-align: center;">2018-05-03</td>
                </tr>
              </tbody>
            </table>
          </section>
          <%@include file="../footer.jsp" %>
</body>
</html>