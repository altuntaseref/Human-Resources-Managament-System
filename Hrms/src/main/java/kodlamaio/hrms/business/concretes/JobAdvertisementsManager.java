package kodlamaio.hrms.business.concretes;

import java.util.List;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.JobAdvertisementsService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccsessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccsessResult;
import kodlamaio.hrms.dataAccess.abstracts.JobAdvertisementsDao;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;
//import kodlamaio.hrms.entities.dtos.JobAdvertisementsDto;

@Service
public class JobAdvertisementsManager implements JobAdvertisementsService {

	private JobAdvertisementsDao jobAdvertisementsDao;

	@Autowired
	public JobAdvertisementsManager(JobAdvertisementsDao jobAdvertisementsDao) {
		super();
		this.jobAdvertisementsDao = jobAdvertisementsDao;
	}

	@Override
	public Result add(JobAdvertisements jobAdvertisements) {
		
		this.jobAdvertisementsDao.save(jobAdvertisements);
		return new SuccsessResult("data eklendi");
		
	}

	@Override
	public DataResult<List<JobAdvertisements>> getAll() {
	
		return new SuccsessDataResult<List<JobAdvertisements>>(this.jobAdvertisementsDao.findAll(), true, "İş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByIsActive() {
		
		return new SuccsessDataResult<List<JobAdvertisements>>(this.jobAdvertisementsDao.getByIsActiveTrue(), "Aktif iş ilanları listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByIsActiveTrueAndEmployersId(int id) {
		
		return new SuccsessDataResult<List<JobAdvertisements>>(this.jobAdvertisementsDao.getByIsActiveTrueAndEmployersId(id), "İş verenlere göre iş ilanı listelendi");
	}

	@Override
	public DataResult<List<JobAdvertisements>> getByIsActiveTrueOrderByApplicationDeadlineDsc() {
		
		Sort sort = Sort.by(Sort.Direction.DESC, "applicationDeadline");
		
		return new SuccsessDataResult<List<JobAdvertisements>>(this.jobAdvertisementsDao.getByIsActiveTrueOrderByApplicationDeadline(sort), "İş ilanları son başvuru tarihine göre listelendi!");
	}

}
