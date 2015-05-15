package me.lucheng.xiaowei.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lucheng.xiaowei.dal.dataobject.JobDO;
import me.lucheng.xiaowei.dal.mybatis.SpringJobDAO;

/**
 * Servlet implementation class SelectJobByCidServlet
 */
public class SelectJobByCidServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		String cid = (String) request.getSession().getAttribute("cid");
		if (request.getParameter("cid") != null)
			cid = request.getParameter("cid");
		List<JobDO> list = new SpringJobDAO().selectJobByCid(cid);
		StringBuilder sb = new StringBuilder();
		sb.append("<table class='display'><thead><th>职位名称</th><th>职位类型</th><th>工作地点</th>"
				+ "<th>学历要求</th><th>待遇</th><th>工作经验</th><th>职位描述</th><th>操作</th></tr></thead><tbody>");

		for (JobDO job : list) {
			sb.append("<tr><td><a href='#' id='" + job.getId() + "'>");
			sb.append(job.getJname());
			sb.append("</a></td><td>");
			sb.append(job.getJtype());
			sb.append("</td><td>");
			sb.append(job.getJlocation());
			sb.append("</td><td>");
			sb.append(job.getJdegree());
			sb.append("</td><td>");
			sb.append(job.getJsalary());
			sb.append("</td><td>");
			sb.append(job.getJexperience());
			sb.append("</td><td>");
			sb.append(job.getJdescription());
			sb.append("</td><td><button id='" + job.getId() + "'>删除</button></td></tr>");
		}
		sb.append("</tbody></table>");

		response.getWriter().print(sb);
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
