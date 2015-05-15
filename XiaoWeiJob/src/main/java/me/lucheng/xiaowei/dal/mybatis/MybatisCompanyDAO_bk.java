package me.lucheng.xiaowei.dal.mybatis;

public class MybatisCompanyDAO_bk {
	// private static SqlSessionFactory sqlSessionFactory;
	// private static Reader reader;
	//
	// static {
	// try {
	// reader = Resources.getResourceAsReader("mybatis/mybatis-config.xml");
	// sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
	// } catch (Exception e) {
	// e.printStackTrace();
	// }
	// }
	//
	// public static SqlSessionFactory getSession() {
	// return sqlSessionFactory;
	// }
	//
	// public static void main(String[] args) {
	// System.out.println(new
	// MybatisCompanyDAO_bk().selectCompanyByID("11").getCname());
	//
	// }
	//
	// public Company selectCompanyByID(String id) {
	// SqlSession session = sqlSessionFactory.openSession();
	// CompanyDAO companyOperation = session.getMapper(CompanyDAO.class);
	//
	// Company company = companyOperation.selectCompanyByID(id);
	// session.close();
	// return company;
	// }
	//
	// public List<Company> selectCompanys(String cname) {
	// SqlSession session = sqlSessionFactory.openSession();
	// CompanyDAO companyOperation = session.getMapper(CompanyDAO.class);
	//
	// List<Company> companys = companyOperation.selectCompanys(cname);
	// session.close();
	// return companys;
	// }
	//
	// public void insertCompany(Company company) {
	// SqlSession session = sqlSessionFactory.openSession();
	// CompanyDAO companyOperation = session.getMapper(CompanyDAO.class);
	//
	// companyOperation.registerCompany(company);
	// session.commit();
	// session.close();
	//
	// }
	//
	// public void updateCompany(Company company) {
	// // TODO Auto-generated method stub
	//
	// }
}
