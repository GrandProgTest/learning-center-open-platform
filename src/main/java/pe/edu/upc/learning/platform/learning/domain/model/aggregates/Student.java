package pe.edu.upc.learning.platform.learning.domain.model.aggregates;

import jakarta.persistence.*;
import lombok.Getter;
import pe.edu.upc.learning.platform.learning.domain.model.valueobjects.AcmeStudentRecordId;
import pe.edu.upc.learning.platform.learning.domain.model.valueobjects.ProfileId;
import pe.edu.upc.learning.platform.learning.domain.model.valueobjects.StudentPerformanceMetricSet;
import pe.edu.upc.learning.platform.shared.domain.model.entities.AuditableModel;

/**
 * Represents a student.
 * The student is an aggregate root.
 */
@Entity
public class Student extends AuditableModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Embedded
    @Column(name = "acme_student_id")
    private final AcmeStudentRecordId acmeStudentRecordId;

    @Embedded
    private ProfileId profileId;

    @Embedded
    private StudentPerformanceMetricSet performanceMetricSet;

    public Student() {
        this.acmeStudentRecordId = new AcmeStudentRecordId();
        this.performanceMetricSet = new StudentPerformanceMetricSet();
    }

    public Student(Long profileId) {
        this();
        this.profileId = new ProfileId(profileId);
    }

    public Student(ProfileId profileId) {
        this();
        this.profileId = profileId;
    }

    /**
     * Updates the student metrics when a course is completed.
     * It increments the total completed courses.
     *
     */
    public void updateMetricsOnCourseCompleted() {
        this.performanceMetricSet = this.performanceMetricSet.incrementTotalCompletedCourses();
    }

    /**
     * Updates the student metrics when a tutorial is completed.
     * It increments the total completed tutorials.
     *
     */
    public void updateMetricsOnTutorialCompleted() {
        this.performanceMetricSet = this.performanceMetricSet.incrementTotalTutorials();
    }

    public String getStudentRecordId() {
        return this.acmeStudentRecordId.studentRecordId();
    }

    public Long getProfileId() {
        return this.profileId.profileId();
    }
}