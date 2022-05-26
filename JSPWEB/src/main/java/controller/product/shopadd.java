package controller.product;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;

import dao.MemberDao;
import dao.ProductDao;
import dto.Cart;
import dto.Stock;

/**
 * Servlet implementation class shopadd
 */
@WebServlet("/product/shopadd")
public class shopadd extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public shopadd() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");

		// 1. json 형식 문자열 통신 호출
		String json = request.getParameter("json");
		int i = 0;
		int error = -1;
		try {
			int pno = Integer.parseInt(request.getParameter("pno"));
			// 1. 통신할 데이터를 JSONArray형으로 형변환 (데이터가 하나라면 쓰지 않아도 됨)
			JSONArray jsonArray = new JSONArray(json);
			// 2. 반복문 이용한 jsonarray에서 jsonobject 호출
			for (i = 0; i < jsonArray.length(); i++) {
				// 3. jsonarray 배열내 i번째 객체 호출
				JSONObject jsonObject = jsonArray.getJSONObject(i);
				// 4. 해당 객체에 키를 이용한 값 호출

				String mid = (String) request.getSession().getAttribute("login");
				int mno = MemberDao.getmemberDao().getmno(mid);
				int amount = Integer.parseInt(jsonObject.get("amount").toString());
				int totalprice = Integer.parseInt(jsonObject.get("totalprice").toString());
				// json객체명.get(키) -> 반환타입 Object -> String -> int

				ArrayList<Stock> list = ProductDao.getproductDao().getStock(pno);
				int sno = 0;
				String color = jsonObject.get("color").toString();
				String size = jsonObject.get("size").toString();

				for (Stock s : list) {
					if (s.getSsize().equals(size) && s.getScolor().equals(color)) {
						sno = s.getSno();
					}
				}

				Cart cart = new Cart(0, sno, totalprice, amount, pno, mno);
				System.out.println(cart.toString());
				boolean result = ProductDao.getproductDao().savecart(cart);

				if (result == false) {
					error = i;
				}
			}
			if (error == -1) {
				response.getWriter().print(-1);
			} else {
				response.getWriter().print(i);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
