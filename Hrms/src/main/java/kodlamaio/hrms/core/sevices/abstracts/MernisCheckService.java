package kodlamaio.hrms.core.sevices.abstracts;

import java.rmi.RemoteException;

import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobSeekers;

public interface MernisCheckService {

	Result mernisCheck(JobSeekers jobSeekers) throws NumberFormatException, RemoteException;
	}
