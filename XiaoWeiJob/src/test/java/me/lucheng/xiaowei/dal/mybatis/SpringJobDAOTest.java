package me.lucheng.xiaowei.dal.mybatis;

import me.lucheng.xiaowei.dal.dataobject.JobDO;

public class SpringJobDAOTest {

	public static void main(String[] args) {

		JobDO job = new JobDO();
		job.setCid("1");
		job.setJdegree("1");
		job.setJdescription("1");
		job.setJexperience("1");
		job.setJlocation("1");
		job.setJname("1");
		job.setJsalary("1");
		job.setJtype("1");
		new SpringJobDAO().addJob(job);
	}

}
