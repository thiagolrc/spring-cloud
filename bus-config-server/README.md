# Config Server with Spring Cloud Bus Enabled

* Needs an AMQP (Advanced Message Queuing Protocol) installed locally in order to work (look for RabbitMQ)
* Spring Bus automatically connects to local AMQP if no configuration is provided 
* Spring knows that this app is a message producer (this app will send messages to the queue telling consumers that the configuration has changed) 
* A POST to http://localhost:8001/actuator/bus-refresh will propagate the config changes to all clients registered to the 'bus' 