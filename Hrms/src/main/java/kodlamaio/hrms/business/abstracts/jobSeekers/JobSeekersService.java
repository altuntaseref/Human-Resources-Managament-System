package kodlamaio.hrms.business.abstracts.jobSeekers;

import java.rmi.RemoteException;
import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekers;

public interface JobSeekersService {
	
	DataResult< List<JobSeekers>>  getAll();
	
	Result add(JobSeekers jobSeekers) throws NumberFormatException, RemoteException;
	
	DataResult<JobSeekers>  getByEmail(String email);

	DataResult<List<JobSeekers>>  getByIdentityNumber(String identityNumber);
}
