package com.example.multipledatabaseconfigurationmysql.repository;

import com.example.multipledatabaseconfigurationmysql.model.Address;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AddressRepo extends MongoRepository<Address,String> {
}
