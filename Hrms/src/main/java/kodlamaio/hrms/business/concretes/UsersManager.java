package kodlamaio.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.UsersService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.SuccsessDataResult;
import kodlamaio.hrms.dataAccess.abstracts.UsersDao;
import kodlamaio.hrms.entities.abstracts.Users;

@Service
public class UsersManager implements UsersService{

	private UsersDao usersDao;
	
	
	@Autowired
	public UsersManager(UsersDao usersDao) {
		super();
		this.usersDao = usersDao;
	}


	@Override
	public DataResult< List<Users>>getAll() {
		return new SuccsessDataResult<List<Users>>(this.usersDao.findAll(),true,"Data listelendi.") ;
	}

	
	




	

}
