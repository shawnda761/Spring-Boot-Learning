package com.adventureisland.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adventureisland.demo.entity.SysRole;

@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, Long> {

	List<SysRole> findByRoleCodeLike(String roleCode);

	List<SysRole> findByRoleNameLike(String roleName);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("delete from SysRole sr where sr.uid in (?1)")
	void deleteByIds(@Param("ids") List<Long> ids);

}
