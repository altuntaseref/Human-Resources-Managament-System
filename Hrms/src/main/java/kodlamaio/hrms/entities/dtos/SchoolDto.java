package kodlamaio.hrms.entities.dtos;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SchoolDto {

	private int id;
	
	private int jobSeekersId;

	private String schoolName;

	private String department;
	
	private boolean isGraduate;
		
	private Date entriyDate;
	
	private Date dateGraduation;
	

}
