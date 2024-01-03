package webproject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class Webpage  extends HttpServlet{
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Integer attemptCount = (Integer) session.getAttribute("attemptCount");
        if (attemptCount == null) {
            attemptCount = 0;
        }
        String name =req.getParameter("username");
        String psw =req.getParameter("psw");
		
        if (name.equals("sudarshan") && psw.equals("mech")) {
            
            attemptCount = 0;
            session.setAttribute("attemptCount", attemptCount);
            RequestDispatcher rd = req.getRequestDispatcher("NewPAGE");
            rd.forward(req, resp);
        }
        else {
            // Increment login attempts
            attemptCount++;
            session.setAttribute("attemptCount", attemptCount);

            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");

            if (attemptCount < 3) {
                out.print((3 - attemptCount) + " times left........... try again");
                RequestDispatcher rd2 = req.getRequestDispatcher("/login.html");
                rd2.include(req, resp);
            } else {
                out.print("Blocked.....");
            }
			
			
		}
		
	}

}
