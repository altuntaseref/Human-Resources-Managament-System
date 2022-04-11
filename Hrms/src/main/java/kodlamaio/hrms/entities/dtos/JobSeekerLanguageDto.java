package kodlamaio.hrms.entities.dtos;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class JobSeekerLanguageDto {

	private int id;
	private int jobSeekersId;
	private String language;
	private String languageLvl;
	
	
}
