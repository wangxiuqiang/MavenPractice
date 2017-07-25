package com.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class StringToDateConverter implements Converter<String,Date> {

	private String datePattern;

	public StringToDateConverter(String datePattern) {
		this.datePattern = datePattern;
		System.out.println("instantiating .... cinverter with pattern:*" + datePattern);
	}

	@Override
	public Date convert(String s) {

		try {
			SimpleDateFormat dateFormat = new SimpleDateFormat(datePattern);
			dateFormat.setLenient(false);
			return dateFormat.parse(s);
		} catch (ParseException e) {
			throw new IllegalArgumentException("invaild date format. Please use this pattern\"" + datePattern + "\"");
		}
	}
}
