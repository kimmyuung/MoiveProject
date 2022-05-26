package controller.product;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;

import dao.MemberDao;
import dao.ProductDao;
import dto.Order;

/**
 * Servlet implementation class saveorder
 */
@WebServlet("/product/saveorder")
public class saveorder extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public saveorder() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mid = (String) request.getSession().getAttribute("login");
		int mno = MemberDao.getmemberDao().getmno(mid);
		
		String json = request.getParameter("orderjson");
		try {
		JSONObject jo = new JSONObject(json); // json 객체형 변환
		String ordername= jo.getString("ordername");
		String orderphone = jo.get("orderphone").toString();
		String orderaddress = jo.get("orderaddress").toString();
		int totalpay = jo.getInt("ordertotalpay");
		String orderrequest = jo.get("orderrequest").toString();
		
		Order order = new Order(0, null, ordername, orderphone, orderaddress, totalpay, 0, orderrequest, 0, mno);

		// 주문 db처리
		boolean result = ProductDao.getproductDao().ordersave(order);
		
		response.getWriter().print(result);
		}catch(Exception e) {e.printStackTrace();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
