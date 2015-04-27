package com.crafart.reports;

import java.io.InputStream;
import java.util.ArrayList;
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
 * service responsible for generating reports for order functionality
 * 
 * @author p.periyasamy
 * @version 1.0
 *
 */
@Service("orderReportServiceImpl")
public class OrderReportServiceImpl implements Report {
	
	private static final Logger log = Logger.getLogger(OrderReportServiceImpl.class); 

	@Override
	public void generateReport(OrderDeclarationBO orderDeclarationBO) throws ReportException {
		List<OrderDeclarationBO> orderDeclarationBOLst = new ArrayList<>();
		orderDeclarationBOLst.add(orderDeclarationBO);
		try {
			InputStream in = this.getClass().getResourceAsStream("/orderInvoice.jrxml");
			InputStream jasperIn = this.getClass().getResourceAsStream("/orderInvoice.jasper");
			JasperCompileManager.compileReport(in);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperIn, new HashMap<String, Object>(), new JRBeanCollectionDataSource(orderDeclarationBOLst));
			// JasperExportManager.exportReportToPdfFile("resource/Barcode4JReport.jrprint");
			JasperExportManager.exportReportToPdfFile(jasperPrint, "orderInvoice.pdf");
		} catch (JRException jExp) {
			log.error("Error - While creating order invoice report" , jExp);
		}
	}

	@Override
	public void generateDeclrationReport(ReportModel reportModel) throws ReportException {
		OrderDeclarationBO orderDeclarationBO = (OrderDeclarationBO) reportModel;
		Vector<OrderDeclarationBO> orderDeclLst = new Vector<>();
		orderDeclLst.add(orderDeclarationBO);
		try {
			InputStream jrIn = this.getClass().getResourceAsStream("/orderDeclarationForm.jrxml");
			InputStream jasperIn = this.getClass().getResourceAsStream("/orderDeclarationForm.jasper");
			JasperCompileManager.compileReport(jrIn);
			JasperPrint jasperPrint = JasperFillManager.fillReport(jasperIn, new HashMap<String, Object>(), new JRBeanCollectionDataSource(orderDeclLst));
			JasperExportManager.exportReportToPdfFile(jasperPrint, "orderDeclarationForm.pdf");
		} catch (JRException jExp) {
			log.error("Error while generating order declaration form for order id " + orderDeclarationBO.getORDER_ID(), jExp);
		}
	}

}