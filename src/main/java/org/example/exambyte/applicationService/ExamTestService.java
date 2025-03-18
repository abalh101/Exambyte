package org.example.exambyte.applicationService;

import org.example.exambyte.applicationService.repository.ExamTestRepository;
import org.example.exambyte.domain.model.ExamTest;
import org.example.exambyte.persestince.ExamTestDTO;

import java.util.List;

public class ExamTestService {

    private final ExamTestRepository examTestRepository;

    public ExamTestService(ExamTestRepository examTestRepository) {
        this.examTestRepository = examTestRepository;

    }
    public List<ExamTest> findAll() {
        return examTestRepository.findAll();
    }
    public void save(ExamTest examTest) {
        examTestRepository.save(examTest);
    }
    public void delete(ExamTest examTest) {
        examTestRepository.delete(examTest);
    }

}
