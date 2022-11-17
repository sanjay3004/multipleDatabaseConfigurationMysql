package com.example.multipledatabaseconfigurationmysql.repository.repo1;

import com.example.multipledatabaseconfigurationmysql.model.db1.View1;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ViewRepository extends JpaRepository<View1,String> {
}
