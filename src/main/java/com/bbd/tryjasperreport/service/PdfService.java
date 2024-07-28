package com.bbd.tryjasperreport.service;

import jakarta.servlet.http.HttpServletResponse;

public interface PdfService {

	void generateCalendarPdf(HttpServletResponse response);
}
