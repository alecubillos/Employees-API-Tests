package API_Tests;




import apiEngine.model.requests.GetEmployeeRequests;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class GetEmployees {
    @BeforeMethod
    public void setUp() {
        RestAssured.baseURI = "https://dummy.restapiexample.com/api/v1/";
    }

    @Test
    public void successfullyGetAllEmployees() throws IOException {

        GetEmployeeRequests getEmployees = new GetEmployeeRequests();
        Response response;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body(getEmployees).get("employees");
        Assert.assertEquals(200, response.statusCode());
        String jsonString = response.asString();
        List<Map<String, String>> employees = JsonPath.from(jsonString).get("data");
        String employeeName = employees.get(1).get("employee_name");
        }
    @Test
    public void GetEmployeesAgeOver30() throws IOException {
        GetEmployeeRequests getEmployees = new GetEmployeeRequests();
        Response response;
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        response = request.body(getEmployees).get("employees");
        String jsonString = response.asString();
        List<Map<String, Integer>> employees = JsonPath.from(jsonString).get("data");
        List employeesAgeOver30 = new ArrayList<>();
        for(int i=0; i< employees.size(); i++){
            if(employees.get(i).get("employee_age")>= 30){
                employeesAgeOver30.add(i);
            }
        }
        System.out.println("Total number of employees with age over 30: "+employeesAgeOver30.size());
        Assert.assertEquals(200, response.statusCode());
    }
    }




