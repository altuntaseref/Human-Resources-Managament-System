package kodlamaio.hrms.dataAccess.abstracts.jobSeekers;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.concretes.JobSeekerForeignLanguage;


public interface JobSeekerLanguageDao extends JpaRepository<JobSeekerForeignLanguage, Integer> {

}
