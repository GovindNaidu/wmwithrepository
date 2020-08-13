package in.bushansirgur.springboot.crudapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import in.bushansirgur.springboot.crudapi.dto.ApiResponse;
import in.bushansirgur.springboot.crudapi.dto.EmployeeDTO;
import in.bushansirgur.springboot.crudapi.service.EmployeeServiceImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl employeeService;

	private static final org.apache.logging.log4j.Logger logger = org.apache.logging.log4j.LogManager
			.getLogger(EmployeeController.class);

	@PostMapping("/employee")
	public ResponseEntity<ApiResponse> save(@RequestBody EmployeeDTO employeeObj) {

		ApiResponse apiResponse = new ApiResponse();
		try {
			Integer empid = employeeService.save(employeeObj);
			apiResponse.setStatusCode(200);
			apiResponse.setMessage("Employee Details added successfully with Employee ID  " + empid);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

	}

	@GetMapping("/employees")
	public ResponseEntity<ApiResponse> get() {

		ApiResponse apiResponse = new ApiResponse();

		try {
			List<EmployeeDTO> emplist = employeeService.get();
			apiResponse.setStatusCode(200);
			apiResponse.setMessage("List of employees...");
			apiResponse.setEmplist(emplist);
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);
	}

	@GetMapping("/employee/{id}")
	public ResponseEntity<ApiResponse> get(@PathVariable Integer id) {
		ApiResponse apiResponse = new ApiResponse();

		try {
			EmployeeDTO employeeObj = employeeService.get(id);
			apiResponse.setStatusCode(200);
			apiResponse.setMessage("Selected Employee ID details...");
			apiResponse.setEmployeeObj(employeeObj);
			if (employeeObj == null) {
				apiResponse.setMessage("Not Exist.Selected Employee ID details Not Avilable..");

			}
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

	}

	@PutMapping("/employee/{id}")
	public ResponseEntity<ApiResponse> update(@PathVariable Integer id, @RequestBody EmployeeDTO employeeObj) {
		ApiResponse apiResponse = new ApiResponse();

		try {
			Integer idval = employeeService.update(id, employeeObj);

			apiResponse.setStatusCode(200);
			apiResponse.setMessage("Employee Id  " + idval + "  details Updated Successfully..");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}
		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

	}

	@DeleteMapping("/employee/{id}")
	public ResponseEntity<ApiResponse> delete(@PathVariable Integer id) {

		ApiResponse apiResponse = new ApiResponse();
		try {
			employeeService.delete(id);
			apiResponse.setStatusCode(200);
			apiResponse.setMessage("Employee deleted Successfully..");
		} catch (Exception e) {
			logger.info(e.getMessage());
		}

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.OK);

	}

}
