package com.example.second;

import akka.actor.AbstractActor;
import akka.actor.ActorRef;
import akka.actor.Props;
import akka.actor.Status;
import akka.japi.pf.ReceiveBuilder;
import scala.PartialFunction;

public class JavaPongActor extends AbstractActor {
    public PartialFunction receive() {
        return ReceiveBuilder
                .matchEquals("Ping", s ->
                        sender().tell("Pong", ActorRef.noSender()))
//                .matchAny(x ->
//                        sender().tell(
//                                new Status.Failure(new Exception("unknown message")), self()
//                        ))
                .matchAny(x ->
                        sender().tell(
                                "haha", ActorRef.noSender()
                        ))
                .build();

//       return ReceiveBuilder
//                .matchEquals("Ping", s -> System.out.println("It's Ping: " + s))
//                .match(String.class, s -> System.out.println("It's a string: " + s))
//                .matchAny(x -> System.out.println("It's something else: " + x))
//                .build();
    }


}
