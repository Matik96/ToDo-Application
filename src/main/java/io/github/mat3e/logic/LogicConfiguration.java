package io.github.mat3e.logic;


import io.github.mat3e.TaskConfigurationProperties;
import io.github.mat3e.model.ProjectRepository;
import io.github.mat3e.model.TaskGroupRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogicConfiguration {

    @Bean
    ProjectService service(final ProjectRepository repository,
                           final TaskGroupRepository taskRepository,
                           final TaskConfigurationProperties config) {
        return new ProjectService(repository, taskRepository, config);
    }
}
