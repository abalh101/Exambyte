package org.example.exambyte.persestince;

import org.example.exambyte.domain.model.ExamTest;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;
import java.util.Optional;
import java.util.UUID;

public interface ExamTestDataRepository extends CrudRepository<ExamTestDTO , UUID> {
    Collection<ExamTest> findall();
    ExamTestDTO save(ExamTestDTO dto);
    Optional<ExamTest>findBy(UUID id);
}
