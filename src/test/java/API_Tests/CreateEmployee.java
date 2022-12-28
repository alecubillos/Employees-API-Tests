package API_Tests;

import apiEngine.model.requests.CreateEmployeeRequest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class CreateEmployee
{
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
    }
    @Test
    public void successfullyCreateEmployee() throws IOException {
        //POJO data to be sent in request
        String name = "Sandra";
        String salary = "2500";
        String age = "20";

        //Create request POJO
        CreateEmployeeRequest createEmployee = new CreateEmployeeRequest(name, salary, age);
        Response response;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body(createEmployee).post("create");
        Assert.assertEquals(200, response.statusCode());
        String jsonString = response.asString();
        Map<String, String> employee = JsonPath.from(jsonString).get("data");
        String responseEmployeeName = employee.get("name");
        String responseEmployeeSalary = employee.get("salary");
        String responseEmployeeAge = employee.get("age");
        Assert.assertEquals(name, responseEmployeeName);
        Assert.assertEquals(salary, responseEmployeeSalary);
        Assert.assertEquals(age, responseEmployeeAge);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }
}
