/**
 * 
 */
package com.crafart.inter.data;

import com.crafart.dataobjects.InvoiceDO;
import com.crafart.exception.CrafartDataException;

/**
 * @author Karthi
 * 
 */
public interface InvoiceDAO {

	public void addInvoice(InvoiceDO invoiceDO) throws CrafartDataException;

}
