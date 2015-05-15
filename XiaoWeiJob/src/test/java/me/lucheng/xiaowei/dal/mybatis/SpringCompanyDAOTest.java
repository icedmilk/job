package me.lucheng.xiaowei.dal.mybatis;

import java.io.File;

import junit.framework.TestCase;
import me.lucheng.xiaowei.dal.param.LoginParam;

public class SpringCompanyDAOTest extends TestCase {
	SpringCompanyDAO scdao = new SpringCompanyDAO();

	public void testLogin() {
		LoginParam param = new LoginParam();
		param.setCname("阿里巴巴");
		param.setCpasswd("520");
		System.out.println(scdao.login(param));
	}

	public static void main(String[] args) {
		System.out.println(File.separator);
	}
}
