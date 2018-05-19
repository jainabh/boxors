package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.domain.EmpDO;
import com.service.EmpService;

@RestController
public class EmpController {

	@Autowired
	private EmpService empService;

	@RequestMapping(path = "/emp", method = { RequestMethod.GET })
	@ResponseBody
	ResponseEntity<?> getEmployeeList() {
		try {
			return ResponseEntity.ok(empService.getEmpList());
		} catch (Exception e) {
		}
		return null;
	}

	@RequestMapping(path = "/emp", method = { RequestMethod.POST, RequestMethod.PUT })
	@ResponseBody
	ResponseEntity<?> saveOrUpdateEmployee(@RequestBody EmpDO EmpDO) {
		try {
			return ResponseEntity.ok(empService.saveEmp(EmpDO));
		} catch (Exception e) {
		}
		return null;
	}

	@RequestMapping(path = "/emp", method = { RequestMethod.DELETE })
	@ResponseBody
	ResponseEntity<?> deleteEmployee(@RequestBody EmpDO EmpDO) {
		try {
			empService.deleteEmp(EmpDO);
			return ResponseEntity.ok("Succesfully Deleted");
		} catch (Exception e) {
		}
		return null;
	}

	@RequestMapping(path = "/emp/{empId}", method = { RequestMethod.GET })
	@ResponseBody
	ResponseEntity<?> loadEmpById(@PathVariable("empId") String empId) {
		try {
			return ResponseEntity.ok(empService.getEmpById(empId));
		} catch (Exception e) {
		}
		return null;
	}
}
