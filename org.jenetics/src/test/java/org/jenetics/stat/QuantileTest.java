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
package org.jenetics.stat;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import org.jenetics.util.LCG64ShiftRandom;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version <em>$Date: 2014-07-11 $</em>
 */
public class QuantileTest {

	@Test
	public void median() {
		final Quantile quantile = Quantile.median();
		for (int i = 0; i < 1000; ++i) {
			quantile.accept(i);
			Assert.assertEquals(quantile.getValue(), floor(i/2.0), 1.0);
		}
	}

	@Test(dataProvider = "quantiles")
	public void quantile(final Double q) {
		final int N = 2_000_000;
		final Quantile quantile = new Quantile(q);

		new LCG64ShiftRandom(1234).doubles().limit(N).forEach(quantile);

		Assert.assertEquals(quantile.getSamples(), N);
		Assert.assertEquals(quantile.getValue(), q, 1.0/sqrt(N));
	}

	@DataProvider(name = "quantiles")
	public Object[][] getQuantiles() {
		return new Double[][] {
			{0.01},
			{0.0123},
			{0.1},
			{0.25},
			{0.33},
			{0.45},
			{0.5},
			{0.57},
			{0.83},
			{0.93}
		};
	}

	@Test
	public void reset() {
		final Quantile quantile = Quantile.median();
		for (int i = 0; i < 1000; ++i) {
			quantile.accept(i);
			Assert.assertEquals(quantile.getValue(), floor(i/2.0), 1.0);
		}

		quantile.reset();

		for (int i = 0; i < 1000; ++i) {
			quantile.accept(i);
			Assert.assertEquals(quantile.getValue(), floor(i/2.0), 1.0);
		}
	}


}
