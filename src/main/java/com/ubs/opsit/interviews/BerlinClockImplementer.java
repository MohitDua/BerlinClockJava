package com.ubs.opsit.interviews;

import java.util.Arrays;

public class BerlinClockImplementer extends BerlinClockConverter {

	@Override
	public String convertTime(String aTime) {

		String[] time = validateInput(aTime);
		String secondConv = getSeconds(Integer.parseInt(time[2]));
		String topMinuteConv = getTopMinutes(Integer.parseInt(time[1]));
		String bottomMinuteConv = getBottomMinutes(Integer.parseInt(time[1]));
		String topHourConv = getTopHours(Integer.parseInt(time[0]));
		String bottomHourConv = getBottomHours(Integer.parseInt(time[0]));

		return String.join(NEW_LINE,
				Arrays.asList(secondConv, topHourConv, bottomHourConv, topMinuteConv, bottomMinuteConv));
	}

	protected String getSeconds(int number) {
		if (number % 2 == 0)
			return "Y";
		else
			return "O";
	}

	protected String getTopHours(int number) {
		return getOnOff(4, getTopNumberOfOnSigns(number));
	}

	protected String getBottomHours(int number) {
		return getOnOff(4, number % 5);
	}

	protected String getTopMinutes(int number) {
		return getOnOff(11, getTopNumberOfOnSigns(number), "Y").replaceAll("YYY", "YYR");
	}

	protected String getBottomMinutes(int number) {
		return getOnOff(4, number % 5, "Y");
	}

	private String getOnOff(int lamps, int onSigns) {
		return getOnOff(lamps, onSigns, "R");
	}

	private String getOnOff(int lamps, int onSigns, String onSign) {
		String out = "";
		for (int i = 0; i < onSigns; i++) {
			out += onSign;
		}
		for (int i = 0; i < (lamps - onSigns); i++) {
			out += "O";
		}
		return out;
	}

	private int getTopNumberOfOnSigns(int number) {
		return (number - (number % 5)) / 5;
	}

}
