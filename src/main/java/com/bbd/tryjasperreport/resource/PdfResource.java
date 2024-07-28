package com.bbd.tryjasperreport.resource;

import com.bbd.tryjasperreport.service.PdfService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping(
		value = "/pdf",
		produces = MediaType.APPLICATION_JSON_VALUE
)
public class PdfResource {

	private final PdfService pdfService;

	@GetMapping("/calendar")
	public void generateCalendarPdf(HttpServletResponse response) {
		pdfService.generateCalendarPdf(response);
	}
}
