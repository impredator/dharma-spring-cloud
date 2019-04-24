# Spring boot + spring cloud

###Features:
1. eureka service discovery & admin: eureka client (product-service + api-gateway) + eureka-server
2. config-server: config-client & config-server & config-server-repo
3. service tracing & diagnose: zipkin-sleuth -> jar -jar zipkin-server-2.9.4-exec.jar & start four services
4. circuit breaker: caller(hystrix-circuit-breaker) + callee(product-service)
5. zuul gateway: zuul-gateway + product-service

###Steps:
#### 1. Start `eureka-server`
##### It is Eureka server which keeps waiting for client join
#### 2. Start `product-service`, then `dharma-service`
##### they are Eureka client, will auto register to Eureka server
##### `dharma-service` call `product-service` using Feign
#### 3. Start `config-server`, then `config-client`
##### make sure that local repo uri is correct, here is `config-server-repo`

