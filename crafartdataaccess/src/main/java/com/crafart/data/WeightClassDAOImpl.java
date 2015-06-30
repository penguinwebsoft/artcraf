/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.WeightClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.WeightClassDAO;

/**
 * @author Karthi
 * 
 */
@Repository("weightClassImpl")
public class WeightClassDAOImpl extends CommonDAOImpl implements WeightClassDAO {


	/**
	 * adding weight class details to weight_class table
	 * 
	 */

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addWeightClass(WeightClassDO weightClassDO) throws CrafartDataException {

		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(weightClassDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while weight_class details", hExp);
		}
	}

}
