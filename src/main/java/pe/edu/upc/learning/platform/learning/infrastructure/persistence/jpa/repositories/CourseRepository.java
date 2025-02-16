package pe.edu.upc.learning.platform.learning.infrastructure.persistence.jpa.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.edu.upc.learning.platform.learning.domain.model.aggregates.Course;

import java.util.Optional;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    Optional<Course> findByTitle(String title);
    boolean existsByTitle(String title);
    boolean existsByTitleAndIdIsNot(String title, Long id);
}