package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.ApplicationStatus;



public interface ApplicationStatusRepository extends JpaRepository<ApplicationStatus, Integer> {
	// In your repository:
	@Query(value = "SELECT * FROM (SELECT * FROM application_status ORDER BY application_id ASC) WHERE ROWNUM = 1", nativeQuery = true)
	ApplicationStatus findFirstApplication();
	
    // Oracle-native way to get latest app by email
    @Query(
        value = "SELECT * FROM (SELECT * FROM application_status WHERE email = :email ORDER BY application_id DESC) WHERE ROWNUM = 1",
        nativeQuery = true)
    ApplicationStatus findLatestByEmail(@Param("email") String email);
    
    List<ApplicationStatus> findAllByEmailIgnoreCaseOrderByApplicationIdDesc(String email);


}
