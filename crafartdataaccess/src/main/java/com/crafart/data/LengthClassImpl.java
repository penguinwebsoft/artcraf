/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.LengthClassDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Deepam
 * 
 */
@Repository("LengthClassImpl")
public class LengthClassImpl implements LengthClassDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * adding length class details to lenght_class table
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addLengthClass(LengthClassDO lengthClassDO) throws CrafartDataException {

		try {
			Session session = this.sessionFactory.openSession();
			Transaction tx = session.beginTransaction();
			session.persist(lengthClassDO);
			tx.commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error in adding lengthClass", hExp);
		}
	}

}
