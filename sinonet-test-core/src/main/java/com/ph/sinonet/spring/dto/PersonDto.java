package com.ph.sinonet.spring.dto;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class PersonDto {

	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date entryDate;

	public Date getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(Date entryDate) {
		this.entryDate = entryDate;
	}
	
	
	
}
