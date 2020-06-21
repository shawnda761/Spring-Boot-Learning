package com.adventureisland.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adventureisland.demo.entity.SysOperation;
import com.adventureisland.demo.service.SysOperationService;

@RestController
@RequestMapping("/manage/operation")
public class SysOperationController {

	@Autowired
	SysOperationService operationService;

	@GetMapping("/get/{method}")
	public List<SysOperation> getAllOperations(@PathVariable("method") String method,
			@RequestBody(required = false) Object parameter) {
		if (method.equals("all")) {
			return operationService.getOperations();
		} else if (method.equals("code")) {
			return operationService.getOperationsByCode(parameter.toString());
		} else if (method.equals("name")) {
			return operationService.getOperationsByName(parameter.toString());
		}
		return null;
	}

	@PostMapping("/add")
	public void addOperation(@RequestBody SysOperation operation) {
		operationService.createOperation(operation);
	}

	@PutMapping("/update")
	public void updateOperation(@RequestBody SysOperation operation) {
		operationService.updateOperation(operation);
	}

	@DeleteMapping("/delete")
	public void deleteOperation(@RequestBody List<Long> ids) {
		operationService.removeOperation(ids);
	}

}
