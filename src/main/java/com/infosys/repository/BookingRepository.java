package com.infosys.repository;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.infosys.entity.Booking;
@Repository
public interface BookingRepository extends JpaRepository<Booking, Integer>{

	@Query(value = "select * from BOOKING where COACH_ID=?1",  nativeQuery = true)
	Optional<Booking> findByCoachId(Integer id);

	@Query(value = "select * from BOOKING where USER_ID=?1",  nativeQuery = true)
	List<Booking> findByUserId(Integer id);

	@Modifying
	@Query(value = "Select * from BOOKING  b where b.USER_ID=?1 and b.COACH_ID=?2",  nativeQuery = true)
	List<Booking> deleteByUserIdAndCoachId(String user_id, String coach_id);

	
	
}
