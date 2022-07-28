package ls.lesm.payload.request;

import lombok.Data;
import ls.lesm.model.Address;
import ls.lesm.model.InternalExpenses;
import ls.lesm.model.MasterEmployeeDetails;
import ls.lesm.model.Salary;
@Data

public class EmployeeDetailsRequest {
	
	private MasterEmployeeDetails masterEmployeeDetails;
	private Address address;
	private InternalExpenses internalExpenses;
	private Salary salary;

}
