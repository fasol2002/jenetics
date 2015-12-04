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

import akka.actor.Props;
import akka.actor.UntypedActor;

import java.util.List;

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @version !__version__!
 * @since !__version__!
 */
public final class JExecutionActor extends UntypedActor {

	public static final class Message {
		private final List<Runnable> _runnables;

		private Message(final List<Runnable> runnables) {
			_runnables = requireNonNull(runnables);
		}

		public List<Runnable> getRunnables() {
			return _runnables;
		}

		public static Message of(final List<Runnable> runnables) {
			return new Message(runnables);
		}
	}

	@Override
	public void onReceive(final Object message) {
		if (message instanceof Message) {
			final Message msg = (Message)message;

			final long start = System.nanoTime();
			msg.getRunnables().forEach(Runnable::run);
			final long end = System.nanoTime();

			getSender().tell(end - start, getSelf());
			getContext().stop(getSelf());
		} else {
			unhandled(message);
		}
	}

	public static Props props() {
		return Props.create(JExecutionActor::new);
	}

}
