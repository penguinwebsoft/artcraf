package com.crafart.inter.data;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.SellerDO;
import com.crafart.exception.CrafartDataException;

@Repository("sellerDAO")
public interface SellerDAO {

	public void addSeller(SellerDO sellerDO) throws CrafartDataException;

	public void updateSeller(SellerDO sellerDO) throws CrafartDataException;

	public SellerDO getSellerContacts(long seller_id) throws CrafartDataException;

}
