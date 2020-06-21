package com.adventureisland.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adventureisland.demo.entity.SysOperation;
import com.adventureisland.demo.repository.SysOperationRepository;
import com.adventureisland.demo.service.SysOperationService;
import com.adventureisland.demo.util.ConstantUtil;

@Service
public class SysOperationServiceImpl implements SysOperationService {

	@Autowired
	SysOperationRepository operationRepo;

	@Override
	public List<SysOperation> getOperations() {
		return operationRepo.findAll();
	}

	@Override
	public List<SysOperation> getOperationsByCode(String code) {
		return operationRepo.findByOperationCodeLike(ConstantUtil.wrapperOfLike(code));
	}

	@Override
	public List<SysOperation> getOperationsByName(String name) {
		return operationRepo.findByOperationNameLike(ConstantUtil.wrapperOfLike(name));
	}

	@Override
	public boolean createOperation(SysOperation operation) {
		operationRepo.saveAndFlush(operation);
		return true;
	}

	@Override
	public boolean updateOperation(SysOperation operation) {
		operationRepo.saveAndFlush(operation);
		return true;
	}

	@Override
	public boolean removeOperation(List<Long> ids) {
		if (ids.size() == 1) {
			operationRepo.deleteById(ids.get(0));
		} else {
			operationRepo.deleteByIds(ids);
		}
		return true;
	}

}
