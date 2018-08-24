package com.example.first;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.testkit.TestActorRef;
import com.example.second.JavaPongActor;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AkkademyDbTest {
    ActorSystem system = ActorSystem.create();

    @Test
    public void itShouldPlaceKeyValueFromSetMessageIntoMap() {
        TestActorRef<AkkademyDb> actorRef =
                TestActorRef.create(system, Props.create(AkkademyDb.class));
        actorRef.tell(
                new SetRequest("key", "value"), ActorRef.noSender());
        actorRef.tell(
                new SetRequest("key1", "value1"), ActorRef.noSender());
        AkkademyDb akkademyDb = actorRef.underlyingActor();
        assertEquals(akkademyDb.map.get("key"), "value");
        System.out.println(akkademyDb.map.get("key1"));
    }

    @Test
    public void second() {
        TestActorRef<JavaPongActor> actorRef =
                TestActorRef.create(system, Props.create(JavaPongActor.class));
        actorRef.tell(
                "Ping", ActorRef.noSender());
        JavaPongActor javaPongActor = actorRef.underlyingActor();
    }
}
