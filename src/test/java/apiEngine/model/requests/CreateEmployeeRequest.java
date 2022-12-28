package apiEngine.model.requests;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;

import java.util.Map;

public class CreateEmployeeRequest {

    public String name;
    public String salary;
    public String age;

    /**
     * No args constructor for use in serialization
     *
     */
    public CreateEmployeeRequest() {
    }

    /**
     *
     * @param name
     * @param salary
     * @param age
     */
    public CreateEmployeeRequest(String name, String salary, String age) {
        super();
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

    public Integer CreateEmployee(){
        CreateEmployeeRequest createEmployee = new CreateEmployeeRequest(this.name, this.salary, this.age);
        Response response;
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body(createEmployee).post("create");
        Assert.assertEquals(200, response.statusCode());
        String jsonString = response.asString();
        Map<String, Integer> employee = JsonPath.from(jsonString).get("data");
        Integer employeeId = employee.get("id");
        return employeeId;
    }

}
