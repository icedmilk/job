package me.lucheng.xiaowei.dal.mybatis;

import java.util.List;

import me.lucheng.xiaowei.dal.dao.CompanyDAO;
import me.lucheng.xiaowei.dal.dataobject.CompanyDO;
import me.lucheng.xiaowei.dal.param.LoginParam;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringCompanyDAO extends BaseDAO<CompanyDAO> implements CompanyDAO {
	{
		setCtx(new ClassPathXmlApplicationContext("spring/applicationContext.xml"));
		setMapper((CompanyDAO) getCtx().getBean("companyMapper"));
	}

	public List<CompanyDO> selectCompanyByName(String cname) {
		return getMapper().selectCompanyByName(cname);

	}

	public List<CompanyDO> selectCompanys(String cname) {
		return getMapper().selectCompanys(cname);
	}

	public Integer login(LoginParam param) {
		System.err.println(param.getCname());
		return getMapper().login(param);
	}

	public void registerCompany(CompanyDO company) {
		getMapper().registerCompany(company);
	}

	public List<CompanyDO> selectCompanyByID(String id) {
		return getMapper().selectCompanyByID(id);
	}
}
