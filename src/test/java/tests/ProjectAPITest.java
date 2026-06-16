package tests;

import adapters.ProjectAdapter;
import com.google.gson.Gson;
import io.restassured.http.ContentType;
import models.ProjectRq;
import models.ProjectRs;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import static adapters.ProjectAdapter.createProject;

public class ProjectAPITest {

    ProjectRq rq = ProjectRq.builder()
            .title("test1")
            .code("AR")
            .description("test")
            .group("test")
            .access("all")
            .build();

    @Test
    public void checkCreateProject() {
        ProjectRs rs = createProject(rq);
        assertTrue(rs.status);
        assertEquals(rs.result.code,"AR");
        ProjectAdapter.deleteProject("AR");
    }

    @Test
    public void checkGetProject() {
        createProject(rq);
        ProjectRs rs = ProjectAdapter.getProject("AR");
        assertTrue(rs.status);
        assertEquals(rs.result.code, "AR");
        ProjectAdapter.deleteProject("AR");
    }

    @Test
    public void checkDeleteProject() {
        createProject(rq);
        ProjectAdapter.deleteProject("AR");
    }
}
