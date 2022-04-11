package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobPositionsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccsessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccsessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobPositionsDao;
import kodlamaio.hrms.entities.concretes.JobPositions;

@Service
public class JobPositionsManager implements JobPositionsService{
	
	private JobPositionsDao jobPositionsDao;
	

	public JobPositionsManager(JobPositionsDao jobPositionsDao) {
		super();
		this.jobPositionsDao = jobPositionsDao;
	}


	@Override
	public Result add(JobPositions jobPositions) {
		if(this.jobPositionsDao.findByJobName(jobPositions.getJobName())!=null) {
			
			return new ErrorResult(false, "Bu iş pozisyou daha önce sisteme tanımlanmıştır.");
			
		}
		this.jobPositionsDao.save(jobPositions);
		return new SuccsessResult("İş pozisyonu başarıyla eklendi");
	}


	@Override
	public DataResult<JobPositions> getByJobName(String jobName) {
		
		return new SuccsessDataResult<JobPositions>(this.jobPositionsDao.getByJobName(jobName), "İş pozisyonu bulundu!");
	}


	@Override
	public DataResult<List<JobPositions>> getAll() {
		//this.jobPositionsDao.findAll();
		return new SuccsessDataResult<List<JobPositions>>(this.jobPositionsDao.findAll(), true, "İş pozisyonları listelendi");
	}

}
