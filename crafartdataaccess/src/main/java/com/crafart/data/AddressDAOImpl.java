/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.AddressDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.AddressDAO;

/**
 * @author Karthi
 * 
 */
@Repository("AddressDAOImpl")
public class AddressDAOImpl extends CommonDAOImpl implements AddressDAO {


	/**
	 * creating DB connection and inserting values through persist(),after
	 * inserting Committing the transaction by commit()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addAddress(AddressDO addressDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(addressDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while adding new address details", hExp);
		}

	}

}
