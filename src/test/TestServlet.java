package test;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录的servlet
 * Servlet implementation class TestServlet
 */
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     */
    public TestServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 
		
	
		
		//response.setCharacterEncoding("GBK");
		
		String username = request.getParameter("username");
		String password =request.getParameter("password");
		// 检查账号密码是否正确
		UserDao userDao =new UserDao();
		User user =userDao.login(username, password);
		request.getSession().setAttribute("username", username);
		if (user!=null) {
			// 返回到页面
			request.getRequestDispatcher("indexsuccess.jsp").forward(request,response);
		}else {
			request.getRequestDispatcher("index.jsp").forward(request,response);
		}
	

	}	

}
