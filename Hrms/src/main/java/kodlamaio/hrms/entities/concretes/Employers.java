package kodlamaio.hrms.entities.concretes;



import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import kodlamaio.hrms.entities.abstracts.Users;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@AllArgsConstructor
@NoArgsConstructor
@Table(name="employers")
@PrimaryKeyJoinColumn(name="id", referencedColumnName = "users_id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","jobAdvertisements"})
public class Employers extends Users  {
	
	@Column(name="email")
	@Email(message="Lütfen email formatında giriniz")
	@NotBlank
	private String email;
	
	@Column(name="password")
	private String password;
	
	@Column(name="password_repeat")
	private String passwordRepeat;

	@Column(name="company_name")
	@NotBlank
	@NotEmpty(message="Şirket adını giriniz.")
	private String company_name;
	
	@NotBlank
	@NotEmpty(message="Şirketinize ait web sitesi giriniz.")
	@Column(name="web_sites")
	private String web_sites;
	
	@NotBlank
	@NotEmpty(message="Telefon numaranızı giriniz.")
	@Column(name="phone_number")
	private String phone_number;
	
	@JsonIgnore
	@OneToMany(mappedBy = "employers", cascade = CascadeType.ALL,orphanRemoval = true)
	private List<JobAdvertisements> jobAdvertisements;

	
	

	}
