package me.lucheng.xiaowei.dal.dao;

import java.util.List;

import me.lucheng.xiaowei.dal.dataobject.JobDO;

public interface JobDAO {
	public void addJob(JobDO job);

	public List<JobDO> selectAll();

	public List<JobDO> selectJobByCid(String cid);

	public List<JobDO> selectJobById(String id);

	public void deleteJobById(String id);
}
