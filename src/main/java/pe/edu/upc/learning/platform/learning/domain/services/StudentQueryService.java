package pe.edu.upc.learning.platform.learning.domain.services;

import pe.edu.upc.learning.platform.learning.domain.model.aggregates.Student;
import pe.edu.upc.learning.platform.learning.domain.model.queries.*;

import java.util.Optional;

public interface StudentQueryService {
    Optional<Student> handle(GetStudentByProfileIdQuery query);
    Optional<Student> handle(GetStudentByAcmeStudentRecordIdQuery query);
}