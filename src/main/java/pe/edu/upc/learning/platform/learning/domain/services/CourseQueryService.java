package pe.edu.upc.learning.platform.learning.domain.services;

import pe.edu.upc.learning.platform.learning.domain.model.aggregates.Course;
import pe.edu.upc.learning.platform.learning.domain.model.entities.LearningPathItem;
import pe.edu.upc.learning.platform.learning.domain.model.queries.*;

import java.util.List;
import java.util.Optional;

public interface CourseQueryService {
    Optional<Course> handle(GetCourseByIdQuery query);
    List<Course> handle(GetAllCoursesQuery query);
    Optional<LearningPathItem> handle(GetCourseLearningPathItemByCourseIdAndTutorialIdQuery query);
}