# Config Client with Spring Cloud Bus Enabled

* Needs an AMQP (Advanced Message Queuing Protocol) installed locally in order to work (look for RabbitMQ)
* Spring Bus automatically connects to local AMQP if no configuration is provided 
* Spring knows that this app is a message consumer (it will listen for messages that indicate that some configuration has changed) 
* When a message is received it might:
  * Automatically reload the properties from a @ConfigurationProperties class
  * Reload @RefreshScope beans
  * Change log level 