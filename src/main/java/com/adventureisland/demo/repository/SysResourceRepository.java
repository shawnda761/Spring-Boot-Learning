package com.adventureisland.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adventureisland.demo.entity.SysResource;

@Repository
public interface SysResourceRepository extends JpaRepository<SysResource, Long> {

	List<SysResource> findByResourceCodeLike(String resourceCode);

	List<SysResource> findByResourceNameLike(String resourceName);

	List<SysResource> findByResourceTypeLike(String resourceType);

	List<SysResource> findByResourceUriLike(String resourceUri);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("delete from SysResource sr where sr.uid in (?1)")
	void deleteByIds(@Param("ids") List<Long> ids);

}
