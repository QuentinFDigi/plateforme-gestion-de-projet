package fr.diginamic.PGDP.managers;

import fr.diginamic.PGDP.dtos.projects.ProjectDto;
import fr.diginamic.PGDP.entities.Project;
import fr.diginamic.PGDP.repositories.ProjectRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.time.LocalDate;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@SpringBootTest
@ActiveProfiles("test")
class ProjectManagerTest {

    @Mock
    ProjectRepository projectRepository;

    @InjectMocks
    ProjectManager projectManager;

    Project project;

    @BeforeEach
    void setUp() {
        project = Project.builder()
                .id(1)
                .name("Projet 1")
                .startDate(LocalDate.of(2025, 1, 1))
                .build();
    }

    @Test
    void findById() {
        ProjectDto projectDto = projectManager.findById(1);
        when(projectRepository.findById(1)).thenReturn(Optional.of(project));
        assertThat(projectDto.getId()).isEqualTo(null);
    }

    @Test
    void addProject() {
    }

    @Test
    void delete() {
    }

    @Test
    void addUserToProject() {
    }

    @Test
    void deleteUser() {
    }
}