package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.EmployersService;
import kodlamaio.hrms.core.sevices.concretes.MailVerificationManager;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.ErrorResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccsessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccsessResult;
import kodlamaio.hrms.dataAccess.abstracts.EmployersDao;
import kodlamaio.hrms.entities.concretes.Employers;


@Service
public class EmployersManager implements EmployersService {

	private EmployersDao employersDao;
	
	
	@Autowired
	public EmployersManager(EmployersDao employersDao) {
		super();
		this.employersDao = employersDao;
	}


	@Override
	public DataResult< List<Employers>> getAll() {
		
		return new SuccsessDataResult<List<Employers>>(this.employersDao.findAll(),true,"Data listelendi") ;
	}


	@Override
	public Result add(Employers employers) {
		
		if (!dataControl(employers)) {
			
			return new ErrorResult(false, "Lütfen tüm alanları doldurunuz.");
		}
		
		else if (!MailVerificationManager.checkIfEmail(employers.getEmail())) {

			return new ErrorResult(false, "Lütfen geçerli bir email adresi giriniz.");
			
		}
		
		else if (!employers.getPassword().equals(employers.getPasswordRepeat())) {
			
			return new ErrorResult(false, "Şifreler uyuşmuyor. ");
			
		}
		
		else if (this.employersDao.findByEmail(employers.getEmail())!=null) {
			
			return new ErrorResult(false, "E mail adresi zaten kullanılıyor.");
			
		}
		
		else if (!MailVerificationManager.checkEmailDomain(employers.getWeb_sites(), employers.getEmail())) {
			
			return new ErrorResult(false, "Web adresi ile email uyuşmuyor");
			
		}
		
		
		else {

			this.employersDao.save(employers);
			return new SuccsessResult("işveren başarıyla kaydedildi.");
			
		}
		
		
		
	}


	@Override
	public DataResult<Employers> getByEmail(String email) {
				return new SuccsessDataResult<Employers>(this.employersDao.findByEmail(email), true, email);
	}

	private boolean dataControl(Employers employers)
	{
		if (employers.getEmail() == null || employers.getEmail().length()==0 ||
				employers.getCompany_name()== null || employers.getCompany_name().length()==0 ||
					employers.getPhone_number() == null || employers.getPhone_number().length()==0  || 
							employers.getPassword() == null || employers.getPassword().length()==0  ||
					employers.getPassword() == null || employers.getPassword().length()==0 ||
							employers.getWeb_sites()==null ||  employers.getWeb_sites().length()==0  )
			 {
			return false;
		}
		else {
			return true;
		}
	}



}
 