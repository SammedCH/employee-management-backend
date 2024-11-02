package com.employeeManage.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employees")
public class Employee {

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "employee_id", updatable = false, nullable = false)
	    private Long employeeId;

	    
	    @Column(name = "first_name")
	    private String firstName;

	    
	    @Column(name = "last_name")
	    private String lastName;

	    
	    @Column(name = "date_of_join")
	    @Temporal(TemporalType.DATE)
	    private Date dateOfJoin;

	   
	    @Column(name = "department")
	    private String department;

	    @Column(name = "salary")
	    private Double salary;

	   
	    @Column(name = "experience")
	    private Boolean experience;

	    @Embedded
	    @AttributeOverrides({
	        @AttributeOverride(name = "permanentAddress", column = @Column(name = "permanent_address")),
	        @AttributeOverride(name = "presentAddress", column = @Column(name = "present_address"))
	    })
	    private Address address;

	    @ElementCollection
	    @CollectionTable(name = "education_details", joinColumns = @JoinColumn(name = "employee_id"))
	    private List<EducationDetails> educationDetails;

	    
	    @Pattern(regexp = "\\d{10}", message = "Contact number should be 10 digits")
	    @Column(name = "contact_no")
	    private String contactNo;

	    
	    //@Email(message = "Email ID is not valid")
	    @Email
	    @Column(name = "email_id", unique = true)
	    private String emailId;

	    @NotNull(message = "Active status is required")
	    @Column(name = "active_status")
	    private Boolean activeStatus;

		public Long getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(Long employeeId) {
			this.employeeId = employeeId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Date getDateOfJoin() {
			return dateOfJoin;
		}

		public void setDateOfJoin(Date dateOfJoin) {
			this.dateOfJoin = dateOfJoin;
		}

		public String getDepartment() {
			return department;
		}

		public void setDepartment(String department) {
			this.department = department;
		}

		public Double getSalary() {
			return salary;
		}

		public void setSalary(Double salary) {
			this.salary = salary;
		}

		public Boolean getExperience() {
			return experience;
		}

		public void setExperience(Boolean experience) {
			this.experience = experience;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public List<EducationDetails> getEducationDetails() {
			return educationDetails;
		}

		public void setEducationDetails(List<EducationDetails> educationDetails) {
			this.educationDetails = educationDetails;
		}

		public String getContactNo() {
			return contactNo;
		}

		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}

		public String getEmailId() {
			return emailId;
		}

		public void setEmailId(String emailId) {
			this.emailId = emailId;
		}

		public Boolean getActiveStatus() {
			return activeStatus;
		}

		public void setActiveStatus(Boolean activeStatus) {
			this.activeStatus = activeStatus;
		}
	    
	    
}
