/**
 * 
 */
package com.crafart.inter.data;

import java.util.List;

import com.crafart.dataobjects.TaxRuleDO;
import com.crafart.exception.CrafartDataException;


/**
 * @author Karthi
 * 
 */
public interface TaxRuleDAO {

	public void addTaxRule(List<TaxRuleDO> taxRuleDOs) throws CrafartDataException;
}
