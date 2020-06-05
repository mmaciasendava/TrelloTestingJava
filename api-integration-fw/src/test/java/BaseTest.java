import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    private ResponseSpecification responseSpec;

    public ResponseSpecification getResponseSpec() {
        return responseSpec;
    }

    @BeforeSuite
    public void setUp() {
        responseSpec = new ResponseSpecBuilder().
                expectStatusCode(200).
                expectContentType(ContentType.JSON).
                build();
    }


}
