package org.example.exambyte.applicationService.repository;

import org.example.exambyte.domain.model.ExamTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ExamTestRepository {
    List<ExamTest> findAll();
    void save(ExamTest examTest);
    void delete(ExamTest examTest);
    
    Optional<ExamTest> findById(UUID id);
}
