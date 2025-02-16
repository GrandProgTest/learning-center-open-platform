package pe.edu.upc.learning.platform.learning.domain.services;

import pe.edu.upc.learning.platform.learning.domain.model.commands.*;

public interface EnrollmentCommandService {
    Long handle(RequestEnrollmentCommand command);
    Long handle(ConfirmEnrollmentCommand command);
    Long handle(RejectEnrollmentCommand command);

    Long handle(CancelEnrollmentCommand command);

    Long handle(CompleteTutorialForEnrollmentCommand command);
}