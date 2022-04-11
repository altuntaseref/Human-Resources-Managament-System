package kodlamaio.hrms.business.abstracts.jobSeekers;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekerExperience;
import kodlamaio.hrms.entities.dtos.JobSeekerExperienceDto;
import kodlamaio.hrms.entities.dtos.JobSeekerExperienceGetDto;

public interface JobSeekerExperienceService {
	
	Result add(JobSeekerExperienceDto jobSeekerExperienceDto );
	
	DataResult<List<JobSeekerExperienceGetDto>> findAllByJobSeekersId(int jobSeekersId);
	
	DataResult<List<JobSeekerExperienceGetDto>> findAllByJobSeekersIdOrderByEndDateDesc(int jobSeekersId);
	
	Result addAll(List<JobSeekerExperience> jobSeekerExperiences);
	
	Result deleteById(int jobSeekerExperienceId);
	
	

}
