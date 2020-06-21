package com.adventureisland.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adventureisland.demo.entity.SysOperation;

@Repository
public interface SysOperationRepository extends JpaRepository<SysOperation, Long> {

	List<SysOperation> findByOperationCodeLike(String operationCode);

	List<SysOperation> findByOperationNameLike(String operationName);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("delete from SysOperation so where so.uid in (?1)")
	void deleteByIds(@Param("ids") List<Long> ids);

}
