package pe.edu.upc.learning.platform.learning.application.internal.commandservices;

import org.springframework.stereotype.Service;
import pe.edu.upc.learning.platform.learning.domain.model.aggregates.Course;
import pe.edu.upc.learning.platform.learning.domain.model.commands.AddTutorialToCourseLearningPathCommand;
import pe.edu.upc.learning.platform.learning.domain.model.commands.CreateCourseCommand;
import pe.edu.upc.learning.platform.learning.domain.model.commands.DeleteCourseCommand;
import pe.edu.upc.learning.platform.learning.domain.model.commands.UpdateCourseCommand;
import pe.edu.upc.learning.platform.learning.domain.services.CourseCommandService;
import pe.edu.upc.learning.platform.learning.infrastructure.persistence.jpa.repositories.CourseRepository;

import java.util.Optional;

@Service
public class CourseCommandServiceImpl implements CourseCommandService {

    private final CourseRepository courseRepository;

    public CourseCommandServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    @Override
    public Long handle(CreateCourseCommand command) {
        if (courseRepository.existsByTitle(command.title())) {
            throw new IllegalArgumentException("Course with same title already exists");
        }
        var course = new Course(command.title(), command.description());
        courseRepository.save(course);
        return course.getId();
    }

    @Override
    public Optional<Course> handle(UpdateCourseCommand command) {
        if (!courseRepository.existsById(command.id()))
            throw new IllegalArgumentException("Course does not exist");
        var courseToUpdate = courseRepository.findById(command.id()).get();
        if (courseRepository.existsByTitleAndIdIsNot(command.title(), command.id()))
            throw new IllegalArgumentException("Course with same title already exists");
        var updatedCourse = courseRepository.save(courseToUpdate.updateInformation(command.title(), command.description()));
        return Optional.of(updatedCourse);
    }

    @Override
    public void handle(DeleteCourseCommand command) {
        if (!courseRepository.existsById(command.courseId())) {
            throw new IllegalArgumentException("Course does not exist");
        }
        courseRepository.deleteById(command.courseId());
    }

    @Override
    public void handle(AddTutorialToCourseLearningPathCommand command) {
        if (!courseRepository.existsById(command.courseId())) {
            throw new IllegalArgumentException("Course does not exist");
        }
        courseRepository.findById(command.courseId()).map(course -> {
            course.addTutorialToLearningPath(command.tutorialId());
            courseRepository.save(course);
            System.out.println("Tutorial added to learning path");
            return course;
        });
    }
}