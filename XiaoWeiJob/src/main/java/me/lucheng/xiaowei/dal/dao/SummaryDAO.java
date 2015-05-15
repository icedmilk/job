package me.lucheng.xiaowei.dal.dao;

import java.util.List;

import me.lucheng.xiaowei.dal.dataobject.Summary2DO;
import me.lucheng.xiaowei.dal.dataobject.SummaryDO;

public interface SummaryDAO {
	public List<SummaryDO> summarize();

	public List<Summary2DO> summarize2();
}
