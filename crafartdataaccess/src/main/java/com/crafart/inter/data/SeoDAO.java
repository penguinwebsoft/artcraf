/**
 * 
 */
package com.crafart.inter.data;

import org.springframework.stereotype.Repository;

import com.crafart.dataobjects.SeoDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 *
 */
@Repository("SeoDAO")
public interface SeoDAO {
	public void addSeo(SeoDO seoDO) throws CrafartDataException;
}
