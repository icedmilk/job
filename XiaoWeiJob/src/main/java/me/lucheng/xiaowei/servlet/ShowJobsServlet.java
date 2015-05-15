package me.lucheng.xiaowei.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lucheng.xiaowei.dal.dao.CompanyDAO;
import me.lucheng.xiaowei.dal.dao.JobDAO;
import me.lucheng.xiaowei.dal.dataobject.JobDO;
import me.lucheng.xiaowei.dal.mybatis.SpringCompanyDAO;
import me.lucheng.xiaowei.dal.mybatis.SpringJobDAO;

/**
 * Servlet implementation class ShowJobs
 */
public class ShowJobsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.setCharacterEncoding("utf-8");
		request.getSession();
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		JobDAO dao = new SpringJobDAO();
		List<JobDO> result = dao.selectAll();
		StringBuilder sb = new StringBuilder();
		sb.append("<table class='display'><thead><th>公司名称</th><th>职位名称</th><th>职位类型</th><th>工作地点</th>"
				+ "<th>学历要求</th><th>待遇</th><th>工作经验</th><th>职位描述</th><th>投递简历</th></tr></thead><tbody>");
		CompanyDAO companydao = new SpringCompanyDAO();

		for (JobDO job : result) {
			sb.append("<tr><td><a class='trigger' cid='" + job.getCid() + "'>");

			sb.append(companydao.selectCompanyByID(job.getCid()).get(0).getCname());

			sb.append("</a></td><td>");
			sb.append(job.getJname());
			sb.append("</td><td>");
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
			sb.append("</td><td><form method='post' id = '" + job.getId()
					+ "' action='servlet/fileServlet' enctype='multipart/form-data'><input name='"
					+ job.getId() + "' type='file' size='10' ></form></td></tr>");
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
