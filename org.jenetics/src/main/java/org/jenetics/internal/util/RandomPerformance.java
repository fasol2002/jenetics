/*
 * Java Genetic Algorithm Library (@__identifier__@).
 * Copyright (c) @__year__@ Franz Wilhelmstötter
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Author:
 *    Franz Wilhelmstötter (franz.wilhelmstoetter@gmx.at)
 */
package org.jenetics.internal.util;

import java.text.NumberFormat;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.jenetics.util.LCG64ShiftRandom;
import org.jenetics.util.XOR32ShiftRandom;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version <em>$Date: 2014-01-09 $</em>
 */
public class RandomPerformance {


	public static void main(final String[] args) {
		final int loops = Integer.MAX_VALUE;//100_000_000;

		for (int i = 0; i < 1; ++i) {
			test(new Random(), loops);
			test(new XOR32ShiftRandom(), loops);
			test(new LCG64ShiftRandom(), loops);
			test(ThreadLocalRandom.current(), loops);
		}
	}

	private static void test(final Random random, final int loops) {
		System.out.println(String.format(
			"%-20s %s; %s; %s; %s",
			random.getClass().getSimpleName() + ":",
			testNextInt(random, loops),
			testNextLong(random, loops),
			testNextFloat(random, loops),
			testNextDouble(random, loops)
		));
	}

	private static String testNextInt(final Random random, final int loops) {
		long start = System.currentTimeMillis();
		for (int i = loops; --i >= 0;) {
			random.nextInt();
		}
		long end = System.currentTimeMillis();

		final NumberFormat format = NumberFormat.getIntegerInstance();
		return String.format("%11s i/sec", format.format(perSec(loops, start, end)));
	}

	private static String testNextLong(final Random random, final int loops) {
		long start = System.currentTimeMillis();
		for (int i = loops; --i >= 0;) {
			random.nextLong();
		}
		long end = System.currentTimeMillis();

		final NumberFormat format = NumberFormat.getIntegerInstance();
		return String.format("%11s l/sec", format.format(perSec(loops, start, end)));
	}

	private static String testNextFloat(final Random random, final int loops) {
		long start = System.currentTimeMillis();
		for (int i = loops; --i >= 0;) {
			random.nextFloat();
		}
		long end = System.currentTimeMillis();

		final NumberFormat format = NumberFormat.getIntegerInstance();
		return String.format("%11s f/sec", format.format(perSec(loops, start, end)));
	}

	private static String testNextDouble(final Random random, final int loops) {
		long start = System.currentTimeMillis();
		for (int i = loops; --i >= 0;) {
			random.nextDouble();
		}
		long end = System.currentTimeMillis();

		final NumberFormat format = NumberFormat.getIntegerInstance();
		return String.format("%11s d/sec", format.format(perSec(loops, start, end)));
	}

	private static long perSec(final long loops, final long start, final long end) {
		//final double seconds = (end - start)/1_000_000_000.0;
		final double seconds = (end - start)/1_000.0;
		return (long)(loops/seconds);
	}

}