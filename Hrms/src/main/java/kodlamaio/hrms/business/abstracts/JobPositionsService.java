package kodlamaio.hrms.business.abstracts;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.entities.concretes.JobPositions;
import java.util.List;
public interface JobPositionsService {
	
	DataResult<List<JobPositions>> getAll( );
	
	Result add(JobPositions jobPositions);
	
	DataResult<JobPositions> getByJobName(String jobName);

}
