package com.ssm.dao;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.ssm.entity.User;

public interface UserPagingAndSortingRepository extends PagingAndSortingRepository<User, Long> {
	
	@Query("select u from User u where name = ?1")
	List<User> queryName(String name);
	
	@Query("select u from User u where name = :name")
	List<User> queryName2(@Param("name")String name);
	
	@Query("select u from User u where name like concat('%',?1,'%')")
	List<User> queryNamelike(String name);
	
	@Query("select u from User u where name like concat('%',:name,'%')")
	List<User> queryNamelike2(@Param("name")String name);
	
	@Query(value="select * from user where name = ?1",nativeQuery=true)
	List<User> queryNameNativeQuery(String name);
	
	@Query(value="select * from user where name = :name",nativeQuery=true)
	List<User> queryNameNativeQuery2(@Param("name")String name);
	
	@Query(value="select * from user where name like concat('%',?1,'%')",nativeQuery=true)
	List<User> queryNameNativeQueryLike(String name);
	
	@Query(value="select * from user where name like concat('%',:name,'%')",nativeQuery=true)
	List<User> queryNameNativeQueryLike2(@Param("name")String name);
	
	@Query(value="select u from User u where u.name =?1")
	List<User> queryNameAndSort(String name,Sort sort);
	
	@Query(value="select u from User u where u.name =:name")
	List<User> queryNameAndSort2(@Param("name")String name,Sort sort);
	
	@Query(value="select u from User u where u.name =?1")
	List<User> queryNameAndPage(String name,Pageable pageable);
	
	@Query(value="select u from User u where u.name =:name")
	List<User> queryNameAndPage2(@Param("name")String name,Pageable pageable);
	
	@Query(value="select * from User u where u.name =?1 order by id desc",nativeQuery=true)
	List<User> queryNativeQueryNameAndSort(String name);
	
	@Query(value="select * from User u where u.name =:name order by id desc",nativeQuery=true)
	List<User> queryNativeQueryNameAndSort2(@Param("name")String name);
	
	@Query(value="select * from User u where u.name =?1 order by id desc limit ?2, ?3",nativeQuery=true)
	List<User> queryNativeQueryNameAndPage(String name,Integer start,Integer pageSize);
	
	@Query(value="select * from user u where u.name =:name order by id desc  limit :start, :pageSize",nativeQuery=true)
	List<User> queryNativeQueryNameAndPage2(@Param("name")String name,@Param("start")Integer start, @Param("pageSize")Integer pageSize);
	
	@Query(value="update user set name = ?1 where id = ?2",nativeQuery=true)
	@Modifying
	void updateNameById(String username,Integer id);
	
	@Query(value="update user set name = :username where id = :id",nativeQuery=true)
	@Modifying
	void updateNameById2(@Param("username")String username,@Param("id")Integer id);
	
}
