package me.lucheng.xiaowei.dal.mybatis;

import java.util.List;

import me.lucheng.xiaowei.dal.dao.DeliveryDAO;
import me.lucheng.xiaowei.dal.dataobject.DeliveryDO;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringDeliveryDAO extends BaseDAO<DeliveryDAO> implements DeliveryDAO {
	{
		setCtx(new ClassPathXmlApplicationContext("spring/applicationContext.xml"));
		setMapper((DeliveryDAO) getCtx().getBean("deliveryMapper"));
	}

	public void insert(DeliveryDO deliverydo) {
		getMapper().insert(deliverydo);
	}

	public List<DeliveryDO> selectPathByJid(Long jid) {
		return getMapper().selectPathByJid(jid);
	}

	public Integer countDelivery(Long jid) {
		return getMapper().countDelivery(jid);
	}

}
