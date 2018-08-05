package ${classPackage}.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="student")
public class ${className} {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;

	public String firstName;
	public String lastName;
	public String grade;
	public Date enrolledDate;

	@ManyToOne
	@JsonIgnore
	public ${domainName1} owner;
}