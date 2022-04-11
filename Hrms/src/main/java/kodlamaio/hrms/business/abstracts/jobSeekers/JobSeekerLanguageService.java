package kodlamaio.hrms.business.abstracts.jobSeekers;




import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobSeekerLanguageDto;

public interface JobSeekerLanguageService {

	Result add(JobSeekerLanguageDto jobSeekerLanguageDto);
	
}
