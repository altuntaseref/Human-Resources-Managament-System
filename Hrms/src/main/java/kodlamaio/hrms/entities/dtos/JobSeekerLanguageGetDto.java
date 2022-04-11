package kodlamaio.hrms.entities.dtos;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class JobSeekerLanguageGetDto {
	
	private int id;
	private int jobSeekersId;
	private String language;
	private String languageLvl;
	

}