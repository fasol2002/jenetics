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
package org.jenetics.akka;

import static java.util.Objects.requireNonNull;

import java.util.Optional;
import java.util.function.Consumer;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
final class ValueMatcher<T> {

	private final Class<?> _type;

	private ValueMatcher(final Class<?> type) {
		_type = requireNonNull(type);
	}

	@SuppressWarnings("unchecked")
	public void handle(final Object message, final Consumer<T> consumer) {
		final Optional<T> value = Optional.ofNullable(message)
			.filter(v -> v.getClass() == _type)
			.map(v -> (T)_type.cast(v));

		if (value.isPresent()) {

		}
	}

	public static <T> ValueMatcher<T> of(final Class<?> type) {
		return new ValueMatcher<>(type);
	}



}
