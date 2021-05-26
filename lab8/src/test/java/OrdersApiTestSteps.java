import entities.Message;
import entities.Order;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class OrdersApiTestSteps {
    private Response response;
    private String currency;
    private Order order;


    @Given("name is {string}")
    public void givenOrderId(String currency) {
        response = given()
                .contentType(ContentType.JSON)
                .param("postId", "2")
                .when()
                .get("https://api.genderize.io/?name=anna")
                        .then()
                        .extract().response();
    }

    @When("user try to get name by id")
    public void getOrderById() {
        //response = new ApiEndpoints().getOrderById();
    }

    @Then("user receive status code {int}")
    public void compareStatusCodes(int statusCode) {
        response.then().statusCode(statusCode);
    }

    @Then("user receive message {string}")
    public void compareResponseMessage(String expectedMessage) {
        Message message = response.body().as(Message.class);
        Assert.assertEquals(expectedMessage, message.getMessage());
    }

    @Then("response don't equal zero")
    public void checkThatResponseNotNull() {
        response.then().body(Matchers.notNullValue());
    }
}
