package tests;

import adapters.CaseAdapter;
import adapters.ProjectAdapter;
import models.CaseRq;
import models.CaseRs;
import models.ProjectRq;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

public class CaseAPITest {

    private String projectCode = "T" + System.currentTimeMillis() % 1000000000L;

    @BeforeMethod
    public void createProject() {
        ProjectRq project = ProjectRq.builder()
                .title("Test Project for Case")
                .code(projectCode)
                .description("Test")
                .access("all")
                .build();
        ProjectAdapter.createProject(project);
    }

    @AfterMethod
    public void deleteProject() {
        ProjectAdapter.deleteProject(projectCode);
    }

    @Test
    public void checkCreateCase() {
        CaseRq caseRq = CaseRq.builder()
                .title("New Test Case")
                .description("Description")
                .build();

        CaseRs rs = CaseAdapter.createCase(projectCode, caseRq);

        assertTrue(rs.status);
        assertNotNull(rs.result);
        assertNotNull(rs.result.id);
    }
}
