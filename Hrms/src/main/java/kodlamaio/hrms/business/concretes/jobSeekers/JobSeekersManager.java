package kodlamaio.hrms.business.concretes.jobSeekers;

import java.rmi.RemoteException;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.jobSeekers.JobSeekersService;
import kodlamaio.hrms.core.sevices.abstracts.MernisCheckService;
import kodlamaio.hrms.core.sevices.concretes.MailVerificationManager;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccsessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccsessResult;
import kodlamaio.hrms.dataAccess.abstracts.jobSeekers.JobSeekersDao;
import kodlamaio.hrms.entities.concretes.JobSeekers;

@Service
public class JobSeekersManager implements JobSeekersService{
	
	private JobSeekersDao jobSeekersDao;
	private MernisCheckService mernisCheckService;
	
	
	
	@Autowired
	public JobSeekersManager(JobSeekersDao jobSeekersDao, MernisCheckService mernisCheckService) {
		super();
		this.jobSeekersDao = jobSeekersDao;
		this.mernisCheckService = mernisCheckService;
	}

	@Override
	public DataResult<List<JobSeekers>> getAll(){
		return new SuccsessDataResult<List<JobSeekers>>(this.jobSeekersDao.findAll(),true,"Data listelendi.")  ;
	}
	

	@Override
	public Result add(JobSeekers jobSeekers) throws NumberFormatException, RemoteException {
		Result checkPerson = mernisCheckService.mernisCheck(jobSeekers);
		
		if(!dataControl(jobSeekers)) {
			
			return new ErrorResult(false, "Kayıt için lütfen tüm alanları doldurun.");
			
		}
		

		else if(!jobSeekers.getPassword().equals(jobSeekers.getPasswordRepeat())) {
			return new ErrorResult(false, "Şifreler eşleşmiyor.");
		
		}
		
		else if (!MailVerificationManager.checkIfEmail(jobSeekers.getEmail())) {

			return new ErrorResult(false, "Eposta adresiniz geçerli değildir .");
			
			
		}
		
		else if (this.jobSeekersDao.findByEmail(jobSeekers.getEmail())!=null) {
			
			return new ErrorResult(false, "Bu email adresi zaten kullanılmaktadır.");
			
		}
   /*else if (this.jobSeekersDao.findByIdentityNumber(jobSeekers.getIdentityNumber())!=null) {
			
			return new ErrorResult(false, "Bu TC kimlik numarası zaten kullanılmaktadır.");
			
		}*/
	
		
		else if(!checkPerson.isSuccsess()) {
			
			return new ErrorResult(false, "Kişi bulunamadı");
		}
		
	
		else{
			
			this.jobSeekersDao.save(jobSeekers);
		return new SuccsessResult("Kullanıcı başarıyla eklendi.");
		}
		
		
	}
	
	@Override
	public DataResult<JobSeekers> getByEmail(String email) {
		
		return new SuccsessDataResult<JobSeekers>(this.jobSeekersDao.findByEmail(email));
	}

	@Override
	public DataResult<List<JobSeekers>> getByIdentityNumber(String identityNumber) {
		
		return new SuccsessDataResult<List<JobSeekers>>((this.jobSeekersDao.findByIdentityNumber(identityNumber)), false, "id");
		//return new SuccsessDataResult<List<JobSeekers>>(this.jobSeekersDao.findByIdentityNumber(identityNumber),true,"email.");
	}
	
	private boolean dataControl(JobSeekers jobSeekers)
	{
		if (jobSeekers.getEmail() == null || jobSeekers.getEmail().length()==0 ||
			jobSeekers.getFirstName()== null || jobSeekers.getFirstName().length()==0 ||
			jobSeekers.getLastName() == null || jobSeekers.getLastName().length()==0 || 
			jobSeekers.getIdentityNumber() == null || jobSeekers.getIdentityNumber().length()==0 ||
			jobSeekers.getPassword() == null || jobSeekers.getPassword().length()==0 ||
			jobSeekers.getDateYear()  ==0)
			 {
			return false;
		}
		else {
			return true;
		}
	}

	

}















