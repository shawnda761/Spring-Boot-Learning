package com.adventureisland.demo.service;

import java.util.List;

import com.adventureisland.demo.entity.SysOperation;

public interface SysOperationService {

	public List<SysOperation> getOperations();

	public List<SysOperation> getOperationsByCode(String code);

	public List<SysOperation> getOperationsByName(String name);

	public boolean createOperation(SysOperation operation);

	public boolean updateOperation(SysOperation operation);

	public boolean removeOperation(List<Long> ids);

}
