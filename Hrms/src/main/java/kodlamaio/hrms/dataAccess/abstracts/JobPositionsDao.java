package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobPositions;

public interface JobPositionsDao extends JpaRepository<JobPositions, Integer> {
	
	List<JobPositions> findAll();
	List<JobPositions> findByJobName(String jobName);
	JobPositions getByJobName(String jobName);
}
