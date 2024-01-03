package webproject;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class program1 extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id=Integer.parseInt(req.getParameter("id"));
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		String department = req.getParameter("department");
		int salary =Integer.parseInt(req.getParameter("salary"));
		
		Employee e = new Employee(id,name,email,department,salary);
		
		EmployeeBo bo = new EmployeeBo();
		int i= bo.save(e);
		PrintWriter out = resp.getWriter();
		if(i==1) {
			out.print("mr./mrs"+name+"Submmited successfully......");
		}
		else {
			out.print("mr./mrs"+name+"Submmited not successfully......");
		}
 
	}

}
