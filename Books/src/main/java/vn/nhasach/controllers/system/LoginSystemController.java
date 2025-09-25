package vn.nhasach.controllers.system;
import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.nhasach.models.UserModel;
import vn.nhasach.services.UserService;
import vn.nhasach.services.Impl.UserServiceImpl;

@WebServlet(urlPatterns ={ "/system/login" })
public class LoginSystemController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public UserService service = new UserServiceImpl();
	// Nhận tham số từ trình duyệt web, và khởi tạo SS and CK
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if (session != null && session.getAttribute("account") != null) {
			resp.sendRedirect(req.getContextPath() + "/system/waiting");
			return;
		}
		Cookie[] cookies = req.getCookies();
		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (cookie.getName().equals("Username")) {
					session = req.getSession(true);
					session.setAttribute("Username", cookie.getValue());
					resp.sendRedirect(req.getContextPath() + "/system/waiting");
					return;
				}
			}
		}
		req.getRequestDispatcher("/views/system/login.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.setContentType("text/html");
		req.setCharacterEncoding("UTF-8");
		String Username = req.getParameter("Username");
		String Password = req.getParameter("Password");
		// boolean isRememberMe = false;
		// String remember = req.getParameter("remember");
		// if ("on".equals(remember)) {
		// isRememberMe = true;
		// }
		String alertMsg = "";
		if (Username.isEmpty() || Password.isEmpty()) {
			alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/system/login.jsp").forward(req, resp);
			return;
		}
		UserModel user = service.login(Username, Password);
		if (user != null) 
		{
			HttpSession session = req.getSession(true);
			session.setAttribute("account", user);
			resp.sendRedirect(req.getContextPath() + "/system/waiting");
		} else {
			alertMsg = "Tài khoản hoặc mật khẩu không đúng";
			req.setAttribute("alert", alertMsg);
			req.getRequestDispatcher("/views/system/login.jsp").forward(req, resp);
		}
	}

}
