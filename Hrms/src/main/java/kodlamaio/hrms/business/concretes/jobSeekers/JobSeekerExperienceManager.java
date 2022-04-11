package kodlamaio.hrms.business.concretes.jobSeekers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.jobSeekers.JobSeekerExperienceService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccsessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccsessResult;
import kodlamaio.hrms.dataAccess.abstracts.jobSeekers.JobSeekerExperienceDao;
import kodlamaio.hrms.entities.concretes.JobSeekerExperience;
import kodlamaio.hrms.entities.dtos.JobSeekerExperienceDto;
import kodlamaio.hrms.entities.dtos.JobSeekerExperienceGetDto;

@Service
public class JobSeekerExperienceManager implements JobSeekerExperienceService {
	
	private JobSeekerExperienceDao jobSeekerExperienceDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public JobSeekerExperienceManager(JobSeekerExperienceDao jobSeekerExperienceDao,
			DtoConverterService dtoConverterService) {
		super();
		this.jobSeekerExperienceDao = jobSeekerExperienceDao;
		this.dtoConverterService = dtoConverterService;
	}

	@Override
	public Result add(JobSeekerExperienceDto jobSeekerExperienceDto) {
		jobSeekerExperienceDao.save((JobSeekerExperience)dtoConverterService.dtoToEntity(jobSeekerExperienceDto, JobSeekerExperience.class));
		return new SuccsessResult("İş deneyimi başarıyla eklendi");
	}

	@Override
	public DataResult<List<JobSeekerExperienceGetDto>> findAllByJobSeekersId(int jobSeekersId) {
		
		return new SuccsessDataResult<List<JobSeekerExperienceGetDto>>(dtoConverterService.entityToDto(jobSeekerExperienceDao.findAllByJobSeekersId(jobSeekersId), JobSeekerExperienceGetDto.class), "Deneyimler Listelendi");
	}

	@Override
	public DataResult<List<JobSeekerExperienceGetDto>> findAllByJobSeekersIdOrderByEndDateDesc(int jobSeekersId) {
		
		return new SuccsessDataResult<List<JobSeekerExperienceGetDto>>(dtoConverterService.entityToDto(jobSeekerExperienceDao.findAllByJobSeekersIdOrderByEndDateDesc(jobSeekersId), JobSeekerExperienceGetDto.class), "Deneyimler yıllara göre zalan şekilde listelendi");
	}

	@Override
	public Result addAll(List<JobSeekerExperience> jobSeekerExperiences) {
		this.jobSeekerExperienceDao.saveAll(jobSeekerExperiences);
		return new SuccsessResult("Tüm iş deneyimleri eklendi");
	}

	@Override
	public Result deleteById(int jobSeekerExperienceId) {
		this.jobSeekerExperienceDao.deleteById(jobSeekerExperienceId);
		return new SuccsessResult("Veri silindi.");
	}
	

}
