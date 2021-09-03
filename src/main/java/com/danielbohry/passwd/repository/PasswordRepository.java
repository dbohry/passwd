package com.danielbohry.passwd.repository;

import com.danielbohry.passwd.domain.Password;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PasswordRepository extends MongoRepository<Password, String> {

    List<Password> findByUserId(String id);

    void deleteByUserId(String id);

}
