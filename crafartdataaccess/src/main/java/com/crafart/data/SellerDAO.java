package com.crafart.data;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.SellerDO;
import com.crafart.exception.UserDataException;
@Repository("sellerDAO")
public interface SellerDAO {

	public void addSeller(SellerDO sellerDO) throws UserDataException;
}
