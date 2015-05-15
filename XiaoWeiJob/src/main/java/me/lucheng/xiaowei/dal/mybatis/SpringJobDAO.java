package me.lucheng.xiaowei.dal.mybatis;

import java.util.List;

import me.lucheng.xiaowei.dal.dao.JobDAO;
import me.lucheng.xiaowei.dal.dataobject.JobDO;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringJobDAO extends BaseDAO<JobDAO> implements JobDAO {
	{
		setCtx(new ClassPathXmlApplicationContext("spring/applicationContext.xml"));
		setMapper((JobDAO) getCtx().getBean("jobMapper"));
	}

	public void addJob(JobDO job) {
		getMapper().addJob(job);
	}

	public List<JobDO> selectAll() {
		return getMapper().selectAll();
	}

	public List<JobDO> selectJobByCid(String cid) {
		return getMapper().selectJobByCid(cid);
	}

	public void deleteJobById(String id) {
		getMapper().deleteJobById(id);
	}

	public List<JobDO> selectJobById(String id) {
		return getMapper().selectJobById(id);
	}
}
