package com.smartpill.smartpill_backend.repository;

import com.smartpill.smartpill_backend.model.PriseMedicament;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PriseMedicamentRepository extends MongoRepository<PriseMedicament, String> {
}