package pe.edu.upc.learning.platform.learning.domain.services;

import pe.edu.upc.learning.platform.learning.domain.model.aggregates.Course;
import pe.edu.upc.learning.platform.learning.domain.model.entities.LearningPathItem;
import pe.edu.upc.learning.platform.learning.domain.model.queries.GetAllCoursesQuery;
import pe.edu.upc.learning.platform.learning.domain.model.queries.GetCourseByIdQuery;
import pe.edu.upc.learning.platform.learning.domain.model.queries.GetCourseLearningPathItemByCourseIdAndTutorialIdQuery;

import java.util.List;
import java.util.Optional;

public interface CourseQueryService {
    Optional<Course> handle(GetCourseByIdQuery query);
    List<Course> handle(GetAllCoursesQuery query);
    Optional<LearningPathItem> handle(GetCourseLearningPathItemByCourseIdAndTutorialIdQuery query);
}