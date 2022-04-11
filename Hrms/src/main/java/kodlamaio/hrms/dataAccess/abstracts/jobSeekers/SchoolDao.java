package kodlamaio.hrms.dataAccess.abstracts.jobSeekers;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import kodlamaio.hrms.entities.concretes.School;


public interface SchoolDao extends JpaRepository<School, Integer> {
	
	/*@Query("From SchoolDto where Order By dateGraduation Desc")
    List<SchoolDto> getByOrderByDateGraduationDesc(@Param("sort") Sort sort);*/

	List<School> findAllByJobSeekersId(int jobseekersId);
	List<School> findAllByJobSeekersIdOrderByDateGraduationDesc(int jobseekersId);
}
