package me.lucheng.xiaowei.dal.mybatis;

import org.springframework.context.ApplicationContext;

public class BaseDAO<T> {
	private ApplicationContext ctx;
	private T mapper;

	public ApplicationContext getCtx() {
		return ctx;
	}

	public void setCtx(ApplicationContext ctx) {
		this.ctx = ctx;
	}

	public T getMapper() {
		return mapper;
	}

	public void setMapper(T mapper) {
		this.mapper = mapper;
	}
}
