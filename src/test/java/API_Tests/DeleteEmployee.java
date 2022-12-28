package API_Tests;

import apiEngine.model.requests.CreateEmployeeRequest;
import apiEngine.model.requests.UpdateEmployeeRequest;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.util.Map;

public class DeleteEmployee {
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
    }
    @Test
    public void getAllEmployees() throws IOException {
        //Create request POJO
        String name = "Sandra";
        String salary = "2500";
        String age = "20";
        CreateEmployeeRequest createEmployee = new CreateEmployeeRequest(name, salary, age);
        Integer employeeID = createEmployee.CreateEmployee();
        Response response;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.delete("delete/"+employeeID);
        Assert.assertEquals(200, response.statusCode());
        String jsonString = response.asString();
        String responseEmployeeID = JsonPath.from(jsonString).get("data");
        Assert.assertEquals(employeeID.toString(), responseEmployeeID);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertAll();
    }
}
