package com.project.emailSender.Dao;

import com.project.emailSender.Model.Email;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepo extends MongoRepository<Email,String> {
}
