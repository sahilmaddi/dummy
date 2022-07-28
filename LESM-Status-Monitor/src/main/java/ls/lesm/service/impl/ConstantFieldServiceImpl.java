package ls.lesm.service.impl;

import java.security.Principal;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ls.lesm.exception.DuplicateEntryException;
import ls.lesm.exception.RelationNotFoundExceptions;
import ls.lesm.model.AddressType;
import ls.lesm.model.Clients;
import ls.lesm.model.Departments;
import ls.lesm.model.Designations;
import ls.lesm.model.EmployeeType;
import ls.lesm.model.OnsiteExpensesType;
import ls.lesm.model.SubDepartments;
import ls.lesm.repository.AddressTypeRepository;
import ls.lesm.repository.ClientsRepository;
import ls.lesm.repository.DepartmentsRepository;
import ls.lesm.repository.DesignationsRepository;
import ls.lesm.repository.EmployeeTypeRepository;
import ls.lesm.repository.OnsiteExpensesTypeRepository;
import ls.lesm.repository.SubDepartmentsRepository;
import ls.lesm.service.ConstantFieldService;

@Service
public class ConstantFieldServiceImpl implements ConstantFieldService {

	@Autowired
	private DesignationsRepository desigRepository;
	
	@Autowired
	private DepartmentsRepository departmentsRepository;
	
	@Autowired
	private SubDepartmentsRepository subDepartmentsRepository;
	
	@Autowired
	private ClientsRepository clientsRepository;
	
	@Autowired
	private EmployeeTypeRepository employeeTypeRepository;
	
	@Autowired
	private OnsiteExpensesTypeRepository onsiteExpensesTypeRepository;
	
	@Autowired
	private AddressTypeRepository addressTypeRepository;
	

	@Override
	public Designations insertDesg(Designations desig, Principal principal) {
		desig.setCreatedBy(principal.getName());
		desig.setCreatedAt(new Date());
		
		Designations local=this.desigRepository.findByDesgNames(desig.getDesgNames());
		if(local!=null)
			throw new DuplicateEntryException("101","This Designation Already exist in database");
		else
				
		this.desigRepository.save(desig);
		return desig;
	}

	@Override
	public Departments insertDepart(Departments depart, Principal principal) {
		depart.setCreatedAt(new Date());
		depart.setCreatedBy(principal.getName());
		Departments local=this.departmentsRepository.findByDepart(depart.getDepart());
		if(local!=null)
			throw new DuplicateEntryException("102","This Department Already exist in database");
		else
			this.departmentsRepository.save(depart);
		return depart;
	}

	@Override
	public SubDepartments insertSubDepart(SubDepartments subDepart, Principal principal, int departId) {
		
		subDepart.setCreatedAt(LocalDate.now());
		subDepart.setCreatedBy(principal.getName());
		//subDepart.setDepartments(new Departments(departId,"",null,""));// assigning foreign key 
		SubDepartments local=this.subDepartmentsRepository.findBySubDepartmentNames(subDepart.getSubDepartmentNames());
		if(local!=null)
			throw new DuplicateEntryException("103","This Sub-Department Already exist in database");
		
	    this.departmentsRepository.findById(departId).map(depart->{
	    subDepart.setDepartments(depart);
	    return depart;
	    }).orElseThrow(()-> new RelationNotFoundExceptions("Department with this id "+departId+" not exist in data base","201","")); 
	    return subDepartmentsRepository.save(subDepart);
	}

	@Override
	public Clients insertClient(Clients clients, Principal principal) {
		
		clients.setCreatedAt(new Date());
		clients.setCreatedBy(principal.getName());
		Clients local=this.clientsRepository.findByClientsNames(clients.getClientsNames());
		if(local!=null)
			throw new DuplicateEntryException("104","This Client Already exist in database");
		else
			this.clientsRepository.save(clients);
		return clients;
	}

	@Override
	public EmployeeType insertEmpTypes(EmployeeType empType) {
		EmployeeType local=employeeTypeRepository.findByTypeName(empType.getTypeName());
		if(local!=null)
			throw new DuplicateEntryException("This Employee Type with this name '"+local.getTypeName()+"' Already exist in database","105");
		else
			this.employeeTypeRepository.save(empType);
		return empType;
	}

	@Override
	public OnsiteExpensesType insertExpType(OnsiteExpensesType expType, Principal principal) {
		expType.setCreatedAt(new Date());
		expType.setCreatedBy(principal.getName());
		OnsiteExpensesType local=onsiteExpensesTypeRepository.findByExpType(expType.getExpType());
		if(local!=null)
			throw new DuplicateEntryException("This Expense Type with this name '"+local.getExpType()+"' Already exist in database","106");
		else
			this.onsiteExpensesTypeRepository.save(expType);
		return expType;
	}

	@Override
	public List<SubDepartments> getAllSubDepartments() {

		List<SubDepartments> all= this.subDepartmentsRepository.findAll();
		return all;
	}

	@Override
	public List<Departments> getAllDepartments() {
		return this.departmentsRepository.findAll();
		
	}

	@Override
	public AddressType insertAddressTyp(AddressType addType) {
		AddressType local=this.addressTypeRepository.findByAddType(addType.getAddType());
		if(local!=null)
			throw new DuplicateEntryException("This Address Type with this name '"+local.getAddType()+"' Already exist in database","107");
		else
			this.addressTypeRepository.save(addType);
		return addType;
	}

	@Override
	public List<AddressType> getAllAddType() {
		
		return this.addressTypeRepository.findAll();
	}

	

	
	
	
}
