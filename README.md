# UDP-Kafka-Bridge

Sends any message received from a specified UDP port to a specified [kafka](http://kafka.apache.org/) topic.

## Run

To listen on port `10514` and use `mytopic` on a local broker just run:

    java -jar udp-kafka-bridge-assembly-0.1.jar

To modify default values you may use java system properties such as:

    java \
    -Dbind.host=0.0.0.0 \
    -Dbind.port=10514 \
    -Dtopic=mytopic \
    -Dkafka.metadata.broker.list=localhost:9092 \
    -Dkafka.serializer.class=kafka.serializer.StringEncoder \
    -Dkafka.compression.codec=1 \
    -Dkafka.producer.type=async \
    -jar udp-kafka-bridge-assembly-0.1.jar
    
Or create a config file like that:

    bind.host = "0.0.0.0"
    bind.port = 10514
    topic = mytopic 

    kafka {
        metadata.broker.list = "localhost:9092"
        producer.type = "async"
        serializer.class = "kafka.serializer.StringEncoder"
        compression.codec = "1"
    }

Name it like `bridge.conf` and run it with:

    java -Dconfig.file=bridge.conf -jar udp-kafka-bridge-assembly-0.1.jar
    
Kafka producer settings are not limited with those. You can use any of them by prefixing with `kafka.` for system properties or placing inside `kafka{}` for config file as shown above.

Project uses [logback](http://logback.qos.ch/) for logging and default place for log files is `logs/` under cwd. If you'd like to change that you should provide another `logback.xml` to classpath.

## Develop

You'll need a recent version of [sbt](http://www.scala-sbt.org/) installed.

    git clone https://github.com/agaoglu/udp-kafka-bridge.git
    cd udp-kafka-bridge
    sbt assembly
    
## License

APLv2
