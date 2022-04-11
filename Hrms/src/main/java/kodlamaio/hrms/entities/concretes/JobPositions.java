package kodlamaio.hrms.entities.concretes;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="job_positions")
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobAdvertisements"})
public class JobPositions {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	@NotEmpty
	private int id;
	
	@Column(name="job_name")
	@NotEmpty
	private String jobName;

	@JsonIgnore
	@OneToMany(mappedBy = "jobPositions",cascade =  CascadeType.ALL,orphanRemoval = true)
	private List<JobAdvertisements> jobAdvertisements;

	@OneToMany(mappedBy = "jobPositions",cascade =  CascadeType.ALL,orphanRemoval = true)
	private List<JobSeekerExperience> jobSeekerExperiences;

	

	
}

