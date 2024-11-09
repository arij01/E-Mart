package tn.esprit.gateway;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
@EnableDiscoveryClient
public class GatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayApplication.class, args);
    }
    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customer-service", r->r.path("/customers/**")
                        .uri("http://localhost:8089/"))
                .route("UsreMicro", r->r.path("/auth/**")
                        .uri("http://localhost:8081/"))
                .route("notification-service", r->r.path("/default/**")
                        .uri("http://localhost:8086/"))
                .route("payment-service", r->r.path("/payments/**")
                        .uri("http://localhost:8086/"))

                .build();
    }
}