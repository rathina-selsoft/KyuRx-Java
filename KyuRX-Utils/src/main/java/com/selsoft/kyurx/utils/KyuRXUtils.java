package com.selsoft.kyurx.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

public class KyuRXUtils {

	private static final Logger logger = Logger.getLogger(KyuRXUtils.class);
	public static final SimpleDateFormat userReadableDateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	public static final SimpleDateFormat utcDateTimeFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.sss");
	public static final int TIMEOUT = 30;

	public static String getCurrentUTCTimeAsSqlTimestampString() {
		return getCurrentUTCTimeAsSqlTimestamp().toString();
	}

	public static String addDaysToCurrentUTCTimeAsSqlTimestampString(int days) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(getCurrentUTCTimeAsSqlTimestamp().getTime());
		calendar.add(Calendar.DAY_OF_WEEK, days);
		return new Timestamp(calendar.getTimeInMillis()).toString();
	}

	public static Timestamp getCurrentUTCTimeAsSqlTimestamp() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		return new Timestamp(System.currentTimeMillis());
	}

	public static String getUserReadableDateFormat(String dateAndTime) {
		if (StringUtils.isBlank(StringUtils.trimToEmpty(dateAndTime)))
			return StringUtils.EMPTY;
		String formattedDate = null;
		Date parsedDate = null;
		try {
			parsedDate = utcDateTimeFormat.parse(dateAndTime);
			formattedDate = userReadableDateFormat.format(parsedDate);
		} catch (ParseException e) {
			logger.error("Error while parsing the date : " + dateAndTime, e);
			formattedDate = StringUtils.EMPTY;
		} catch (Throwable t) {
			logger.fatal("Error while parsing the date : " + dateAndTime, t);
			formattedDate = StringUtils.EMPTY;
		}
		return formattedDate;
	}

	public static Timestamp addTimeToCurrentUTCTimeAsSqlTimestamp(int timeInMinutes) {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
		return new Timestamp(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(timeInMinutes));
	}

	public static boolean isValidDateFormat(String date) throws Throwable {
		final String regex = "^(?:[1-9]\\d{3}-(?:(?:0[1-9]|1[0-2])-(?:0[1-9]|1\\d|2[0-8])|(?:0[13-9]|1[0-2])-(?:29|30)|(?:0[13578]|1[02])-31)|(?:[1-9]\\d(?:0[48]|[2468][048]|[13579][26])|(?:[2468][048]|[13579][26])00)-02-29)";
		return Pattern.compile(regex).matcher(date).find();
	}

}
