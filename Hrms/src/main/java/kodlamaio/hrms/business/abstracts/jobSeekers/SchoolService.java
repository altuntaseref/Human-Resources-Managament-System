package kodlamaio.hrms.business.abstracts.jobSeekers;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import kodlamaio.hrms.entities.dtos.SchoolGetDto;

public interface SchoolService {
	
	Result add( SchoolDto schoolDto);
	
	DataResult<List<SchoolGetDto>> findAllByJobSeekersId(int jobseekersId);
	
	DataResult<List<SchoolGetDto>> findAllByJobSeekersIdOrderByDateGraduationDesc(int jobseekersId);
	
	Result addAll(List<School> schools);
	
	Result deleteById(int  schoolId);
	
	

}
