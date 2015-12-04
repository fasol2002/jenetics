package org.jenetics.akka

import akka.actor.Actor
import akka.actor.Actor.Receive
import org.jenetics.Gene
import org.jenetics.engine.EvolutionStart

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since !__version__!
 * @version !__version__!
 */
final class Engine[G <: Gene[_, G], C <: Comparable[C]](
    param: EvolutionStart[G, C]
)
    extends Actor
{

    override def receive: Receive = {
        case start: EvolutionStart[G, C] =>
    }

}
