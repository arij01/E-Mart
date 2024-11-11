package tn.esprit.microservice.produit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ProduitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProduitApplication.class, args);
    }

}
