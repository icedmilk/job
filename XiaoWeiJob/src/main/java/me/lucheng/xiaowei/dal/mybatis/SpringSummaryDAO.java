package me.lucheng.xiaowei.dal.mybatis;

import java.util.List;

import me.lucheng.xiaowei.dal.dao.SummaryDAO;
import me.lucheng.xiaowei.dal.dataobject.Summary2DO;
import me.lucheng.xiaowei.dal.dataobject.SummaryDO;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringSummaryDAO extends BaseDAO<SummaryDAO> implements SummaryDAO {
	{
		setCtx(new ClassPathXmlApplicationContext("spring/applicationContext.xml"));
		setMapper((SummaryDAO) getCtx().getBean("summaryMapper"));
	}

	public List<SummaryDO> summarize() {
		return getMapper().summarize();
	}

	public List<Summary2DO> summarize2() {
		return getMapper().summarize2();
	}

}
