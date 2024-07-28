package com.bbd.tryjasperreport.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CalendarExportDTO {

	private String accountName;
	private String agencyLogo;
	private String printedDate;

	private String sundayDate;
	private String mondayDate;
	private String tuesdayDate;
	private String wednesdayDate;
	private String thursdayDate;
	private String fridayDate;
	private String saturdayDate;

	private List<CalendarItemDTO> sunEvents = new ArrayList<>();
	private List<CalendarItemDTO> monEvents = new ArrayList<>();
	private List<CalendarItemDTO> tueEvents = new ArrayList<>();
	private List<CalendarItemDTO> wedEvents = new ArrayList<>();
	private List<CalendarItemDTO> thuEvents = new ArrayList<>();
	private List<CalendarItemDTO> friEvents = new ArrayList<>();
	private List<CalendarItemDTO> satEvents = new ArrayList<>();
}
