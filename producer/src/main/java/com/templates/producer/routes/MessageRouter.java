package com.templates.producer.routes;

import com.templates.producer.beans.EncryptionBean;
import com.templates.producer.domain.Message;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

//@Component
public class MessageRouter extends RouteBuilder {
    @Autowired
    private EncryptionBean encryptionBean;

    @Override
    public void configure() throws Exception {
        // send a message every 10 seconds using the timer param
        from("timer:active-mq-timer?period=10000")
                .transform().constant(new Message(1L, "Bill", "Kev", "Hi."))
                .convertBodyTo(String.class)
                // encrypt data using an encryption bean
                .marshal(encryptionBean.createEncryptor())
                // send to my-activemq-queue
                .to("activemq:my-activemq-queue");
    }
}
