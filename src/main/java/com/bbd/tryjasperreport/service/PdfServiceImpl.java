package com.bbd.tryjasperreport.service;

import com.bbd.tryjasperreport.dto.CalendarItemDTO;
import com.bbd.tryjasperreport.util.JasperUtils;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@Service
public class PdfServiceImpl implements PdfService {

	@Override
	public void generateCalendarPdf(HttpServletResponse response) {
		Map<String, Object> parameters = buildDataParameter();
		try {
			InputStream reportFileInputStream = JasperUtils.generalPDFReport(
					"report/calendar_template.jasper", parameters);
			String fileName = "calendar_" + System.currentTimeMillis();
			JasperUtils.writeResponse(response, reportFileInputStream, fileName);
		} catch (Exception e) {
			log.error(e.getMessage(), e);
			log.error("Error create calendar pdf");
		}
	}

	private Map<String, Object> buildDataParameter() {
		Map<String, Object> parameters = new HashMap<>();
		parameters.put("accountName", "John Doe");
		parameters.put("printedDate", "23 Jul 2024");
		parameters.put("agencyLogo", "https://m.media-amazon.com/images/I/41iBVPk8bTL._AC_UF894,1000_QL80_.jpg");
		parameters.put("sundate", "07/07");
		parameters.put("mondate", "08/07");
		parameters.put("tuedate", "09/07");
		parameters.put("weddate", "10/07");
		parameters.put("thudate", "11/07");
		parameters.put("fridate", "12/07");
		parameters.put("satdate", "13/07");

		String jamilL = "Jamil L";
		String stephenCurry = "Stephen Curry";
		String event = "Event";
		String event1 = "EVENT";
		String time = "09:14";
		String description = "Curry Cup Testimonial (online)";
		String flight = "Flight";
		String flight1 = "FLIGHT";
		String time1 = "10:09";
		JRBeanCollectionDataSource sunEvents =
				new JRBeanCollectionDataSource(Arrays.asList(
						new CalendarItemDTO(jamilL, stephenCurry, event, event1, time, description),
						new CalendarItemDTO(jamilL, stephenCurry, "Rehearsal", "REHEARSAL",
						                    "10:00", description),
						new CalendarItemDTO(jamilL, stephenCurry, "Training", "TRAINING",
						                    "10:01", description),
						new CalendarItemDTO(jamilL, stephenCurry, "Performance", "PERFORMANCE",
						                    "10:02", description),
						new CalendarItemDTO(jamilL, stephenCurry, "Game", "GAME",
						                    "10:03", description),
						new CalendarItemDTO(jamilL, stephenCurry, "Social Post", "SOCIALPOST",
						                    "10:04", description),
						new CalendarItemDTO(jamilL, stephenCurry, "Appearance", "APPEARANCE",
						                    "10:05", description),
						new CalendarItemDTO(jamilL, stephenCurry, "Meeting", "MEETING",
						                    "10:06", description),
						new CalendarItemDTO(jamilL, stephenCurry, "Call", "CALL",
						                    "10:07", description),
						new CalendarItemDTO(jamilL, stephenCurry, "Email", "EMAIL",
						                    "10:08", description),
						new CalendarItemDTO(jamilL, stephenCurry, flight, flight1, time1, description),
						new CalendarItemDTO(jamilL, stephenCurry, "Transport", "TRANSPORT",
						                    "10:10", description),
						new CalendarItemDTO(jamilL, stephenCurry, "R&R/Holiday", "RANDRHOLIDAY",
						                    "10:11", description),
						new CalendarItemDTO(jamilL, stephenCurry, "General", "GENERAL",
						                    "10:12", description),
						new CalendarItemDTO(jamilL, stephenCurry, "Other", "OTHER",
						                    "10:13", description)
				));
		parameters.put("sunEvents", sunEvents);

		JRBeanCollectionDataSource monEvents =
				new JRBeanCollectionDataSource(Arrays.asList(
						new CalendarItemDTO(jamilL, stephenCurry, event, event1,
						                    time, "Monday Curry Cup Testimonial (online)"),
						new CalendarItemDTO(jamilL, stephenCurry, flight, flight1, time1, description),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO()
				));
		parameters.put("monEvents", monEvents);

		JRBeanCollectionDataSource tueEvents =
				new JRBeanCollectionDataSource(Arrays.asList(
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO()
				));
		parameters.put("tueEvents", tueEvents);

		JRBeanCollectionDataSource wedEvents =
				new JRBeanCollectionDataSource(Arrays.asList(
						new CalendarItemDTO(jamilL, stephenCurry, event, event1,
						                    time, "Wednesday Curry Cup Testimonial (online)"),
						new CalendarItemDTO(jamilL, stephenCurry, flight, flight1, time1, description),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO()
				));
		parameters.put("wedEvents", wedEvents);

		JRBeanCollectionDataSource thuEvents =
				new JRBeanCollectionDataSource(Arrays.asList(
						new CalendarItemDTO(jamilL, stephenCurry, event, event1,
						                    time, "Thursday Curry Cup Testimonial (online)"),
						new CalendarItemDTO(jamilL, stephenCurry, flight, flight1, time1, description),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO()
				));
		parameters.put("thuEvents", thuEvents);

		JRBeanCollectionDataSource friEvents =
				new JRBeanCollectionDataSource(Arrays.asList(
						new CalendarItemDTO(jamilL, stephenCurry, event, event1,
						                    time, "Friday Curry Cup Testimonial (online)"),
						new CalendarItemDTO(jamilL, stephenCurry, flight, flight1, time1, description),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO()
				));
		parameters.put("friEvents", friEvents);

		JRBeanCollectionDataSource satEvents =
				new JRBeanCollectionDataSource(Arrays.asList(
						new CalendarItemDTO(jamilL, stephenCurry, event, event1,
						                    time, "Saturday Curry Cup Testimonial (online)"),
						new CalendarItemDTO(jamilL, stephenCurry, flight, flight1, time1, description),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO(),
						new CalendarItemDTO()
				));
		parameters.put("satEvents", satEvents);

		return parameters;
	}
}
