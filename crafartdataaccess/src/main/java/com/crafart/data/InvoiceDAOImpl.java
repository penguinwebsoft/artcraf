/**
 * 
 */
package com.crafart.data;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.crafart.dataobjects.InvoiceDO;
import com.crafart.exception.CrafartDataException;
import com.crafart.inter.data.InvoiceDAO;

/**
 * @author Karthi
 * 
 */
@Repository("invoiceDAOImpl")
public class InvoiceDAOImpl extends CommonDAOImpl implements InvoiceDAO {

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void addInvoice(InvoiceDO invoiceDO) throws CrafartDataException {
		try {
			Session session = this.getSessionFactory().getCurrentSession();
			session.persist(invoiceDO);
		} catch (HibernateException hExp) {
			throw new CrafartDataException("DB error while adding invoice detail", hExp);
		}
	}

}
