package org.example.exambyte.db;
import org.example.exambyte.domain.model.ExamTest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;


public interface TestDAO extends CrudRepository<ExamTest , UUID> {
    List<ExamTest> findAll();
    List<ExamTest> findByIdIn(List<UUID> ids);
}
