package com.templates.producer.routes;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.crypto.CryptoDataFormat;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;

@Component
public class ProducerRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        // configure ports for rest api calls
        restConfiguration().host("localhost").port(8000);

    }

    // create method to encrypt and decrypt messages
    private CryptoDataFormat createEncryptor() throws KeyStoreException, IOException, NoSuchAlgorithmException, CertificateException, UnrecoverableKeyException {
        KeyStore keyStore = KeyStore.getInstance("JCEKS");
        ClassLoader classLoader = getClass().getClassLoader();
        keyStore.load(classLoader.getResourceAsStream("myDesKey.jceks"), "someKeyStorePassword".toCharArray());
        Key sharedKey = keyStore.getKey("myDesKey.jceks", "someKeyStorePassword".toCharArray());

        CryptoDataFormat shared = new CryptoDataFormat("DES", sharedKey);
    }
}
