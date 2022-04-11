package kodlamaio.hrms.entities.concretes;



import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="job_advertisements")
public class JobAdvertisements {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="job_advertisements_id")
	private int id;
	
	@Column(name="description")
	@NotBlank
	@NotNull
	private String description;

	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	
	
	  @Column(name="application_deadline")
	  @Temporal(TemporalType.DATE)
	  @DateTimeFormat(pattern = "dd.MM.yyyy")
	  private Date applicationDeadline;
	  
	  @Column(name="creation_date")
	  @Temporal(TemporalType.DATE)
	  @DateTimeFormat(pattern = "dd.MM.yyyy") 
	  private Date creationDate;
	 
	  
	  @Column(name="is_active")
	  private Boolean isActive;
	  
	  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinColumn(name ="users_id") 
	  private Employers employers;
	  
	  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	  @JoinColumn(name="job_positions_id") 
	  private JobPositions jobPositions;
	  
	 
      @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL) 
      @JoinColumn(name="city_id") 
	  private City city;






}
