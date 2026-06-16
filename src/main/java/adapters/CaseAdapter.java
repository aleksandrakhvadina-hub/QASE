package adapters;

import com.google.gson.Gson;
import models.CaseRq;
import models.CaseRs;

import static io.restassured.RestAssured.given;

public class CaseAdapter extends BaseAdapter {

    static Gson gson = new Gson();

    public static CaseRs createCase(String projectCode, CaseRq caseRq) {
        return given()
                .spec(spec)
                .pathParam("code", projectCode)
                .body(gson.toJson(caseRq))
                .log().all()
                .when()
                .post("/case/{code}")
                .then()
                .log().all()
                .spec(ok200)
                .extract()
                .as(CaseRs.class);
    }
}
