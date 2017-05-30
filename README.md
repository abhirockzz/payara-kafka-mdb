# Consume from Kafka topics using Message Driven Beans

- [Here](https://abhirockzz.wordpress.com/2017/05/30/consume-from-kafka-topics-using-message-driven-beans) is the blog
- [Here](https://github.com/payara/Cloud-Connectors/tree/master/Kafka) is the Payara Kafka Connector project

## To run

- `git clone https://github.com/abhirockzz/payara-kafka-mdb.git`
- `mvn clean install` - will create `payara-kafka-mdb.war` in `target` directory
- `docker-compose up --build`
- To clean up - `docker-compose down -v`
