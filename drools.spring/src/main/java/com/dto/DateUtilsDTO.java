package com.dto;

import java.util.Date;

public class DateUtilsDTO {
	private Date current;
	private Long two_years = Long.valueOf("63113904000");
	private Long six_months = Long.valueOf("15552000000");
	public Long getSix_months() {
		return six_months;
	}
	public void setSix_months(Long six_months) {
		this.six_months = six_months;
	}
	public DateUtilsDTO(){}
	public Date getCurrent() {
		return current;
	}
	public void setCurrent(Date current) {
		this.current = current;
	}
	public Long getTwo_years() {
		return two_years;
	}
	public void setTwo_years(Long two_years) {
		this.two_years = two_years;
	}
}
