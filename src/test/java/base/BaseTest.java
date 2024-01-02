package base;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import static io.restassured.RestAssured.given;

public class BaseTest {
    protected static RequestSpecification requestSpec;
    protected static String boardID;


    @BeforeClass
    public static void createRequestSpecifications(){
        requestSpec=new RequestSpecBuilder()
                .setBaseUri("https://api.trello.com")
                .addQueryParam("token","ATATT3xFfGF0J89hY2Z4EySNMGZRtrmEp1xDGg9VFhNhhTyX6e6NCuuf9COn3VHYcrPl4SxMRSDGc6mamgcv9p3S1buW2hqgj2c_uvWp0EGdHslhAPOrNhDl6oMXYHBCX9HUlJ9h7YTOf0dIUtoru1VLu1o4SsKitG6osa40PzlpUZMmq9mXhoc=69B21785")
                .addQueryParam("key","c711224c69f52ef7b779aeabcac5e2f1")
                .addHeader("Content-Type","application/json")
                .build();
    }
    @AfterClass
    public void deleteBoard(){
        given().spec(requestSpec)
                .pathParam("id", boardID)
                .body("")
                .when().delete("1/boards/{id}");

    }
    @DataProvider(name="BoardField")
    public Object [][] getData(){
        return new Object[][]{
                {"idMemberCreator"},
                {"idOrganization"},
                {"desc"},
                {"name"}
        };
    }

}
