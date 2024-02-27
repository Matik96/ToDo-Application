package todoApp;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import todoApp.logic.ProjectService;
import todoApp.model.Project;
import todoApp.model.TaskGroupRepository;

import java.time.LocalDateTime;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.catchThrowable;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@SpringBootTest
class TodoAppApplicationTests {


    @Test
    @DisplayName("Test should throw IllegalStateException when configuration ok and no projcts for a given id")
    void createGroup_noMultipleGropusCOnfig_And_undoneGroupExists_throwsIllegalStateException() {
		//given
		TaskConfigurationProperties mockConfig = getConfigurationProperties();
		// system under test
        var toTest = new ProjectService(null, null, mockConfig);

        //when
        var exception = catchThrowable(() -> toTest.createGroup(LocalDateTime.now(), 0));

        //then
        assertThat(exception).isInstanceOf((IllegalStateException.class)).hasMessageContaining("one undone group");
    }

	private static TaskConfigurationProperties getConfigurationProperties() {
		var mockTemplate = mock(TaskConfigurationProperties.Template.class);
		when(mockTemplate.isAllowMultipleTasks()).thenReturn(true);
		//and
		var mockConfig = mock(TaskConfigurationProperties.class);
		when(mockConfig.getTemplate()).thenReturn(mockTemplate);
		return mockConfig;
	}
}
