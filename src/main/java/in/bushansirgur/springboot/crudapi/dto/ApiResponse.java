package in.bushansirgur.springboot.crudapi.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import in.bushansirgur.springboot.crudapi.model.Employee;
import lombok.Data;
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class ApiResponse {

	private Integer statusCode;
	private List<EmployeeDTO> emplist;
	private String message;
	private EmployeeDTO employeeObj;
	
}
