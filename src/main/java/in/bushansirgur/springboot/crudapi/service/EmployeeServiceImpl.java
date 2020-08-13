package in.bushansirgur.springboot.crudapi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import in.bushansirgur.springboot.crudapi.dto.EmployeeDTO;
import in.bushansirgur.springboot.crudapi.model.Employee;
import in.bushansirgur.springboot.crudapi.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl  {

	
	@Autowired
	private EmployeeRepository employeeRepository;

	public List<EmployeeDTO> get() throws Exception{
		List<Employee> emplist = employeeRepository.findAll();
		List<EmployeeDTO> dtolist = new ArrayList<>();
		for (Employee entityObj : emplist) {

			EmployeeDTO dtoobj = new EmployeeDTO();
			dtoobj.setId(entityObj.getId());
			dtoobj.setFirstname(entityObj.getFirstname());
			dtoobj.setLasttname(entityObj.getLasttname());
			dtoobj.setDepartment(entityObj.getDepartment());
			dtoobj.setAge(entityObj.getAge());
			dtoobj.setSalary(entityObj.getSalary());
			dtoobj.setDob(entityObj.getDob());
			dtoobj.setDoj(entityObj.getDoj());
			dtolist.add(dtoobj);
		}
		return dtolist;
	}
	
	@Transactional
	public EmployeeDTO get(Integer id) throws Exception{
		
		  
		Optional<Employee> entityObjopt = employeeRepository.findById(id); 
		Employee entityObj=null;
		if (entityObjopt.isPresent()) {
			entityObj = entityObjopt.get();
		}
		  EmployeeDTO dtoobj = null; if (entityObj != null) {
		  dtoobj = new EmployeeDTO(); dtoobj.setId(entityObj.getId());
		  dtoobj.setFirstname(entityObj.getFirstname());
		  dtoobj.setLasttname(entityObj.getLasttname());
		  dtoobj.setDepartment(entityObj.getDepartment());
		  dtoobj.setAge(entityObj.getAge()); dtoobj.setSalary(entityObj.getSalary());
		  dtoobj.setDob(entityObj.getDob()); dtoobj.setDoj(entityObj.getDoj()); }
		 return dtoobj;
	}
	 
	  @Transactional
	public Integer save(EmployeeDTO employee) throws Exception{

		Employee empEntity = new Employee();
		if (employee.getId() != null) {
			empEntity.setId(employee.getId());
		}
		empEntity.setFirstname(employee.getFirstname());
		empEntity.setLasttname(employee.getLasttname());
		empEntity.setDepartment(employee.getDepartment());
		empEntity.setAge(employee.getAge());
		empEntity.setSalary(employee.getSalary());
		empEntity.setDob(employee.getDob());
		empEntity.setDoj(employee.getDoj());
		Employee returnobj=employeeRepository.save(empEntity);
		return returnobj.getId();

	}
	  
	  public Integer update(Integer empid, EmployeeDTO employee) throws Exception{

		Employee empEntity = new Employee();

		empEntity.setId(empid);
		empEntity.setFirstname(employee.getFirstname());
		empEntity.setLasttname(employee.getLasttname());
		empEntity.setDepartment(employee.getDepartment());
		empEntity.setAge(employee.getAge());
		empEntity.setSalary(employee.getSalary());
		empEntity.setDob(employee.getDob());
		empEntity.setDoj(employee.getDoj());
		 Employee entityobj= employeeRepository.save(empEntity);
    return entityobj.getId();
	}
	  
	  public void delete(Integer id) throws Exception{
	  employeeRepository.deleteById(id);
	  
	  }
	 
}
