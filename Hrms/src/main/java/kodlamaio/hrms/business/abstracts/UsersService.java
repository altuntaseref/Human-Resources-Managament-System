package kodlamaio.hrms.business.abstracts;

import java.util.List;

import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.entities.abstracts.Users;

public interface UsersService {

	DataResult< List<Users>>getAll();
}
