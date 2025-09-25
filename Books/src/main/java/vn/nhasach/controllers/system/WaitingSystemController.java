package vn.nhasach.controllers.system;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.nhasach.models.UserModel;
@WebServlet(urlPatterns = { "/system/waiting" })
public class WaitingSystemController extends HttpServlet{
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		if (session != null && session.getAttribute("account") != null) {
			UserModel u = (UserModel) session.getAttribute("account");
			req.setAttribute("Username", u.getUsername());
			// Check roleid
			if (u.getRoleid() == 0) 
			{
				resp.sendRedirect(req.getContextPath() + "/admin/home");
			} else if (u.getRoleid() == 1) {
				resp.sendRedirect(req.getContextPath() + "/nhanvien/home");
			} else if (u.getRoleid() == 2) {
				resp.sendRedirect(req.getContextPath() + "/khachhang/home");
			}
		} else {// ko co 
			resp.sendRedirect(req.getContextPath() + "/system//login");
		}
	}
	
	

}
