package kodlamaio.hrms.core.sevices.concretes;


import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import kodlamaio.hrms.core.sevices.abstracts.MailVerificationService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccsessResult;

@Service
public class MailVerificationManager implements MailVerificationService {
	
	public static boolean checkEmailDomain(String webAdress,String email) {
		
		return webAdress.contains(email.split("@")[1]);
		
	
	}
	
	public static boolean checkIfEmail(String email) {
		
		String regex="^[A-Z0-9._%+-]+@[A-Z0-9.-]+.(com|org|net|edu|gov|mil|biz|info|mobi)(.[A-Z]{2,})?$";
		Pattern pattern=Pattern.compile(regex, Pattern.CASE_INSENSITIVE );
		return pattern.matcher(email).matches();
	}

	@Override
	public Result Validate(String email) {
		
		return new SuccsessResult("Mail doğrulaması başarılı");
	}

	

		
	

}
