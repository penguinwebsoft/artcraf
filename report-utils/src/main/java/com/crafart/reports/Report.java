package com.crafart.reports;

import org.springframework.stereotype.Service;

import com.crafart.exception.ReportException;
import com.crafart.model.OrderDeclarationBO;
import com.crafart.model.ReportModel;

@Service
public interface Report {

	public void generateReport(OrderDeclarationBO orderDeclarationBO)throws ReportException;
	
	public void generateDeclrationReport(ReportModel model) throws ReportException;
}
