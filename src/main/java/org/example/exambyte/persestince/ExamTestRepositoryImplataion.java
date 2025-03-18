package org.example.exambyte.persestince;

import org.example.exambyte.applicationService.repository.ExamTestRepository;
import org.example.exambyte.domain.model.ExamTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ExamTestRepositoryImplataion implements ExamTestRepository {
    private final ExamTestRepository examTestRepository;


   public ExamTestRepositoryImplataion(ExamTestRepository examTestRepository) {
       this.examTestRepository = examTestRepository;
   }
    @Override
    public List<ExamTest> findAll() {
        return examTestRepository.findAll();
    }
    @Override
    public void save(ExamTest examTest) {
        examTestRepository.save(examTest);
    }
    @Override
    public void delete(ExamTest examTest) {
            examTestRepository.delete(examTest);
    }

    @Override
    public Optional<ExamTest> findById(UUID id) {
        return Optional.empty();
    }

}
