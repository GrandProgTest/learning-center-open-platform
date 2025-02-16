package pe.edu.upc.learning.platform.learning.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * Value object representing the profile id.
 */
@Embeddable
public record ProfileId(Long profileId) {

    public ProfileId() {
        this(0L);
    }
    public ProfileId {
        if (profileId < 0) {
            throw new IllegalArgumentException("Profile profileId cannot be negative");
        }
    }
}