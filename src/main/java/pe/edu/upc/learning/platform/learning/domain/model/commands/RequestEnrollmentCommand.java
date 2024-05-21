package pe.edu.upc.learning.platform.learning.domain.model.commands;

import pe.edu.upc.learning.platform.learning.domain.model.valueobjects.AcmeStudentRecordId;

public record RequestEnrollmentCommand(AcmeStudentRecordId studentRecordId, Long courseId) {
}
