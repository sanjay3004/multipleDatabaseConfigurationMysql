package com.example.multipledatabaseconfigurationmysql.repository.repo2;

import com.example.multipledatabaseconfigurationmysql.model.db2.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepo extends JpaRepository<Product,Integer> {
}
