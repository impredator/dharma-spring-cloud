#!/usr/bin/env bash

mvn clean install

java -jar zipkin-service-1/target/zipkin-service-1-0.0.1-SNAPSHOT.jar &
java -jar zipkin-service-2/target/zipkin-service-2-0.0.1-SNAPSHOT.jar &
java -jar zipkin-service-3/target/zipkin-service-3-0.0.1-SNAPSHOT.jar &
java -jar zipkin-service-4/target/zipkin-service-4-0.0.1-SNAPSHOT.jar &

