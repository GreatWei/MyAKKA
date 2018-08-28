package com.example;

import akka.actor.AbstractActor;
import akka.japi.pf.ReceiveBuilder;
import de.l3s.boilerpipe.extractors.ArticleExtractor;
import scala.PartialFunction;

public class ParsingActor extends AbstractActor {
    public PartialFunction receive() {
        return ReceiveBuilder.
                match(ParseHtmlArticle.class, msg -> {
                    String body = ArticleExtractor.INSTANCE.getText(msg.htmlString);
                    System.out.println("ParsingActor body:--"+body);
                    sender().tell(new ArticleBody(msg.uri, body), self());
                }).build();
    }
}