package kodlamaio.hrms.business.concretes.jobSeekers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.jobSeekers.JobSeekerLanguageService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccsessResult;
import kodlamaio.hrms.dataAccess.abstracts.jobSeekers.JobSeekerLanguageDao;
import kodlamaio.hrms.entities.concretes.JobSeekerForeignLanguage;
import kodlamaio.hrms.entities.dtos.JobSeekerLanguageDto;

@Service
public class JobSeekerLanguageManager implements JobSeekerLanguageService {

	private JobSeekerLanguageDao jobSeekerLanguageDao;
	private DtoConverterService converterService;
	
	@Autowired
	public JobSeekerLanguageManager(JobSeekerLanguageDao jobSeekerLanguageDao, DtoConverterService converterService) {
		super();
		this.jobSeekerLanguageDao = jobSeekerLanguageDao;
		this.converterService = converterService;
	}

	@Override
	public Result add(JobSeekerLanguageDto jobSeekerLanguageDto) {
		this.jobSeekerLanguageDao.save((JobSeekerForeignLanguage)this.converterService.dtoToEntity(jobSeekerLanguageDto, JobSeekerForeignLanguage.class));
		return new SuccsessResult("Yabancı dil eklendi.");
	}
	
	
}
