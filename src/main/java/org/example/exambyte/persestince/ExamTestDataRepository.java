package org.example.exambyte.persestince;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface ExamTestDataRepository extends CrudRepository<ExamTestDTO , UUID> {

    Optional<ExamTestDTO> findById(UUID id);
}
