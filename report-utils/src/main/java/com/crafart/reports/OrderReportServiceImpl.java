package com.crafart.reports;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Vector;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import com.crafart.exception.ReportException;
import com.crafart.model.OrderDeclarationBO;
import com.crafart.model.ReportModel;

/**
 * service responsible for generating reports for customer order functionality.
 * 
 * <li>it is concrete class of type {@link Report}<li>
 * Concrete class provides implementation for generation orderInvoice and
 * orderDeclarationForm reports
 * 
 * @author p.periyasamy
 * @version 1.0
 *
 */
@Service("orderReportServiceImpl")
public class OrderReportServiceImpl implements Report {

	private static final Logger log = Logger.getLogger(OrderReportServiceImpl.class);

	/**
	 * Method generated orderInvoice for a customer, Orders subreport maintains
	 * the list of orders made by customer. <li> {@link OrderDeclarationBO}
	 * contains customer data and order details as {@link Collection}
	 * 
	 * @param orderDeclarationBO
	 *            return {@link Void}
	 */
	@Override
	public void generateReport(ReportModel orderDeclarationBO) throws ReportException {
		List<OrderDeclarationBO> orderDeclarationBOLst = new ArrayList<>();
		/* casting order declaration bo from report model */
		orderDeclarationBOLst.add((OrderDeclarationBO) orderDeclarationBO);
		try {
			/*
			 * getting order invoice jasper xml file and compile to bitcode for
			 * generating report. here datasource is java bean i.e
			 * orderDeclarationBO and it has collection of order details which
			 * is passed as argument for orders subreport
			 */
			InputStream in = this.getClass().getResourceAsStream("/orderInvoice.jrxml");
			InputStream jasperIn = this.getClass().getResourceAsStream("/orderInvoice.jasper");
			JasperCompileManager.compileReport(in);
			/*
			 * Note :- fillreport method argument takes collections , hence
			 * wrapping orderdeclaration (even for single bean) bo into
			 * Arraylist and passing as constructor argument for
			 * JRBeanCollectionDataSource. OrderDeclarationBO has list of orders
			 * , where orders data report is generated though subreport
			 * orders.jrxml, and this file is not needed for explicit
			 * compilation, as it is compiled as part of main report , which is
			 * orderInvoice.jrxml
			 */
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperIn, new HashMap<String, Object>(), new JRBeanCollectionDataSource(orderDeclarationBOLst));
			/*
			 * printing order invoice in pdf format
			 */
			JasperExportManager.exportReportToPdfFile(jasperPrint, "orderInvoice.pdf");
		} catch (JRException jExp) {
			log.error("Error - While creating order invoice report", jExp);
		}
	}

	/**
	 * Method generates orderDeclararionForm report for a customer,
	 * {@link OrderDeclarationBO} object with necessary customer details passed
	 * here as param to get the declaration form generated
	 * 
	 * @exception JRException
	 * @param reportModel
	 *            {@link OrderDeclarationBO}
	 */
	@Override
	public void generateDeclarationReport(ReportModel reportModel) throws ReportException {
		OrderDeclarationBO orderDeclarationBO = (OrderDeclarationBO) reportModel;
		Vector<OrderDeclarationBO> orderDeclLst = new Vector<>();
		orderDeclLst.add(orderDeclarationBO);
		try {
			/*
			 * getting order declaration form jasper xml file and compile to
			 * bitcode for generating report. here datasource is java bean i.e
			 * orderDeclarationBO type of ReportModel.
			 */
			InputStream jrIn = this.getClass().getResourceAsStream("/orderDeclarationForm.jrxml");
			InputStream jasperIn = this.getClass().getResourceAsStream("/orderDeclarationForm.jasper");
			JasperCompileManager.compileReport(jrIn);
			/*
			 * Note :- fillreport method argument takes collections , hence
			 * wrapping orderdeclaration (even for single bean) bo into
			 * Arraylist and passing as constructor argument for
			 * JRBeanCollectionDataSource.
			 */
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperIn, new HashMap<String, Object>(), new JRBeanCollectionDataSource(orderDeclLst));
			/*
			 * printing order invoice in pdf format
			 */
			JasperExportManager.exportReportToPdfFile(jasperPrint, "orderDeclarationForm.pdf");
		} catch (JRException jExp) {
			log.error("Error while generating order declaration form for order id " + orderDeclarationBO.getORDER_ID(), jExp);
		}
	}

}