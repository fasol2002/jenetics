package org.jenetics.akka

import akka.actor.Actor
import akka.actor.Actor.Receive

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since !__version__!
 * @version !__version__!
 */
class EvaluationActor extends Actor {

    override def receive: Receive = {
        case "" =>
    }

}
