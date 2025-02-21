package fr.diginamic.PGDP.entities;

import fr.diginamic.PGDP.annotations.ValidDateRange;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Classe de test de la classe Project
 */
class ProjectTest {

    private Validator validator;

    /**
     * Initialisation du validateur
     */
    @BeforeEach
    void setUp() {
        try (ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory()) {
            validator = validatorFactory.getValidator();
        }
    }

    /**
     * Test de projets valides
     */
    @Test
    void testValidProject() {
        Project project = Project.builder()
                .name("Projet 1")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().plusDays(1))
                .contact("Contact")
                .creator(User.builder().build())
                .description("Description")
                .build();

        Project projectWithoutEnd = Project.builder()
                .name("Projet infinite")
                .startDate(LocalDate.now())
                .contact("Contact")
                .creator(User.builder().build())
                .description("Description")
                .build();

        Project projectInitiallyWithoutEnd = Project.builder()
                .name("Projet infinite")
                .startDate(LocalDate.now())
                .contact("Contact")
                .creator(User.builder().build())
                .description("Description")
                .build();

        projectInitiallyWithoutEnd.setEndDate(projectInitiallyWithoutEnd.getStartDate().plusDays(1));

        Set<ConstraintViolation<Project>> violations = validator.validate(project);
        Set<ConstraintViolation<Project>> violations2 = validator.validate(projectWithoutEnd);
        Set<ConstraintViolation<Project>> violations3 = validator.validate(projectInitiallyWithoutEnd);
        assertThat(violations).isEmpty();
        assertThat(violations2).isEmpty();
        assertThat(violations3).isEmpty();
    }

    /**
     * Test de projets invalides, le message d'erreur doit correspondre à celui dans l'annotation ValidDateRange
     */
    @Test
    void testInvalidProject() {
        Project projectStartBefore = Project.builder()
                .name("Projet 1")
                .startDate(LocalDate.now())
                .endDate(LocalDate.now().minusDays(1))
                .contact("Contact")
                .creator(User.builder().build())
                .description("Description")
                .build();

        Project projectStartAfter = Project.builder()
                .name("Projet 1")
                .startDate(LocalDate.now().plusDays(1))
                .endDate(LocalDate.now())
                .contact("Contact")
                .creator(User.builder().build())
                .description("Description")
                .build();

        Project projectInitiallyWithoutEnd = Project.builder()
                .name("Projet infinite")
                .startDate(LocalDate.now())
                .contact("Contact")
                .creator(User.builder().build())
                .description("Description")
                .build();

        projectInitiallyWithoutEnd.setEndDate(projectInitiallyWithoutEnd.getStartDate().minusDays(1));

        Set<ConstraintViolation<Project>> violations = validator.validate(projectStartBefore);
        Set<ConstraintViolation<Project>> violations2 = validator.validate(projectStartAfter);
        Set<ConstraintViolation<Project>> violations3 = validator.validate(projectInitiallyWithoutEnd);
        assertThat(violations).hasSize(1);
        assertThat(violations2).hasSize(1);
        assertThat(violations3).hasSize(1);
        String expectedErrorMessage = ValidDateRange.ERROR_MESSAGE;
        assertThat(violations.iterator().next().getMessage()).isEqualTo(expectedErrorMessage);
        assertThat(violations2.iterator().next().getMessage()).isEqualTo(expectedErrorMessage);
        assertThat(violations3.iterator().next().getMessage()).isEqualTo(expectedErrorMessage);
    }
}