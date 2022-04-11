package kodlamaio.hrms.api.controllers.jobSeekers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.jobSeekers.JobSeekerLanguageService;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.dtos.JobSeekerLanguageDto;

@RestController
@RequestMapping("/api/jobSeekerLanguageController")
public class JobSeekerLanguageController {
	
	private JobSeekerLanguageService jobSeekerLanguageService;

	@Autowired
	public JobSeekerLanguageController(JobSeekerLanguageService jobSeekerLanguageService) {
		super();
		this.jobSeekerLanguageService = jobSeekerLanguageService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobSeekerLanguageDto jobSeekerLanguageDto){
		Result result = this.jobSeekerLanguageService.add(jobSeekerLanguageDto);
		
		if(result.isSuccsess()) {
			
			return ResponseEntity.ok(jobSeekerLanguageDto);
		}
		
		return ResponseEntity.badRequest().body(result);
		
	}
		
		
	
	

}
