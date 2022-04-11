package kodlamaio.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlamaio.hrms.entities.abstracts.Users;

public interface UsersDao extends JpaRepository<Users, Integer>{

	List<Users> findAll();
}
