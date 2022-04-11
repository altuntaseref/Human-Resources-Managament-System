package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import kodlamaio.hrms.entities.concretes.JobPositions;
import kodlamaio.hrms.entities.concretes.JobSeekers;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerExperienceGetDto {
	
    private int id;
	
	private String businessName;
	
	private int  jobPositionsId;
	
	private int jobSeekersId;
	
	private Date entryDate;
	
	private Date endDate;

}
