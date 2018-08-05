package ${classPackage}.domain;

import java.util.Collection;

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
@Table(name="classroom")
public class ${className} {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long id;

	public String name;
	public String roomNumber;
	public Date createdDate;

	@OneToMany(mappedBy="owner")
	@JsonIgnore
	public Collection<${domainName2}> students;
}