package API_Tests;
import io.restassured.RestAssured;
import apiEngine.model.requests.UpdateEmployeeRequest;
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
public class UpdateEmployee {
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
    }
    @Test
    public void successfullyUpdateEmployee() throws IOException {
        String name = "Sandra";
        String salary = "2500";
        String age = "20";
        String employeeId = "23";

        //Update request POJO
        UpdateEmployeeRequest updateEmployee = new UpdateEmployeeRequest(name, salary, age);
        Response response;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body(updateEmployee).put("update/"+employeeId);
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
