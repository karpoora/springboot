package com.learning.springboot;

import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.LayoutBase;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class SpringBootJSON extends LayoutBase<ILoggingEvent> {

	String application = null;
	String environment = System.getenv("SPRINGBOOT_PROFILE");
	
	public String getDate()	{
		TimeZone tz = TimeZone.getTimeZone("UTC");
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
		df.setTimeZone(tz);
		return df.format(new Date());
	}
	
	public static String removeDoubleQuotes(String s)	{
		return s.replace("\"","'");
	}
	
	public void setApplication(String application) {
		this.application = application;
	}
	
	public String doLayout(ILoggingEvent event) {
		StringBuilder sbuf = new StringBuilder(128);
		sbuf.append("{");
		sbuf.append("\"app\": \"" + application + "\", ");
		sbuf.append("\"environment\": \"" + environment + "\", ");
		sbuf.append("\"date\": \"" + getDate() + "\", ");
		sbuf.append("\"loglevel\": \"" + event.getLevel() + "\", ");
		sbuf.append("\"thread\": \"" + event.getThreadName() + "\", ");
		sbuf.append("\"logger\": \"" + event.getLoggerName() + "\", ");
		sbuf.append("\"msg\": \"" +
		removeDoubleQuotes(event.getFormattedMessage()) + "\"");
		sbuf.append("}\n");
		return sbuf.toString();
	}
	
}