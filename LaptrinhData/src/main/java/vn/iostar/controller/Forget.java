package vn.iostar.controller;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.model.Usermodel;
import vn.iostar.service.UserService;
import vn.iostar.service.ipl.UserServiceipl;



@WebServlet(urlPatterns= { "/forget"})
public class Forget extends HttpServlet {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	UserService service = new UserServiceipl();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    String npassword = req.getParameter("npassword");
	    Usermodel user = null ; 
	    try {
	    	user = service.findbyusername(username);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    String alertMsg = "";
	    if (user != null) 	    
	    {
	    	if (password.trim().equals(npassword.trim())) 
	    	{
	    		service.forget(username,password);
		    	req.getRequestDispatcher("/views/loginw.jsp").forward(req, resp);
	    	}
	    	else 
	    	{
	    		alertMsg = "Mật khẩu mới không trùng nhau";
		    	req.setAttribute("alert", alertMsg);	
				req.getRequestDispatcher("/views/forget.jsp").forward(req, resp);
	    	}    	
	    }
	    else 
	    {
	    	alertMsg = "Không tìm thấy người dùng";
			req.setAttribute("alert", alertMsg);	
			req.getRequestDispatcher("/views/forget.jsp").forward(req, resp);
	    }

	    

	}
}
