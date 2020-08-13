package in.bushansirgur.springboot.crudapi.service;

import java.util.List;

import in.bushansirgur.springboot.crudapi.dto.EmployeeDTO;
import in.bushansirgur.springboot.crudapi.model.Employee;

public interface EmployeeService {
	
	
	  List<EmployeeDTO> get() throws Exception;
	  
	  EmployeeDTO get(Integer id) throws Exception;
	  
	  Integer save(EmployeeDTO employee) throws Exception;
	   void update(Integer empid,EmployeeDTO employee) throws Exception; 
	   void delete(Integer id) throws Exception;
	 
}
