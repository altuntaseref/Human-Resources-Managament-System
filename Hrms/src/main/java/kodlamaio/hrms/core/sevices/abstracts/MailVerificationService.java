package kodlamaio.hrms.core.sevices.abstracts;

import kodlamaio.hrms.core.utilities.results.Result;


public interface MailVerificationService { 
	
	Result Validate(String email);
	
	
	
	
}
	