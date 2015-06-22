package com.crafart.inter.data;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.AttributeDO;
import com.crafart.exception.CrafartDataException;


@Repository("attributeDAO")
public interface AttributeDAO {

	public void addAttribute(AttributeDO attributeDO)throws CrafartDataException;
	
	public List<AttributeDO>  getAllAttributes()throws CrafartDataException;
	
	public void updateAttribute(AttributeDO attributeDO)throws CrafartDataException;
}
