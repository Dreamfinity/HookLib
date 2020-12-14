package com.integral.hooklibultimate;

public class TheSentinel {

	public static final boolean AWAKEN = TheSentinel.getInternalSentinelState();

	private static boolean getInternalSentinelState() {
		return false;
	}
	
	public static boolean isAwaken() {
		return AWAKEN;
	}

}
