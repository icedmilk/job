package me.lucheng.xiaowei.servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lucheng.xiaowei.dal.dataobject.DeliveryDO;
import me.lucheng.xiaowei.dal.mybatis.SpringDeliveryDAO;

/**
 * Servlet implementation class ShowDeliveryServlet
 */
public class ShowDeliveryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		List<DeliveryDO> list = new SpringDeliveryDAO().selectPathByJid(Long.parseLong(request
				.getParameter("jid")));
		StringBuilder sb = new StringBuilder();
		sb.append("<table class='display'><thead><th>简历一览（共投递&nbsp;<strong>"
				+ new SpringDeliveryDAO().countDelivery(Long.parseLong(request.getParameter("jid")))
				+ "&nbsp;</strong>份）</th></tr></thead><tbody>");
		for (DeliveryDO deliveryDO : list) {
			sb.append("<tr><td><a href='");
			sb.append(deliveryDO.getPath());
			sb.append("'>");
			String[] paths = deliveryDO.getPath().split(File.separator);
			sb.append(paths[paths.length - 1]);

			sb.append("</a></td></tr>");
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
