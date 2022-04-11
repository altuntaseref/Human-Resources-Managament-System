package kodlamaio.hrms.api.controllers.jobSeekers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.jobSeekers.SchoolService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;

import kodlamaio.hrms.entities.dtos.SchoolDto;
import kodlamaio.hrms.entities.dtos.SchoolGetDto;

@RestController
@RequestMapping("/SchoolController")

public class SchoolController {
	
	private SchoolService schoolService;
	
	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}


	@PostMapping("/add")
	public ResponseEntity<?> add(@RequestBody SchoolDto schoolDto){
		Result result =schoolService.add(schoolDto);
		if(result.isSuccsess()) {
			return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().body(result);
	}
		
	@GetMapping("/findAllByJobSeekersId")
	public  DataResult<List<SchoolGetDto>> findAllByJobSeekersId(int jobseekersId){
		
		return schoolService.findAllByJobSeekersId(jobseekersId);
				
	}
	
	@GetMapping("/findAllByJobSeekersIdOrderByDateGraduationDesc")
	public DataResult<List<SchoolGetDto>> findAllByJobSeekersIdOrderByDateGraduationDesc(int jobseekersId){
		
		return schoolService.findAllByJobSeekersIdOrderByDateGraduationDesc(jobseekersId);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteById(@RequestParam int schoolId){
		Result result =schoolService.deleteById(schoolId);
		if(result.isSuccsess()) {
			
		return ResponseEntity.ok(result);
		}
		
		return ResponseEntity.badRequest().body(result);
		
	}
		
	}


