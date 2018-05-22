package dbs.unicorn.teamone.dbsintuit.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, name = "FULL_NAME")
	private String fullName;

	@Column(nullable = false, name = "UNDERGRAD_COLLEGE")
	private String underGradCollege;

	@Column(nullable = false, name = "UNDERGRAD_PASSYEAR")
	private Integer underGradPassingYear;

	@Column(nullable = true, name = "POSTGRAD_INSTITUTE")
	private String postGradInstitute;

	@Column(nullable = true, name = "POSTGRAD_PASSYEAR")
	private Integer postGradPassingYear;

	@Column(nullable = false, name = "HOMETOWN")
	private String hometown;

	@Column(nullable = true, name = "SKILLS")
	private String skills;

	@Column(nullable = true, name = "HOBBIES")
	private String hobbies;

	@Column(name = "DESIGNATION")
	private String designation;

	@Column(unique = true, nullable = false, name = "EMAIL_ID")
	private String emailId;

	@Column(name = "WORK_CITY")
	private String workCity;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getUnderGradCollege() {
		return underGradCollege;
	}

	public void setUnderGradCollege(String underGradCollege) {
		this.underGradCollege = underGradCollege;
	}

	public Integer getUnderGradPassingYear() {
		return underGradPassingYear;
	}

	public void setUnderGradPassingYear(Integer underGradPassingYear) {
		this.underGradPassingYear = underGradPassingYear;
	}

	public String getPostGradInstitute() {
		return postGradInstitute;
	}

	public void setPostGradInstitute(String postGradInstitute) {
		this.postGradInstitute = postGradInstitute;
	}

	public Integer getPostGradPassingYear() {
		return postGradPassingYear;
	}

	public void setPostGradPassingYear(Integer postGradPassingYear) {
		this.postGradPassingYear = postGradPassingYear;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public String getSkills() {
		return skills;
	}

	public void setSkills(String skills) {
		this.skills = skills;
	}

	public String getHobbies() {
		return hobbies;
	}

	public void setHobbies(String hobbies) {
		this.hobbies = hobbies;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getWorkCity() {
		return workCity;
	}

	public void setWorkCity(String workCity) {
		this.workCity = workCity;
	}

}
