package org.example.demojpaspringdata;

import org.example.demojpaspringdata.entities.Product;
import org.example.demojpaspringdata.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class DemoJpaSpringdataApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoJpaSpringdataApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            Product p1 = new Product();
            p1.setName("Computer");
            p1.setPrice(3400);
            p1.setQuantity(3);
            Product p2 = new Product(null, "Printer", 3000, 9);
            Product p3 = Product.builder()
                    .name("SmartPhone")
                    .price(2000)
                    .quantity(5)
                    .build();
            productRepository.save(p2);
            productRepository.save(p1);
            productRepository.save(p3);

            List<Product> products = productRepository.findAll();
            products.forEach(p-> {
                System.out.println(p.toString());

            });


        };
    }
}
