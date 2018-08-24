package com.example.second;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;


public class PongActorTest {
    public static void main(String[] args) {
        ActorSystem actorSystem = ActorSystem.create();
        ActorRef actorRef = actorSystem.actorOf(Props.create(JavaPongActor.class), "javaPongActor");
        actorRef.tell("Ping", ActorRef.noSender());
    }
}
