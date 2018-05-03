package com.ubs.opsit.interviews;

public abstract class BerlinClockConverter implements TimeConverter {

	protected static final String NO_INPUT = "No input provided";
	protected static final String INVALID_INPUT = "Invalid input provided";
	protected static final String NEW_LINE = System.getProperty("line.separator");

	protected String[] validateInput(String aTime) {
		if (aTime == null)
			throw new IllegalArgumentException(NO_INPUT);
		String[] time = aTime.split(":", 3);
		if (time.length != 3)
			throw new IllegalArgumentException(INVALID_INPUT);

		int hours, minutes, seconds = 0;
		try {
			hours = Integer.parseInt(time[0]);
			minutes = Integer.parseInt(time[1]);
			seconds = Integer.parseInt(time[2]);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException(INVALID_INPUT);
		}

		if (hours == 24 && minutes == 00 && seconds == 00)
			return time;
		if (hours < 0 || hours > 23)
			throw new IllegalArgumentException("Hours out of range");
		if (minutes < 0 || minutes > 59)
			throw new IllegalArgumentException("Minutes out of range");
		if (seconds < 0 || seconds > 59)
			throw new IllegalArgumentException("Seconds out of range");

		return time;
	}

}
