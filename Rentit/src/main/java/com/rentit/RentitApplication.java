package com.rentit;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.thymeleaf.extras.java8time.dialect.Java8TimeDialect;
import com.rentit.data_source.BookingsDataGateway;
import com.rentit.data_source.ClerksDataGateway;
import com.rentit.data_source.ClientsDataGateway;
import com.rentit.model.Clients;
import com.rentit.model.ClientsDataMapper;

@SpringBootApplication
public class RentitApplication {

  @Bean
  public Java8TimeDialect java8TimeDialect() {
    return new Java8TimeDialect();
  }

  public static void main(String[] args) {
    SpringApplication.run(RentitApplication.class, args);
  }

}
