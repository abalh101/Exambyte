package org.example.exambyte.persestince;

import java.util.stream.Collectors;
import org.example.exambyte.applicationService.repository.ExamTestRepository;
import org.example.exambyte.domain.model.ExamTest;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class ExamTestRepositoryImplataion implements ExamTestRepository {

  private final ExamTestDataRepository dataRepository;


  public ExamTestRepositoryImplataion(ExamTestDataRepository dataRepository) {
    this.dataRepository = dataRepository;
  }



  @Override
  public List<ExamTest> findAll() {
    List<ExamTestDTO> dtoList = (List<ExamTestDTO>) dataRepository.findAll();
    return dtoList.stream().map(this::toExamTest).toList();
  }

  @Override
  public void save(ExamTest examTest) {
    dataRepository.save(toDTO(examTest));
  }

  @Override
  public void delete(ExamTest examTest) {
    dataRepository.deleteById(examTest.getId());
  }

  @Override
  public Optional<ExamTest> findById(UUID id) {
    return dataRepository.findById(id)
        .map(this::toExamTest);
  }

  private ExamTestDTO toDTO(ExamTest examTest) {
    return new ExamTestDTO(
        examTest.getId(),
        examTest.getName(),
        examTest.getMaximalpunktzahl(),
        examTest.getStartzeitpunkt(),
        examTest.getEndzeitpunkt(),
        examTest.getErgebnisVeröffentlichungszeitpunkt(),
        examTest.getFragen()
    );
  }

  private ExamTest toExamTest(ExamTestDTO examTestDTO) {
    return new ExamTest(
        examTestDTO.id(),
        examTestDTO.name(),
        examTestDTO.maximalpunktzahl(),
        examTestDTO.startzeitpunkt(),
        examTestDTO.endzeitpunkt(),
        examTestDTO.ergebnisVeröffentlichungszeitpunkt(),
        examTestDTO.fragen()
    );
  }
}
