package kodlamaio.hrms.business.concretes.jobSeekers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.hrms.business.abstracts.jobSeekers.SchoolService;
import kodlamaio.hrms.core.dtoConverter.abstracts.DtoConverterService;
import kodlamaio.hrms.core.utilities.results.DataResult;
import kodlamaio.hrms.core.utilities.results.Result;
import kodlamaio.hrms.core.utilities.results.SuccsessDataResult;
import kodlamaio.hrms.core.utilities.results.SuccsessResult;
import kodlamaio.hrms.dataAccess.abstracts.jobSeekers.SchoolDao;
import kodlamaio.hrms.entities.concretes.School;
import kodlamaio.hrms.entities.dtos.SchoolDto;
import kodlamaio.hrms.entities.dtos.SchoolGetDto;

@Service
public class SchoolManager implements SchoolService {

	private SchoolDao schoolDao;
	private DtoConverterService dtoConverterService;
	
	@Autowired
	public SchoolManager(SchoolDao schoolDao, DtoConverterService dtoConverterService) {
		super();
		this.schoolDao = schoolDao;
		this.dtoConverterService = dtoConverterService;
	}


	@Override
	public Result add(SchoolDto schoolDto) {
		schoolDao.save((School)dtoConverterService.dtoToEntity(schoolDto, School.class));
		return new SuccsessResult("Eğitim bigisi eklendi");
	}

	
	@Override
	public DataResult<List<SchoolGetDto>> findAllByJobSeekersId(int jobseekersId) {
		
		return new SuccsessDataResult<List<SchoolGetDto>>(dtoConverterService.entityToDto(schoolDao.findAllByJobSeekersId(jobseekersId), SchoolGetDto.class), "Eğitimler listelendi");
	}

	@Override
	public DataResult<List<SchoolGetDto>> findAllByJobSeekersIdOrderByDateGraduationDesc(int jobseekersId) {
		
		return new SuccsessDataResult<List<SchoolGetDto>>(dtoConverterService.entityToDto(schoolDao.findAllByJobSeekersIdOrderByDateGraduationDesc(jobseekersId), SchoolGetDto.class), "Eğitimler mezuniyet yılına göre sıralanmıştır");
	}

	@Override
	public Result addAll(List<School> schools) {
		schoolDao.saveAll(schools);
		return new SuccsessResult("Eğitim bilgileri eklendi");
	}

	@Override
	public Result deleteById(int schoolId) {
		schoolDao.deleteById(schoolId);
		return new SuccsessResult("eğitim bilgisi silindi");
	}


	
	
}
