package me.lucheng.xiaowei.dal.dao;

import java.util.List;

import me.lucheng.xiaowei.dal.dataobject.CompanyDO;
import me.lucheng.xiaowei.dal.param.LoginParam;

public interface CompanyDAO {
	public List<CompanyDO> selectCompanyByName(String cname);

	public List<CompanyDO> selectCompanyByID(String id);

	public List<CompanyDO> selectCompanys(String cname);

	public void registerCompany(CompanyDO company);

	public Integer login(LoginParam param);
}
