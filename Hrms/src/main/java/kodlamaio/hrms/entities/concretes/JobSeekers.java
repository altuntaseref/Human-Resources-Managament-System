package kodlamaio.hrms.entities.concretes;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
//import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kodlamaio.hrms.entities.abstracts.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name="job_seekers")
@EqualsAndHashCode(callSuper = false)
@PrimaryKeyJoinColumn(name="id"/*, referencedColumnName = "users_id"*/)
public class JobSeekers extends Users {
	
	@Column(name="first_name")
	@NotBlank
	@NotEmpty(message="Adınızı giriniz.")
	private String firstName;
	
	@NotBlank
	@NotEmpty(message="Soyadınızı giriniz.")
	@Column(name="last_name")
	private String lastName;
	
	@NotBlank
	@NotEmpty(message="Doğum yılınızı giriniz.")
	@Column(name="date_year")
	private int dateYear;

	@NotBlank
	@NotEmpty(message="Kimlik numaranızı giriniz.")
	@Column(name="tc_no")
	private String identityNumber;

	/*
	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekers",cascade =  CascadeType.ALL,orphanRemoval = true)
	private List<JobSeekerExperience> jobSeekerExperiences;

	@JsonIgnore
	@OneToMany(mappedBy = "jobSeekers", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<JobSeekerForeignLanguage> foreignLanguages;
	*/
}

