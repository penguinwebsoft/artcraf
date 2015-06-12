/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.LengthClassDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.LengthClassDAO;

/**
 * @author Deepam
 * 
 */
@Repository("LengthClassImpl")
public class LengthClassDAOImpl extends CommonDAOImpl implements LengthClassDAO {


	/**
	 * adding length class details to lenght_class table
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addLengthClass(LengthClassDO lengthClassDO) throws CrafartDataException {

		try {
			Session session = this.getSessionFactory().getCurrentSession();
			Transaction tx = session.beginTransaction();
			session.persist(lengthClassDO);
			tx.commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error in adding lengthClass", hExp);
		}
	}

}
