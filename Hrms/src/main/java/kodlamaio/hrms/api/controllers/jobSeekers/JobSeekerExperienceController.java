package kodlamaio.hrms.api.controllers.jobSeekers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.jobSeekers.JobSeekerExperienceService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.dtos.JobSeekerExperienceDto;
import kodlamaio.hrms.entities.dtos.JobSeekerExperienceGetDto;

@RestController
@RequestMapping("/jobSeekerExperienceController")
public class JobSeekerExperienceController {

	private JobSeekerExperienceService jobSeekerExperienceService;

	@Autowired
	public JobSeekerExperienceController(JobSeekerExperienceService jobSeekerExperienceService) {
		super();
		this.jobSeekerExperienceService = jobSeekerExperienceService;
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody JobSeekerExperienceDto jobSeekerExperienceDto){
		Result result = jobSeekerExperienceService.add(jobSeekerExperienceDto);
		if(result.isSuccsess()) {
			
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().body(result);
		
	
	}
	
	@GetMapping("/findAllByJobSeekerId")
	public DataResult<List<JobSeekerExperienceGetDto>> findAllByJobSeekersId(int jobSeekersId){
		
		return this.findAllByJobSeekersId(jobSeekersId);
		
	}
	
	@GetMapping("/findAllByJobSeekerIdOrderByEndDataDsc")
	public DataResult<List<JobSeekerExperienceGetDto>> findAllByJobSeekersIdOrderByEndDateDesc(int jobSeekersId){
		
		return this.findAllByJobSeekersIdOrderByEndDateDesc(jobSeekersId);
	}
	
	@PostMapping("/deleteById")
	public ResponseEntity<?> deleteById(int jobSeekerExperienceId){
		
	 Result result = this.jobSeekerExperienceService.deleteById(jobSeekerExperienceId);
	 
	 if(result.isSuccsess()) {
		 
		 return ResponseEntity.ok(result);
	 }
	 
	 return ResponseEntity.badRequest().body(result);
		
	}
	
	
}
