package org.example.exambyte.db;

import org.example.exambyte.application.repository.ExamTestRepository;
import org.example.exambyte.domain.model.ExamTest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ExamTestRepositoryImplataion implements ExamTestRepository {
    TestDAO testDAO;

    public ExamTestRepositoryImplataion(TestDAO testDAO) {
        this.testDAO = testDAO;
    }
    @Override
    public List<ExamTest> findAll() {
        return testDAO.findAll();
    }
    @Override
    public void save(ExamTest examTest) {
        testDAO.save(examTest);
    }
    @Override
    public void delete(ExamTest examTest) {
        testDAO.delete(examTest);
    }

    @Override
    public Optional<ExamTest> findById(UUID id) {
        return Optional.empty();
    }

}
