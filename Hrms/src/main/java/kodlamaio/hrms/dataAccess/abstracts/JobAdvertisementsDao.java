package kodlamaio.hrms.dataAccess.abstracts;


import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.Param;

import kodlamaio.hrms.entities.concretes.JobAdvertisements;
//import kodlamaio.hrms.entities.dtos.JobAdvertisementsDto;

public interface JobAdvertisementsDao extends JpaRepository<JobAdvertisements, Integer>{
	
		@Query("From JobAdvertisements where isActive=true")
		List<JobAdvertisements> getByIsActiveTrue();

		@Query("From JobAdvertisements where isActive=true and users_id= :id")
		List<JobAdvertisements> getByIsActiveTrueAndEmployersId(@Param("id") int id);
		
		@Query("From JobAdvertisements where isActive=true Order By applicationDeadline Desc ")
		List<JobAdvertisements> getByIsActiveTrueOrderByApplicationDeadline(@Param("sort") Sort sort);
}
