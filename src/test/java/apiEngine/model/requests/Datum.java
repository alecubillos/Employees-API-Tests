package apiEngine.model.requests;

public class Datum {

    public Integer id;
    public String employeeName;
    public Integer employeeSalary;
    public Integer employeeAge;
    public String profileImage;

    /**
     * No args constructor for use in serialization
     *
     */
    public Datum() {
    }

    /**
     *
     * @param employeeName
     * @param employeeAge
     * @param id
     * @param profileImage
     * @param employeeSalary
     */
    public Datum(Integer id, String employeeName, Integer employeeSalary, Integer employeeAge, String profileImage) {
        super();
        this.id = id;
        this.employeeName = employeeName;
        this.employeeSalary = employeeSalary;
        this.employeeAge = employeeAge;
        this.profileImage = profileImage;
    }

}