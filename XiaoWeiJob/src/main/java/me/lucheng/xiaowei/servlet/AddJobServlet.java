package me.lucheng.xiaowei.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lucheng.xiaowei.dal.dataobject.JobDO;
import me.lucheng.xiaowei.dal.mybatis.SpringJobDAO;

/**
 * Servlet implementation class AddJobServlet
 */
public class AddJobServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		try {

			JobDO job = new JobDO(request.getSession().getAttribute("cid").toString(),
					request.getParameter("jname"), request.getParameter("jtype"),
					request.getParameter("jlocation"), request.getParameter("jdegree"),
					request.getParameter("jsalary"), request.getParameter("jexperience"),
					request.getParameter("jdescription"));
			// System.out.println(request.getSession().getAttribute("cname").toString());
			new SpringJobDAO().addJob(job);
			response.getWriter().print(true);
		} catch (Exception e) {
			// e.printStackTrace();
			response.getWriter().print("login");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
