/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.TaxClassDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Deepam
 * 
 */
@Repository("taxClassDAOImpl")
public class TaxClassDAOImpl implements TaxClassDAO {

	private SessionFactory sessionFactory;

	@Autowired
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * adding taxclass details to taxclass table by using addtaxcalssdetail()
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addTaxClassDetail(TaxClassDO taxClassDO) throws CrafartDataException {
		try {
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			session.persist(taxClassDO);
			session.getTransaction().commit();
			session.close();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding taxclass detail", hExp);
		}
	}

	/**
	 * get
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<TaxClassDO> getTaxClassDetail() throws CrafartDataException {
		List<TaxClassDO> taxClassDOs = new ArrayList<>();
		try{
			Session session = this.sessionFactory.openSession();
			session.beginTransaction();
			taxClassDOs = session.createQuery("from TaxClassDO").list();
			session.getTransaction().commit();
			session.close();
		} catch(HibernateException hExp){
			throw new CrafartDataException("Error while reteriving taxclassdetail from taxclass table", hExp);
		}
		return taxClassDOs;
	}

}