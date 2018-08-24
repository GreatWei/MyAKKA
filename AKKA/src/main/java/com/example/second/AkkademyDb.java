package com.example.second;

import akka.actor.AbstractActor;
import akka.actor.Status;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.pf.ReceiveBuilder;
import com.example.second.message.GetRequest;
import com.example.second.message.KeyNotFoundException;
import com.example.second.message.SetRequest;

import java.util.HashMap;
import java.util.Map;

public class AkkademyDb extends AbstractActor {
    protected final LoggingAdapter log = Logging.getLogger(context().system(), this);
    protected final Map<String, Object> map = new HashMap<String, Object>();

    private AkkademyDb() {
        receive(ReceiveBuilder.
                match(SetRequest.class, message -> {
                    log.info("Received Set request: {}", message);
                    map.put(message.key, message.value);
                    System.out.println("SetRequest:"+map.toString());
                    sender().tell(new Status.Success(message.key), self());
                }).
                match(GetRequest.class, message -> {
                    log.info("Received Get request: {}", message);
                    System.out.println("GetRequest:"+map.toString());
                    Object value = map.get(message.key);
                    Object response = (value != null)
                            ? value
                            : new Status.Failure(new KeyNotFoundException(message.key));
                    sender().tell(response, self());
                }).
                matchAny(o ->
                        sender().tell(new Status.Failure(new ClassNotFoundException()), self())
                ).build()
        );
    }
}