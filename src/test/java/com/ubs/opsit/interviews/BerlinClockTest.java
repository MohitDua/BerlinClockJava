package com.ubs.opsit.interviews;

import org.junit.Assert;
import org.junit.Test;

public class BerlinClockTest {

	BerlinClockImplementer berlinClockImpl = new BerlinClockImplementer();

	// Yellow lamp should blink on/off every two seconds
	@Test
	public void testYellowLampShouldBlinkOnOffEveryTwoSeconds() {
		Assert.assertEquals("Y", berlinClockImpl.getSeconds(06));
		Assert.assertEquals("O", berlinClockImpl.getSeconds(19));
	}

	// Top hours should have 4 lamps
	@Test
	public void testTopHoursShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClockImpl.getTopHours(06).length());
	}

	// Top hours should light a red lamp for every 5 hours
	@Test
	public void testTopHoursShouldLightRedLampForEvery5Hours() {
		Assert.assertEquals("RRRO", berlinClockImpl.getTopHours(15));
		Assert.assertEquals("RRRR", berlinClockImpl.getTopHours(22));
	}

	// Bottom hours should have 4 lamps
	@Test
	public void testBottomHoursShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClockImpl.getBottomHours(5).length());
	}

	// Bottom hours should light a red lamp for every hour left from top hours
	@Test
	public void testBottomHoursShouldLightRedLampForEveryHourLeftFromTopHours() {
		Assert.assertEquals("OOOO", berlinClockImpl.getBottomHours(0));
		Assert.assertEquals("ROOO", berlinClockImpl.getBottomHours(21));
	}

	// Top minutes should have 11 lamps
	@Test
	public void testTopMinutesShouldHave11Lamps() {
		Assert.assertEquals(11, berlinClockImpl.getTopMinutes(34).length());
	}

	// Top minutes should have 3rd, 6th and 9th lamps in red to indicate first
	// quarter, half and last quarter
	@Test
	public void testTopMinutesShouldHave3rd6thAnd9thLampsInRedToIndicateFirstQuarterHalfAndLastQuarter() {
		String minutes32 = berlinClockImpl.getTopMinutes(32);
		Assert.assertEquals("R", minutes32.substring(2, 3));
		Assert.assertEquals("R", minutes32.substring(5, 6));
	}

	// Top minutes should light a yellow lamp for every 5 minutes unless it's first
	// quarter, half or last quarter
	@Test
	public void testTopMinutesShouldLightYellowLampForEvery5MinutesUnlessItIsFirstQuarterHalfOrLastQuarter() {
		Assert.assertEquals("OOOOOOOOOOO", berlinClockImpl.getTopMinutes(0));
		Assert.assertEquals("YYRYYRYYRYY", berlinClockImpl.getTopMinutes(59));
	}

	// Bottom minutes should have 4 lamps
	@Test
	public void testBottomMinutesShouldHave4Lamps() {
		Assert.assertEquals(4, berlinClockImpl.getBottomMinutes(0).length());
	}

	// Bottom minutes should light a yellow lamp for every minute left from top
	// minutes
	@Test
	public void testBottomMinutesShouldLightYellowLampForEveryMinuteLeftFromTopMinutes() {
		Assert.assertEquals("OOOO", berlinClockImpl.getBottomMinutes(0));
		Assert.assertEquals("YYYY", berlinClockImpl.getBottomMinutes(59));
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyInput() {
		berlinClockImpl.convertTime("");
	}

	@Test(expected = IllegalArgumentException.class)
	public void testInvalidInput() {
		berlinClockImpl.convertTime("00:00");
	}
}
