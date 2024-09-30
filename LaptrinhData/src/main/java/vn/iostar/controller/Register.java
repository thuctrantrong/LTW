package vn.iostar.controller;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iostar.model.Usermodel;
import vn.iostar.service.UserService;
import vn.iostar.service.ipl.UserServiceipl;

@WebServlet(urlPatterns = { "/register" })
public class Register extends HttpServlet {
	UserService service = new UserServiceipl();

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("views/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	    String username = req.getParameter("username");
	    String password = req.getParameter("password");
	    String fullname = req.getParameter("fullname");
	    String email = req.getParameter("email");
	    String phone = req.getParameter("phone");
	    String roleIdText = req.getParameter("roleid");
	    String createDate = req.getParameter("createDate");
	    String alertMsg = "";

	    if (username.isEmpty() || password.isEmpty() || fullname.isEmpty() || email.isEmpty() || phone.isEmpty() || createDate.isEmpty()) {
	        alertMsg = "Không được rỗng";
	        req.setAttribute("alert", alertMsg);
	        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	        return;
	    }

	    int roleid = 0; 
	    if (roleIdText != null && !roleIdText.isEmpty()) {
	        try {
	            roleid = Integer.parseInt(roleIdText);
	        } catch (NumberFormatException e) {
	            alertMsg = "Role ID không hợp lệ.";
	            req.setAttribute("alert", alertMsg);
	            req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	            return;
	        }
	    } else {
	        alertMsg = "Role ID không được rỗng.";
	        req.setAttribute("alert", alertMsg);
	        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	        return;
	    }

	    Usermodel user = null;
	    try {
	        user = service.registeruser(username, password, fullname, email, phone, roleid, createDate);
	    } catch (Exception e) {
	        e.printStackTrace();
	        alertMsg = "Đã xảy ra lỗi trong quá trình đăng ký.";
	        req.setAttribute("alert", alertMsg);
	        req.getRequestDispatcher("/views/register.jsp").forward(req, resp);
	        return;
	    }

	    if (user != null) {
	        req.getRequestDispatcher("/views/loginw.jsp").forward(req, resp);
	    } else {
	        alertMsg = "Trùng tài khoản hoặc mật khẩu.";
	        req.setAttribute("alert", alertMsg);
	        RequestDispatcher rd = req.getRequestDispatcher("/views/register.jsp");
	        rd.forward(req, resp);
	    }
	}


}
