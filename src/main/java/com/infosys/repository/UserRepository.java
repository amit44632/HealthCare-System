package com.infosys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entity.HCUser;
@Repository
public interface UserRepository extends JpaRepository<HCUser, Integer>{

	@Query(value = "select * from HCUSER where NAME =?1 and PASSWORD=?2",  nativeQuery = true)
	List<HCUser> findByUserNameAndPassword(String name, String password);

	
      


	

}
