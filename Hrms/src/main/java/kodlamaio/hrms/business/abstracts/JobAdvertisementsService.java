package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobAdvertisements;


public interface JobAdvertisementsService {
	
	Result add(JobAdvertisements jobAdvertisements);
	
	DataResult<List<JobAdvertisements>> getAll();
	
	DataResult<List<JobAdvertisements>> getByIsActive();

	DataResult<List<JobAdvertisements>>  getByIsActiveTrueAndEmployersId(int id);

	DataResult<List<JobAdvertisements>>  getByIsActiveTrueOrderByApplicationDeadlineDsc();
}
