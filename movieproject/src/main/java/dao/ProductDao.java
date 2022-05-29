package dao;

import java.sql.Statement;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONObject;

import dto.Cart;
import dto.Order;
import dto.OrderDetail;
import dto.Product;

public class ProductDao extends Dao{
// 수정 필요
	public ProductDao() {
		super(); // 슈퍼클래스 호출 ( db연동 )
			// super.메소드()  super.필드명	   super() : 생성자
	}
	public static ProductDao productDao = new ProductDao();
	public static ProductDao getproductDao() { return productDao; }
	
	
	// 1. 제품 등록 
			public boolean psave(Product p) { 
				String sql = "insert into product(pname, pprice, pimg) values(?,?,?)";
				try {
					ps = con.prepareStatement(sql);
					ps.setString(1, p.getPname());
					ps.setInt(2, p.getPprice());
					ps.setString(3, p.getPimg());
					ps.executeUpdate();
					return true;
				}catch(Exception e) {e.printStackTrace();}
				
				return false;
	}
			// 2. 제품 모든 호출
			public ArrayList<Product> getproductlist() { 
				ArrayList<Product> list = new ArrayList<Product>();
				String sql = "select * from product";
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while(rs.next()) {
						Product p = new Product
								(rs.getInt(1), rs.getString(2),
								 rs.getInt(3), rs.getString(4)
								);
						list.add(p);
					}
					return list;
				}catch(Exception e) {e.printStackTrace();}
				return null; 
				}
			// 3. 제품 개별 호출 
			public Product getproduct(int pno) {
				String sql = "select * from product where pno=" + pno;
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while(rs.next()) {
						Product p = new Product
								(rs.getInt(1), rs.getString(2),
								 rs.getInt(3), rs.getString(4)
								);
						return p;
					}
					
				}catch(Exception e) {e.printStackTrace();} 
				return null; }
			
			// 4. 제품 수정
			
			
			// 5. 제품 삭제
			
	
			
			///// 장바구니
			
			public boolean savecart(Cart cart) {
				String sql = "select cartno from cart where mno = "+cart.getMno();

				
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					if(rs.next()) { // 1. 장바구니내 동일한 제품 존재시 수량 업데이트 처리
						sql = "update cart set totalamount = ? where cartno = ?";
						ps = con.prepareStatement(sql);
						ps.setInt(1, cart.getTotal_amount());
						ps.setInt(2, rs.getInt(1));
						ps.executeUpdate();
						return true;
					}
					else {
						sql = "insert into cart(totalamount, totalprice, mno) values(?,?,?)";
						ps = con.prepareStatement(sql);
						ps.setInt(1, cart.getTotal_amount());
						ps.setInt(2, cart.getTotal_price());
						ps.setInt(3, cart.getMno());
						ps.executeUpdate();
						return true;
					}
					// 2. 존재하지 않으면 등록
				}catch(Exception e) {e.printStackTrace();}
				return false;
			}
			//
			public JSONArray getcart(int mno) {
				JSONArray jsonArray = new JSONArray();
				String sql = "select "
						+ "	A.cartno as 장바구니번호 , "
						+ "    A.totalamount as 구매수량 , "
						+ "    A.totalprice as 총가격 , "
						+ "    B.scolor as 색상 ,  "
						+ "    B.ssize as 사이즈 , "
						+ "    B.pno as 제품번호 ,	 "
						+ "    C.pname as 제품명 , "
						+ "    C.pimg as 제품이미지 "
						+ "from cart A "
						+ "join stock B "
						+ "on A.sno = B.sno "
						+ "join product C "
						+ "on B.pno = C.pno "
						+ "where A.mno ="+mno;
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while(rs.next()) {
						// 결과내 하나씩 모든 레코드를 -> 하나씩 json 객체로 변환
						JSONObject object = new JSONObject();
						object.put("cartno", rs.getInt(1));
						object.put("totalamount", rs.getInt(2) );
						object.put("totalprice", rs.getInt(3) );
						object.put("scolor", rs.getString(4) );
						object.put("ssize", rs.getString(5)) ;
						object.put("pno", rs.getInt(6) );
						object.put("pname", rs.getString(7));
						object.put("pimg", rs.getString(8));
						jsonArray.put(object);
					}
					
					return jsonArray;
				}catch(Exception e) {e.printStackTrace();}
				return null;
			}	
			
			public boolean updatecart(int cartno, int samount, int totalpirce) {
				try {
					String sql = "update cart set totalamount = ?, totalprice = ? where cartno = ?"; 
					ps = con.prepareStatement(sql);
					ps.setInt(1, samount);
					ps.setInt(2, totalpirce);
					ps.setInt(3, cartno);
					ps.executeUpdate();
					return true;
				}catch(Exception e) {e.printStackTrace();}
				return false;
			}
			public boolean deletecart(int cartno) {
				String sql = "delete from cart where cartno = ?";
				try {
					ps = con.prepareStatement(sql);
					ps.setInt(1, cartno);
					ps.executeUpdate();
					return true;
				}catch(Exception e) {e.printStackTrace();}
				return false;
			}
			///////////////////////////////// 주문 ///////////////////////////////
			public boolean ordersave(Order order) {
				String sql = "insert into porder(ordername, orderphone, orderaddress, ordertotalpay, orderrequest, mno)"
						+ "values(?,?,?,?,?,?)";
				try {									// insert 후에 자동 생성한 pk 값 
					ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				ps.setString(1, order.getOrdername());
				ps.setString(2, order.getOrderphone());
				ps.setString(3, order.getOrderaddress());
				ps.setInt(4, order.getOrdertotalpay());
				ps.setString(5, order.getOrdereqeust());
				ps.setInt(6, order.getMno());
				ps.executeUpdate();
				rs = ps.getGeneratedKeys(); // pk값 호출
				if(rs.next()) {
					// cart -> porderdetail
					int pk = rs.getInt(1);
					sql = "insert into porderdetail (samount, totalprice, orderno, sno)" + 
							"select totalamount , totalprice , " +pk+ " , sno from cart where mno = " + order.getMno();
					ps = con.prepareStatement(sql);
					ps.executeUpdate();
					
					// cart -> delete
					sql = "delete from cart where mno = " + order.getMno();
					ps = con.prepareStatement(sql);
					ps.executeUpdate();
					
					return true;
				}
				}catch(Exception e) {e.printStackTrace();}
				return false;
			}
			
			public JSONArray getorder(int mno) {
				try {
					String sql = "SELECT "
							+ "	A.orderno as 주문번호 , "
							+ "    A.orderdate as 주문일 , "
							+ "    B.orderdetailno as 주문상세번호 , "
							+ "    B.orderdetailactive as 주문상세상태 , "
							+ "    B.samount as 주문상세수량 , "
							+ "    C.sno as 재고번호 , "
							+ "    C.scolor as 색상 , "
							+ "    C.ssize as 사이즈 , "
							+ "    D.pno as 제품번호 , "
							+ "    D.pname as 제품명 ,"
							+ "    D.pimg as 제품사진 "
							+ "FROM "
							+ "porder A JOIN porderdetail B on A.orderno = B.orderno "
							+ "JOIN STOCK C on B.sno = C.sno "
							+ "JOIN product D ON C.pno = D.pno where A.mno = "+mno+" order by A.orderno desc;";
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery(); 
					// 1. json 사용하는 이유 -> js로 전송하기위해 
					// 2. Arraylist 사용하는 이유 -> jsp로 사용할려면 
					
					JSONArray parentlist = new JSONArray();  // 상위 리스트 [ 여러개의 하위 리스트 ] 
					
					JSONArray childlist = new JSONArray();	// 하위 리스트 
					
					int oldorderno = -1; // 이전 데이터의 주문번호 변수 
					
					while( rs.next() ) {
						// 데이터 json 객체
						JSONObject jsonObject = new JSONObject();
						jsonObject.put( "orderno" , rs.getInt( 1 ) ) ;
						jsonObject.put( "orderdate" , rs.getString( 2 ) ) ;
						jsonObject.put( "orderdetailno" , rs.getInt( 3 ) ) ;
						jsonObject.put( "orderdetailactive" , rs.getInt( 4 ) ) ;
						jsonObject.put( "samount" , rs.getInt( 5 ) ) ;
						jsonObject.put( "sno" , rs.getInt( 6 ) ) ;
						jsonObject.put( "scolor" , rs.getString( 7 ) ) ;
						jsonObject.put( "ssize" , rs.getString( 8 ) ) ;
						jsonObject.put( "pno" , rs.getInt( 9 ) ) ;
						jsonObject.put( "pname" , rs.getString( 10 ) ) ;
						jsonObject.put( "pimg" , rs.getString( 11 ) ) ;
						
						// 동일한 주문번호 이면 동일한 리스트에 담기 
						//   {  키 : 값  }		
						//   { 키 : [  ]  ,  키 : [  ]  , 키  , [ ] }
						if( oldorderno == rs.getInt( 1 ) ){ // 이전 주문번호와 현재 주문번호 동일하면
							childlist.put( jsonObject ); // 하위 리스트에 데이터 담기 
						}else { // 동일하지 않으면
							childlist = new JSONArray(); // 하위 리스트 초기화 
							childlist.put( jsonObject ); // 하위 리스트에 데이터 담기 
							parentlist.put( childlist ); // 상위 리스트에 하위 리스트 추가 
						}
						oldorderno = rs.getInt( 1 ); // 이전 주문번호 변수에 현재 주문번호 넣기 
					}
					return parentlist;
				}catch(Exception e) {e.printStackTrace();}
				return null;
			}
			
			public boolean cancelorder(int orderdetailno, int active) {
				try {
					String sql = "update porderdetail set orderdetailactive = ? where orderdetailno = ?";
					ps = con.prepareStatement(sql);
					ps.setInt(1, active);
					ps.setInt(2, orderdetailno);
					ps.executeUpdate();
					return true;
				}catch(Exception e) {e.printStackTrace();}
				return false;
			}
			
			public JSONArray getchart( int type , int value  ) {
				String sql ="";
				JSONArray ja = new JSONArray();
				
				if( type == 1 ) { // 일별 매출 
					sql ="SELECT "
						+ "	substring_index( orderdate , ' ' , 1 ) AS 날짜 , "
						+ "	sum( ordertotalpay ) "
						+ "FROM porder "
						+ "GROUP BY 날짜 ORDER BY 날짜 DESC";
				}else if( type == 2 ) { // 카테고리별 전체 판매량 
					sql = "select  "
							+ "	sum( A.samount )  ,  "
							+ "    D.cname "
							+ "from porderdetail A, stock B , product C , category D  "
							+ "where A.sno = B.sno and B.pno = C.pno and C.cno = D.cno  "
							+ "group by D.cname "
							+ "order by orderdetailno desc";
				}else if( type == 3 ) { // 재고번호 -> 제품별 판매량 추이
					sql = "select "
							+ "	substring_index(  A.orderdate , ' ' , 1 ) as 날짜, "
							+ "	sum( B.samount ) as 총판매수량 "
							+ "from porder A , porderdetail B , stock C "
							+ "where A.orderno = B.orderno and B.sno = C.sno and C.pno =  ( select pno from stock where sno = " +value+ " ) "
							+ "group by 날짜 order by 날짜 desc";
				}
				try {
					ps = con.prepareStatement(sql);
					rs = ps.executeQuery();
					while( rs.next() ) {
						JSONObject jo = new JSONObject();
						if( type == 1 || type == 3  ) {
							jo.put("date", rs.getString( 1 ) );
							jo.put("value", rs.getInt(2) );
							ja.put( jo );
							if(type==3) {
							System.out.println("오늘의 판매량" + jo);
							}
						}else if( type == 2 ) {
							jo.put("value", rs.getInt( 1 ) );
							jo.put("category", rs.getString(2) );
							ja.put(jo);
						}
					}
					return ja;
				}catch (Exception e) { System.out.println( e );} return null;
			}
			
			// 1. 오늘 주문상세 호출 
			public ArrayList<OrderDetail> getorderdetail(){
				
				String sql = "select "
						+ "	A.* , substring_index( B.orderdate , ' ' , 1 ) as 날짜 "
						+ "from  porderdetail A , porder B "
						+ "where A.orderno = B.orderno "
						+ "and substring_index( B.orderdate , ' ' , 1 ) = substring_index( now() , ' ' , 1 ) "
						+ "and  A.orderdetailactive = 3";
				try {
					ps = con.prepareStatement(sql);
					rs  = ps.executeQuery();
					ArrayList<OrderDetail> list = new ArrayList<OrderDetail>();
					while( rs.next() ) {
						OrderDetail ordertail = new OrderDetail();
						ordertail.setOrderdetailno(  rs.getInt(1)  );
						ordertail.setOrderdetailacitve(rs.getInt(2) );
						ordertail.setSno(rs.getInt(3));
						ordertail.setSamount(rs.getInt(4) );
						ordertail.setTotalprice(rs.getInt(5));
						ordertail.setOrderno(rs.getInt(6));
						list.add(ordertail);
					}
					return list;
				}catch (Exception e) {} return null;
				
			}
		}
	

