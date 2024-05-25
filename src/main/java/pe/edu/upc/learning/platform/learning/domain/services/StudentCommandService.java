package pe.edu.upc.learning.platform.learning.domain.services;
import pe.edu.upc.learning.platform.learning.domain.model.commands.*;
import pe.edu.upc.learning.platform.learning.domain.model.valueobjects.AcmeStudentRecordId;

public interface StudentCommandService {
    AcmeStudentRecordId handle(CreateStudentCommand command);
    AcmeStudentRecordId handle(UpdateStudentMetricsOnTutorialCompletedCommand command);
}