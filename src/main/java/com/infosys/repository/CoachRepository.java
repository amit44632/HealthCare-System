package com.infosys.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Coach;

@Repository
public interface CoachRepository extends JpaRepository<Coach, Integer>{

	@Query(value = "select * from coach c where c.NAME =?1 and c.PASSWORD=?2",  nativeQuery = true)
	List<Coach> findByNameAndPassword(String name, String password);
	

}
