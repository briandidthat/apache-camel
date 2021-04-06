# apache-camel

#### First run the following command to start activemq in a docker container for messaging.
```sh docker run -p 61616:61616 -p 8161:8161 rmohr/activemq```

#### Generate an encryption key using JCEKS 
```sh keytool -genseckey -alias myDesKey -keypass someKeyPassword -keystore myDesKey.jceks -storepass someKeystorePassword -v -storetype JCEKS -keyalg DES```
