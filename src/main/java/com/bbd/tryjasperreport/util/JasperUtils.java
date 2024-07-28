package com.bbd.tryjasperreport.util;

import jakarta.servlet.http.HttpServletResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimplePdfReportConfiguration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Assert;

import java.io.*;
import java.util.Map;

@Slf4j
@Setter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class JasperUtils {

	public static InputStream generalPDFReport(String reportPath, Map<String, Object> parameters)
			throws JRException, IOException {
		InputStream reportTemplateFile = new ClassPathResource(reportPath).getInputStream();
		JasperReport jasperReport = (JasperReport) JRLoader.loadObject(reportTemplateFile);
		Assert.notNull(jasperReport, "JasperReport template is null");

		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, new JREmptyDataSource());
		JRPdfExporter exporter = new JRPdfExporter();

		exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		ByteArrayOutputStream pdfOutputStream = new ByteArrayOutputStream();
		exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(pdfOutputStream));

		SimplePdfReportConfiguration reportConfig = new SimplePdfReportConfiguration();
		reportConfig.setSizePageToContent(true);
		reportConfig.setForceLineBreakPolicy(false);

		exporter.setConfiguration(reportConfig);
		exporter.exportReport();

		return new ByteArrayInputStream(pdfOutputStream.toByteArray());
	}

	public static void writeResponse(HttpServletResponse response, InputStream inputStream, String fileName) {
		String contentDisposition = String.format("attachment; filename=%s.pdf", fileName);
		response.setContentType("application/pdf");
		response.addHeader("Content-Disposition", contentDisposition);
		response.addHeader("Access-Control-Expose-Headers", "Content-Disposition");

		try (OutputStream outputStream = response.getOutputStream()) {
			byte[] buffer = new byte[1024];
			int bytesRead;
			while ((bytesRead = inputStream.read(buffer)) != -1) {
				outputStream.write(buffer, 0, bytesRead);
			}
		} catch (IOException e) {
			log.error(e.getMessage(), e);
		}
	}
}