	package ls.lesm.service.impl;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import ls.lesm.exception.EmployeeAreadyExistException;
import ls.lesm.model.Address;
import ls.lesm.model.EmployeeStatus;
import ls.lesm.model.EmployeesAtClientsDetails;
import ls.lesm.model.InternalExpenses;
import ls.lesm.model.MasterEmployeeDetails;
import ls.lesm.model.Salary;
import ls.lesm.payload.request.EmployeeDetailsRequest;
import ls.lesm.payload.response.EmpCorrespondingDetailsResponse;
import ls.lesm.payload.response.EmployeeDetailsResponse;
import ls.lesm.repository.AddressRepositoy;
import ls.lesm.repository.AddressTypeRepository;
import ls.lesm.repository.DepartmentsRepository;
import ls.lesm.repository.DesignationsRepository;
import ls.lesm.repository.EmployeesAtClientsDetailsRepository;
import ls.lesm.repository.InternalExpensesRepository;
import ls.lesm.repository.MasterEmployeeDetailsRepository;
import ls.lesm.repository.SalaryRepository;
import ls.lesm.repository.SubDepartmentsRepository;
import ls.lesm.service.EmployeeDetailsService;

@Service
public class EmployeeDetailsServiceImpl implements EmployeeDetailsService {
	
	@Autowired
	private AddressRepositoy addressRepositoy;
	
	@Autowired
	private AddressTypeRepository addressTypeRepository;
	
	@Autowired
	private MasterEmployeeDetailsRepository masterEmployeeDetailsRepository;
	
	@Autowired
	private DepartmentsRepository departmentsRepository;
	
	@Autowired
	private SubDepartmentsRepository subDepartmentsRepositorye;
	
	@Autowired
	private DesignationsRepository designationsRepository;
	
	@Autowired
	private EmployeesAtClientsDetailsRepository employeesAtClientsDetailsRepository;
	
	@Autowired
	private InternalExpensesRepository internalExpensesRepository;
	
	@Autowired
	private SalaryRepository salaryRepository;
	
		
	@Override
	public Address insertEmpAddress(Address address, Principal principal, Integer addTypeId) {
		//address.setCreatedAt(LocalDate.now());
		address.setCreatedBy(principal.getName());
		Optional<Object> optional=addressTypeRepository.findById(addTypeId).map(type->{
		address.setAdressType(type);
		return type;
		});
		return addressRepositoy.save(address);
	}

	
	public EmployeeDetailsRequest insetEmpDetails(EmployeeDetailsRequest empDetails,  Principal principal) {
		
		empDetails.getMasterEmployeeDetails().setCreatedAt(LocalDate.now());
		empDetails.getMasterEmployeeDetails().setCreatedBy(principal.getName());
		
		
		MasterEmployeeDetails employee=this.masterEmployeeDetailsRepository.save(empDetails.getMasterEmployeeDetails());
//	 MasterEmployeeDetails local= this.masterEmployeeDetailsRepository.findByLancesoft(empDetails.getMasterEmployeeDetails().getLancesoft());
//	 if(local!=null) 
//		 throw new EmployeeAreadyExistException("This lancesoft id "+local.getLancesoft()+" alreday present","1001");
//	 else
//	    empDetails.getMasterEmployeeDetails().setLancesoft(empDetails.getMasterEmployeeDetails().getLancesoft());
		empDetails.getInternalExpenses().setCreatedAt(LocalDate.now());
		empDetails.getInternalExpenses().setCreatedBy(principal.getName());
		
		empDetails.getAddress().setCreatedAt(LocalDate.now());
		empDetails.getAddress().setCreatedBy(principal.getName());
		
		empDetails.getSalary().setCreatedAt(LocalDate.now());
		empDetails.getSalary().setCreatedBy(principal.getName());
		
		this.masterEmployeeDetailsRepository.findById(employee.getEmpId()).map(id->{
			empDetails.getSalary().setMasterEmployeeDetails(id);
			return id;
		});
		
		System.out.println(employee.getEmpId()+"===============================");
		this.masterEmployeeDetailsRepository.findById(employee.getEmpId()).map(id->{
			empDetails.getAddress().setMasterEmployeeDetails(id);
			return id;
		});
		this.masterEmployeeDetailsRepository.findById(employee.getEmpId()).map(id->{
			empDetails.getInternalExpenses().setMasterEmployeeDetails(id);
			return id;
		});
		

                this.addressRepositoy.save(empDetails.getAddress());
		        this.internalExpensesRepository.save(empDetails.getInternalExpenses());	
		        this.salaryRepository.save(empDetails.getSalary());
				return empDetails;
	}

	@Override
	public EmployeesAtClientsDetails insertClientsDetails(EmployeesAtClientsDetails clientDetails,
			Principal principal) {
		clientDetails.setCreatedBy(principal.getName());
		clientDetails.setCreatedAt(LocalDate.now());
	 
		//if(clientDetails.getPOSdate().before(clientDetails.getPOEdate()))
			//throw new DateMissMatchException("Po start date can not be before po end date","408");
		
			
		return employeesAtClientsDetailsRepository.save(clientDetails);
	}

	@Override
	public Page<EmployeesAtClientsDetails> getAllEmpClinetDetails(PageRequest pageReuquest) {
		
		
		Page<EmployeesAtClientsDetails> list = employeesAtClientsDetailsRepository.findAll(pageReuquest);		
		return  list;

	}


	@Override
	public EmpCorrespondingDetailsResponse getEmpCorresDetails(EmpCorrespondingDetailsResponse corssDetails, int id) {
		Optional<InternalExpenses> data=this.internalExpensesRepository.findBymasterEmployeeDetails_Id(id);
		if(data.isPresent())
		corssDetails.setInternalExpenses(data.get());//.setBenchTenure(data.get().getBenchTenure());
		
		 Optional<EmployeesAtClientsDetails> data2=this.employeesAtClientsDetailsRepository.findBymasterEmployeeDetails_Id(id);
			if(data2.isPresent())
		 corssDetails.setEmployeesAtClientsDetails(data2.get());
			
		Optional<Salary> data3=this.salaryRepository.findBymasterEmployeeDetails_Id(id);
		if(data3.isPresent()) 
		corssDetails.setSalary(data3.get());//.setSalary(data3.get().getSalary());
		
		EmployeeDetailsResponse data4=this.masterEmployeeDetailsRepository.getEmpDetailsById(id);
		corssDetails.setEmployeeDetailsResponse(data4);
		return  corssDetails;
	}


}
