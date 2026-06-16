package adapters;

import com.google.gson.Gson;
import io.restassured.http.ContentType;
import io.restassured.module.jsv.JsonSchemaValidator;
import models.ProjectRq;
import models.ProjectRs;

import static io.restassured.RestAssured.given;

public class ProjectAdapter extends BaseAdapter{

    static Gson gson = new Gson();

    public static ProjectRs createProject(ProjectRq projectRq) {
        return given()
                .spec(spec)
                .body(gson.toJson(projectRq))
                .log().all()
                .when()
                .post("/project")
                .then()
                .body(JsonSchemaValidator.matchesJsonSchemaInClasspath("schema/projectSchema.json"))
                .log().all()
                .spec(ok200)
                .extract()
                .as(ProjectRs.class);
    }

    public static ProjectRs getProject(String code) {
        return given()
                .spec(spec)
                .pathParam("code", code)
                .log().all()
                .when()
                .get("/project/{code}")
                .then()
                .log().all()
                .spec(ok200)
                .extract()
                .as(ProjectRs.class);
    }

    public static void deleteProject(String code) {
        given()
                .spec(spec)
                .pathParam("code", code)
                .log().all()
                .when()
                .delete("/project/{code}")
                .then()
                .log().all()
                .spec(ok200);
    }

}
