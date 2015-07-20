/**
 * 
 */
package com.crafart.data;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
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
@Repository("lengthClassImpl")
public class LengthClassDAOImpl extends CommonDAOImpl implements LengthClassDAO {

	/**
	 * get length class data object for identifier lengthClassId
	 * @param long {@link LengthClassDO} lengthClassId
	 */
	@Override
	public LengthClassDO getLengthClass(long lengthClassId) throws CrafartDataException {
		LengthClassDO lengthClassDO = (LengthClassDO) this.getSessionFactory().getCurrentSession().get(LengthClassDO.class, lengthClassId);
		return lengthClassDO;
	}
	
	/**
	 * adding length class details to lenght_class table
	 * 
	 */
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addLengthClass(LengthClassDO lengthClassDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.save(lengthClassDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("Error in adding lengthClass", hExp);
		}
	}

	/**
	 * get all length class data objects
	 * @return {@link List} {@link LengthClassDO}
	 */
	@SuppressWarnings("unchecked")
	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public List<LengthClassDO> getLengthClasses() throws CrafartDataException {
		List<LengthClassDO> lengthClassDOs = new ArrayList<>();
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			lengthClassDOs = session.createQuery("from LengthClassDO").list();
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB Error while reteriving LengthClass details", hExp);
		}
		return lengthClassDOs;
	}

	
}
