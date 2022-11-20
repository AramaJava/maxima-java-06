package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "org.example")
public class SpringConfig {

    @Bean
    public Sphynx sphynx() {
        return new Sphynx();
    }


    @Bean
    public TransportFactory transportFactory() {
        return new TransportFactory();
    }

    @Bean
    public Logistics logistics() {
        return new Logistics();
    }

    @Bean
    public Transport transport() {
        return new Transport() {
            @Override
            public float getPrice(City city) {
                return 0;
            }
        };
    }
}
