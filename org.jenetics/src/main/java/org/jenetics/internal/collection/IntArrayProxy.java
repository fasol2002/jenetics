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
package org.jenetics.internal.collection;

import java.util.Arrays;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since !__version__!
 * @version !__version__! &mdash; <em>$Date: 2014-12-07 $</em>
 */
public class IntArrayProxy
	extends ArrayProxy<Integer, int[], IntArrayProxy>
{
	private static final long serialVersionUID = 1L;

	public IntArrayProxy(final int[] values, final int start, final int end) {
		super(values, start, end, IntArrayProxy::new, Arrays::copyOfRange);
	}

	public IntArrayProxy(final int length) {
		this(new int[length], 0, length);
	}

	@Override
	public Integer __get__(int index) {
		return array[index];
	}

	@Override
	public void __set__(int index, Integer value) {
		array[index] = value;
	}

}
