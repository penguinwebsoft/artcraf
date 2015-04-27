package com.crafart.reports;

import org.springframework.stereotype.Service;

import com.crafart.exception.ReportException;
import com.crafart.model.ReportModel;

@Service
public interface Report {

	public void generateReport(ReportModel orderDeclarationBO)throws ReportException;
	
	public void generateDeclarationReport(ReportModel model) throws ReportException;
}
