package kodlamaio.hrms.dataAccess.abstracts.jobSeekers;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kodlamaio.hrms.entities.concretes.JobSeekers;

@Repository
public interface JobSeekersDao extends JpaRepository<JobSeekers, Integer> {
	
	//List<JobSeekers> findAll();
	
	JobSeekers findByEmail(String email);
	List<JobSeekers> findByIdentityNumber(String identityNumber);

}
