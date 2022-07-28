package ls.lesm.service;

import java.security.Principal;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import ls.lesm.model.Address;
import ls.lesm.model.EmployeesAtClientsDetails;
import ls.lesm.payload.request.EmployeeDetailsRequest;
import ls.lesm.payload.response.EmpCorrespondingDetailsResponse;

public interface EmployeeDetailsService {
	
	Address insertEmpAddress(Address address, Principal principal, Integer addTypeId);
	
	EmployeeDetailsRequest insetEmpDetails(EmployeeDetailsRequest empReq, Principal principal );
	
	EmployeesAtClientsDetails insertClientsDetails(EmployeesAtClientsDetails clientDetails, Principal principal);

	Page<EmployeesAtClientsDetails> getAllEmpClinetDetails(PageRequest pageReuquest);
	
	EmpCorrespondingDetailsResponse getEmpCorresDetails(EmpCorrespondingDetailsResponse corssDetailsint,int id);
	
	

	
}
