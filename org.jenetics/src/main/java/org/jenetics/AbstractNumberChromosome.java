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
package org.jenetics;

import static org.jenetics.internal.util.Equality.eq;

import java.util.Iterator;

import org.jenetics.internal.util.Equality;
import org.jenetics.internal.util.Hash;

import org.jenetics.util.ISeq;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since 3.0
 * @version 3.0 &mdash; <em>$Date: 2014-12-07 $</em>
 */
abstract class AbstractNumberChromosome<
	A,
	N extends Number & Comparable<? super N>,
	G extends AbstractNumericGene<N, G>
>
	implements NumericChromosome<N, G>
{

	private static final long serialVersionUID = 1L;

	final A _values;
	final N _min;
	final N _max;

	AbstractNumberChromosome(final A values, final N min, final N max) {
		_values = values;
		_min = min;
		_max = max;
	}

	@Override
	public N getMin() {
		return _min;
	}

	@Override
	public N getMax() {
		return _max;
	}

	@Override
	public Chromosome<G> newInstance(final ISeq<G> genes) {
		return null;
	}

	@Override
	public G getGene(int index) {
		return null;
	}

	@Override
	public int length() {
		return 0;
	}

	@Override
	public ISeq<G> toSeq() {
		return null;
	}

	@Override
	public Chromosome<G> newInstance() {
		return null;
	}

	@Override
	public Iterator<G> iterator() {
		return null;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	@Override
	public int intValue(int index) {
		return 0;
	}

	@Override
	public int intValue() {
		return 0;
	}

	@Override
	public long longValue(int index) {
		return 0;
	}

	@Override
	public long longValue() {
		return 0;
	}

	@Override
	public float floatValue(int index) {
		return 0;
	}

	@Override
	public float floatValue() {
		return 0;
	}

	@Override
	public double doubleValue(int index) {
		return 0;
	}

	@Override
	public double doubleValue() {
		return 0;
	}

	@Override
	public int hashCode() {
		return Hash.of(getClass())
			.and(super.hashCode())
			.and(_min)
			.and(_max).value();
	}

	@Override
	public boolean equals(final Object object) {
		return Equality.of(this, object).test(nc ->
			eq(_min, nc._min) &&
			eq(_max, nc._max) &&
			super.equals(object)
		);
	}
}
