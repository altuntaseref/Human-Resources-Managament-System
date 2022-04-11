package kodlamaio.hrms.dataAccess.abstracts.jobSeekers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerExperience;

public interface JobSeekerExperienceDao extends JpaRepository<JobSeekerExperience, Integer>{

	List<JobSeekerExperience> findAllByJobSeekersId(int jobSeekersId);
	List<JobSeekerExperience> findAllByJobSeekersIdOrderByEndDateDesc(int jobSeekersId);
	
}
