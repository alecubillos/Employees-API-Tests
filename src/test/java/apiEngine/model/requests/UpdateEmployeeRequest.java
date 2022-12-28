package apiEngine.model.requests;

public class UpdateEmployeeRequest {

    public String name;
    public String salary;
    public String age;

    /**
     * No args constructor for use in serialization
     *
     */
    public UpdateEmployeeRequest() {
    }

    /**
     *
     * @param name
     * @param salary
     * @param age
     */
    public UpdateEmployeeRequest(String name, String salary, String age) {
        super();
        this.name = name;
        this.salary = salary;
        this.age = age;
    }

}
