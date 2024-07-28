package com.bbd.tryjasperreport.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CalendarItemDTO {
	private String description;
	private String staff;
	private String talent;
	private String time;
	private String type;
	private String typeCode;

	public CalendarItemDTO(String staff, String talent, String type, String typeCode, String time, String description) {
		this.description = description;
		this.staff = staff;
		this.talent = talent;
		this.time = time;
		this.type = type;
		this.typeCode = typeCode;
	}
}
