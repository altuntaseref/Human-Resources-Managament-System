package kodlamaio.hrms.core.sevices.concretes;

import java.rmi.RemoteException;


import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.sevices.abstracts.MernisCheckService;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccsessResult;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import tr.gov.nvi.tckimlik.WS.KPSPublicSoapProxy;

@Service
public class MernisCheckManager implements MernisCheckService{
	

	
	
	@Override
	public Result mernisCheck(JobSeekers jobSeekers) throws NumberFormatException, RemoteException {
		KPSPublicSoapProxy kpsPublicSoapProxy= new KPSPublicSoapProxy();
		
		boolean result = kpsPublicSoapProxy.TCKimlikNoDogrula(Long.parseLong(jobSeekers.getIdentityNumber()), jobSeekers.getFirstName().toUpperCase(), 
				jobSeekers.getLastName().toUpperCase(), jobSeekers.getDateYear());
		
		if(!result) {
			
			return new ErrorResult(false);
		}
		
		
	
		return new SuccsessResult(true);
		}

	

}
