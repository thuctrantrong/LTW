package vn.iostar.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;


@WebServlet("/uploadmulti")
@MultipartConfig(fileSizeThreshold = 1024 * 1024 * 2, // 2MB
maxFileSize = 1024 * 1024 * 10, // 10MB
maxRequestSize = 1024 * 1024 * 50) // 50MB
public class uploadimg extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 req.getRequestDispatcher("/views/ifu.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
		resp.setContentType("text/html;charset=UTF-8");	
		String name = req.getParameter("name");
		Part part = req.getPart("image");
		String realPath = req.getServletContext().getRealPath("/uploads");
		String fileName = Paths.get(part.getSubmittedFileName()).getFileName().toString();
		if(!Files.exists(Paths.get(realPath)))
		{
			Files.createDirectories(Paths.get(realPath));
		}
		part.write(realPath + "/" + fileName);
			PrintWriter out = resp.getWriter();
			try {
				out.print("<h1>" + name + "</h1>");
				out.print("<img src='uploads/"+fileName+"'>");
			}catch (Exception e )
			{
				
			}
		}
		catch (Exception e )
		{
			
		} 
	}
}
