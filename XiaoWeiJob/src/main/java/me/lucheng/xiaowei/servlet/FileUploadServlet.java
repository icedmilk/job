package me.lucheng.xiaowei.servlet;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.mail.internet.MimeUtility;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import me.lucheng.xiaowei.dal.dataobject.DeliveryDO;
import me.lucheng.xiaowei.dal.mybatis.SpringDeliveryDAO;
import me.lucheng.xiaowei.dal.mybatis.SpringJobDAO;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 * Servlet implementation class FileUploadServlet
 */
public class FileUploadServlet extends HttpServlet {

	private static final long serialVersionUID = -7744625344830285257L;
	private ServletContext sc;
	private String savePath;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void init(ServletConfig config) {
		// 在web.xml中设置的一个初始化参数
		savePath = config.getInitParameter("savePath");
		sc = config.getServletContext();
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		DiskFileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		String path = null;
		String fileName = null;
		String jid = null;
		String getPath = null;

		try {
			List<FileItem> items = upload.parseRequest(request);

			Iterator<FileItem> itr = items.iterator();
			int count = 0;
			while (itr.hasNext()) {
				FileItem item = (FileItem) itr.next();
				if (item.isFormField() && count < 1) {
					count++;
					System.out.println("表单参数名:" + item.getFieldName() + "，表单参数值:"
							+ item.getString("UTF-8"));
					jid = item.getString("UTF-8");
				} else if (count < 1) {
					if (item.getName() != null && !item.getName().equals("")) {
						System.out.println("上传文件的大小:" + item.getSize());
						System.out.println("上传文件的类型:" + item.getContentType());
						System.out.println("上传文件的名称:" + item.getName());

						fileName = item.getName().toString();
						File tempFile = new File(item.getName());
						path = sc.getRealPath("/") + savePath + File.separator + tempFile.getName();
						getPath = savePath + File.separator + tempFile.getName();

						System.out.println(sc.getRealPath("/") + ":" + savePath + ":"
								+ tempFile.getName());

						// 上传文件的保存路径
						File file = new File(path);

						item.write(file);
						request.setAttribute("upload.message", "上传文件成功！");
					} else {
						request.setAttribute("upload.message", "没有选择上传文件！");
					}
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("upload.message", "上传文件失败！");
		}

		// String newName = "Resume";
		// String[] argus = fileName.split("\\.");
		// newName += "." + argus[argus.length - 1];

		mailSender(path, fileName, jid);
		System.out.println(path);

		DeliveryDO deliverydo = new DeliveryDO();
		deliverydo.setJid(Long.parseLong(jid));
		deliverydo.setPath(getPath);
		System.out.println(getPath);
		new SpringDeliveryDAO().insert(deliverydo);
		// mailSender(sc.getRealPath("/") +);
	}

	public void mailSender(String path, String fileName, String jname)
			throws UnsupportedEncodingException {

		Properties props = new Properties();
		props.setProperty("mail.smtp.auth", "true");
		props.setProperty("mail.transport.protocol", "smtp");

		Session session = Session.getInstance(props);
		session.setDebug(false);

		Message msg = new MimeMessage(session);
		try {
			msg.setText("test");

			// msg.setDescription("desc");
			msg.setSubject("您发布的职位【" + new SpringJobDAO().selectJobById(jname).get(0).getJname()
					+ "】收到了新的简历投递~");
			msg.setFrom(new InternetAddress("admin@lucheng.me"));

			msg.setSentDate(new Date());

			// 添加附件必须设置邮件类型
			MimeMultipart msgMultipart = new MimeMultipart("mixed");
			msg.setContent(msgMultipart);

			MimeBodyPart attch1 = new MimeBodyPart();
			msgMultipart.addBodyPart(attch1);

			// 设置附件的名称
			attch1.setFileName(MimeUtility.encodeText(fileName));

			// 设置数据源（即数据的来源）
			DataSource ds1 = new FileDataSource(path);
			DataHandler dh1 = new DataHandler(ds1);

			// 设置附件的句柄给这个附件对象
			attch1.setDataHandler(dh1);

			Transport transport = session.getTransport();
			transport.connect("smtp.qq.com", 25, "admin@lucheng.me", "NokiaN78..");
			transport.sendMessage(msg, new Address[] { new InternetAddress("admin@lucheng.me") });

			transport.close();
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		// // 这个类主要是设置邮件
		// System.out.println("a");
		// MailSenderInfo mailInfo = new MailSenderInfo();
		// mailInfo.setMailServerHost("smtp.qq.com");
		// mailInfo.setMailServerPort("25");
		// mailInfo.setValidate(true);
		// mailInfo.setUserName("admin@lucheng.me");
		// mailInfo.setPassword("NokiaN78..");// 您的邮箱密码
		//
		// mailInfo.setFromAddress("admin@lucheng.me");
		//
		// mailInfo.setToAddress("admin@lucheng.me");
		// mailInfo.setSubject("Title");
		// mailInfo.setContent("Source");
		//
		// // 这个类主要来发送邮件
		// SimpleMailSender sms = new SimpleMailSender();
		// sms.sendTextMail(mailInfo);// 发送文体格式
		// // SimpleMailSender.sendHtmlMail(mailInfo);//发送html格式
	}
}
