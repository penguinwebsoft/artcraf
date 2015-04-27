package com.crafart;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.crafart.exception.ReportException;
import com.crafart.model.Order;
import com.crafart.model.OrderDeclarationBO;
import com.crafart.reports.Report;

@ContextConfiguration({ "classpath:crafartreport-context-test.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class OrderReportServiceTest {

	@Autowired
	private Report orderReportServiceImpl;

	@Test
	public void testGenerateReport() {
		try {
			OrderDeclarationBO orderDeclarationBO = getOrderDeclarationBO();
			orderDeclarationBO.setCustomerOrderList(getOrderDeclarationBOLst());
			orderReportServiceImpl.generateReport(orderDeclarationBO);
		} catch (ReportException rExp) {
			rExp.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test
	public void testGenerateDeclarationReport() {
		try {
			orderReportServiceImpl.generateDeclrationReport(getOrderDeclarationBO());
		} catch (ReportException rExp) {
			rExp.printStackTrace();
		}
	}
	
	private OrderDeclarationBO getOrderDeclarationBO(){
		
		OrderDeclarationBO declarationBO = new OrderDeclarationBO();
		declarationBO.setFIRST_NAME("Amlan");
		declarationBO.setLAST_NAME("Ghosh");
		declarationBO.setORDER_ID("3902000258949");
		declarationBO.setQTY("1");
		declarationBO.setDESC("HP Deskjet Ink Advantage 2545 All-in-One Color printer");
		declarationBO.setSTREET_NAME("Post Boral, Vill Uttar sreepur, Dist: 24 pgs(South), near Rakshit moore");
		declarationBO.setLANDMARK("Badamtala, Charaktala south 24 PARGANAS");
		declarationBO.setSTATE("West Bengal");
		declarationBO.setCITY("Kolkatta");
		declarationBO.setPIN_CODE("700084");
		declarationBO.setGROSS_AMT("2232");
		declarationBO.setDISCOUNT("343");
		declarationBO.setNET_AMT("2323");
		declarationBO.setTAX_RATE("222");
		declarationBO.setTAX_TYPE("CST");
		declarationBO.setTAX_AMOUNT("3454");
		return declarationBO;
		
	}
	
	/**
	 * mock data for testing order invoice report
	 * <li>returns list of {@link OrderDeclarationBO} object
	 * @return {@link List} {@link OrderDeclarationBO}
	 */
	private List<Order> getOrderDeclarationBOLst(){
		List<Order> orderBOLst = new ArrayList<>();
		Order orderBO = new Order();
		orderBO.setQTY("1");
		orderBO.setDESC("HP Deskjet Ink Advantage 2545 All-in-One Color printer");
		orderBO.setGROSS_AMT("4999");
		orderBO.setDISCOUNT("Nil");
		orderBO.setNET_AMT("4999.00");
		orderBO.setTAX_RATE("5%");
		orderBO.setTAX_TYPE("CST");
		orderBO.setTAX_AMOUNT("195.90");
		
		Order orderBO1 = new Order();
		orderBO1.setQTY("");
		orderBO1.setDESC("Shipping");
		orderBO1.setGROSS_AMT("");
		orderBO1.setDISCOUNT("Nil");
		orderBO1.setNET_AMT("0.00");
		orderBO1.setTAX_RATE("0%");
		orderBO1.setTAX_TYPE("TAX");
		orderBO1.setTAX_AMOUNT("0");	
		orderBOLst.add(orderBO);
		orderBOLst.add(orderBO1);
		
		return orderBOLst;
		
	}
}
