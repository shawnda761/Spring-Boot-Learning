package com.adventureisland.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.adventureisland.demo.entity.SysUser;

@Repository
public interface SysUserRepository extends JpaRepository<SysUser, Long> {

	List<SysUser> findByAccountIdLike(String accountId);

	List<SysUser> findByLockFlag(Integer lockFlag);

	List<SysUser> findByAvailableFlag(Integer availableFlag);

	List<SysUser> findByNameLike(String name);

	List<SysUser> findByGender(Integer gender);

	List<SysUser> findByEmailLike(String email);

	List<SysUser> findByContactNumberLike(String contactNumber);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SysUser su set su.password = ?2 where su.uid = ?1")
	void updatePasswordById(@Param("id") Long id, @Param("password") String password);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SysUser su set su.password = ?2 where su.uid in (?1)")
	void updatePasswordByIds(@Param("ids") List<Long> ids, @Param("password") String password);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SysUser su set su.lockFlag = ?2 where su.uid = ?1")
	void updateLockFlagById(@Param("id") Long id, @Param("lockFlag") Integer lockFlag);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SysUser su set su.lockFlag = ?2 where su.uid in (?1)")
	void updateLockFlagByIds(@Param("ids") List<Long> ids, @Param("lockFlag") Integer lockFlag);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SysUser su set su.availableFlag = ?2 where su.uid = ?1")
	void updateAvailableFlagById(@Param("id") Long id, @Param("availableFlag") Integer availableFlag);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("update SysUser su set su.availableFlag = ?2 where su.uid in (?1)")
	void updateAvailableFlagByIds(@Param("ids") List<Long> ids, @Param("availableFlag") Integer availableFlag);

	@Transactional
	@Modifying(clearAutomatically = true)
	@Query("delete from SysUser su where su.uid in (?1)")
	void deleteByIds(@Param("ids") List<Long> ids);

}
