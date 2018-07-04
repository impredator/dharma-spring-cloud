# Spring boot + spring cloud

1. eureka service discovery & admin: eureka client (product-service + api-gateway) + eureka-server
2. config-server: config-client & config-server & config-server-repo
3. service tracing & diagnose: zipkin-sleuth -> jar -jar zipkin-server-2.9.4-exec.jar & start four services
4. circuit breaker: caller(hystrix-circuit-breaker) + callee(product-service)
5. zuul gateway: zuul-gateway + product-service
