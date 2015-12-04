package org.jenetics.akka

import java.util.concurrent.Executor

import akka.actor.Actor
import akka.actor.Actor.Receive

import scala.concurrent.ExecutionContext

/**
 * @author <a href="mailto:franz.wilhelmstoetter@gmx.at">Franz Wilhelmstötter</a>
 * @since !__version__!
 * @version !__version__!
 */
class ExecutionActor(execution: ExecutionContext) extends Actor {

    override def receive: Receive = {
        case "String" =>
    }

}

object ExecutionActor {



}
