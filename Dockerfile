FROM anapsix/alpine-java:latest

RUN mkdir app
WORKDIR "/app"

RUN apk -U add curl
RUN curl -OLs http://central.maven.org/maven2/fish/payara/extras/payara-micro/4.1.2.172/payara-micro-4.1.2.172.jar
RUN curl -OLs http://central.maven.org/maven2/fish/payara/cloud/connectors/kafka/kafka-rar/0.1.0/kafka-rar-0.1.0.rar
	
COPY target/payara-kafka-mdb.war .
COPY init.sh .

CMD ["sh", "init.sh"]