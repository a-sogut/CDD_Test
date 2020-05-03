package Utils;

import io.qameta.allure.Epic;
import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.BeforeClass;

@Epic("CDD Plugins")
public class TestConfig {

    public static SUTDetails sutDetails;
    public static RequestSpecification requestSpec;
    public static ResponseSpecification responseSpec;

    @BeforeClass
    public static void setup() {
        sutDetails = SUTDetails.getInstance();

        requestSpec = new RequestSpecBuilder()
                .setBaseUri(sutDetails.getScheme() + "://" + sutDetails.getHost())
                .setPort(sutDetails.getPort())
                .setBasePath(sutDetails.getContextSuffix())
                .setContentType(ContentType.JSON)
                .setAccept(ContentType.JSON)
                .addFilter(new AllureRestAssured())
                .build();

        RestAssured.requestSpecification = requestSpec;

        responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .build();
    }
}