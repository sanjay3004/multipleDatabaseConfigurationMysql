package com.example.multipledatabaseconfigurationmysql;

import com.example.multipledatabaseconfigurationmysql.model.db1.Customer;
import com.example.multipledatabaseconfigurationmysql.model.db2.Product;
import com.example.multipledatabaseconfigurationmysql.repository.repo1.CustomerRepo;
import com.example.multipledatabaseconfigurationmysql.repository.repo1.ViewRepository;
import com.example.multipledatabaseconfigurationmysql.repository.repo2.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;

@SpringBootApplication
public class MultipleDatabaseConfigurationMysqlApplication implements CommandLineRunner  {

    @Autowired
    CustomerRepo customerRepo;

    @Autowired
    ProductRepo productRepo;

    @Autowired
    ViewRepository viewRepository;

    public static void main(String[] args) {
        SpringApplication.run(MultipleDatabaseConfigurationMysqlApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        productRepo.save(new Product("lap",70000));
        customerRepo.save(new Customer("sithik","kilvelur"));
    }
}
