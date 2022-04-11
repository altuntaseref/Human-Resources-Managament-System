package kodlamaio.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.hrms.business.abstracts.SystemPersonnelService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.concretes.SystemPersonnel;

@RestController
@RequestMapping("/api/systemPersonnelController")
public class SystemPersonnelController {

	private SystemPersonnelService personnelService;

	@Autowired
	public SystemPersonnelController(SystemPersonnelService personnelService) {
		super();
		this.personnelService = personnelService;
	}
	
	@GetMapping("/getAll")
	public DataResult<List<SystemPersonnel>> getAll(){
		
		return this.personnelService.getAll();
	}
	
}
