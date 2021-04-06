package com.templates.consumer.routes;

import com.templates.consumer.beans.EncryptionBean;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumerRouter extends RouteBuilder {
    @Autowired
    private EncryptionBean encryptionBean;

    @Override
    public void configure() throws Exception {
        // consume messages being sent to the activemq queue
        from("activemq:my-activemq-queue")
                // decrypt data using encryption bean
                .unmarshal(encryptionBean.createEncryptor())
                .to("log:received-message-from-producer");
    }


}
