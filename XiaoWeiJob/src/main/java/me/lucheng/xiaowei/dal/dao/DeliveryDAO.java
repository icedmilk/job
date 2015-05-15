package me.lucheng.xiaowei.dal.dao;

import java.util.List;

import me.lucheng.xiaowei.dal.dataobject.DeliveryDO;

public interface DeliveryDAO {
	public void insert(DeliveryDO deliverydo);

	public List<DeliveryDO> selectPathByJid(Long jid);

	public Integer countDelivery(Long jid);
}
