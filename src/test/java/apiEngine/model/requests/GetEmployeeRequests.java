package apiEngine.model.requests;

import java.util.List;

public class GetEmployeeRequests {

    public String status;
    public List<Datum> data = null;
    public String message;

    /**
     * No args constructor for use in serialization
     *
     */
    public GetEmployeeRequests() {
    }

    /**
     *
     * @param data
     * @param message
     * @param status
     */
    public GetEmployeeRequests(String status, List<Datum> data, String message) {
        super();
        this.status = status;
        this.data = data;
        this.message = message;
    }

}
