package adapters;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseAdapter {

    public static Gson gson = new GsonBuilder()
            .excludeFieldsWithModifiers()
            .setPrettyPrinting()
            .create();


    public static RequestSpecification spec = new RequestSpecBuilder()
            .setContentType(ContentType.JSON)
            .setBaseUri("https://api.qase.io")
            .setBasePath("/v1")
            .addHeader("Token", "2f9121fe8cd6ad496e6b5a70002c7b0e96afaee5df62a454df42c045be7e6ce3")
            .build();

    public static ResponseSpecification ok200 = new ResponseSpecBuilder()
            .expectStatusCode(200)
            .build();
}
