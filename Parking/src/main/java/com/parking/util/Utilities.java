package com.parking.util;

import java.util.concurrent.ThreadLocalRandom;

public class Utilities {
	public static int getRandom(int min, int max) {
		if (max == 0) {
			return max;
		} else {
			int rand = ThreadLocalRandom.current().nextInt(min, max);
			return rand;
		}
	}
}
