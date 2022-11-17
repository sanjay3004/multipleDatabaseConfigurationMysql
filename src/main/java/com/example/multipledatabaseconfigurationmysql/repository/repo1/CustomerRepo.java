package com.example.multipledatabaseconfigurationmysql.repository.repo1;

import com.example.multipledatabaseconfigurationmysql.model.db1.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepo extends JpaRepository<Customer,Integer> {
}
