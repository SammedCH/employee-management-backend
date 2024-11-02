package com.employeeManage.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.*;
import lombok.*;

@Embeddable
public class EducationDetails {

    @NotBlank(message = "Qualification is required")
    @Column(name = "qualification")
    private String qualification;

    @NotBlank(message = "University/College is required")
    @Column(name = "university_college")
    private String universityCollege;

    @NotNull(message = "Percentage is required")
    @Column(name = "percentage")
    private Double percentage;

    @NotNull(message = "Completion year is required")
    @Column(name = "completion_year")
    private Integer completionYear;

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getUniversityCollege() {
		return universityCollege;
	}

	public void setUniversityCollege(String universityCollege) {
		this.universityCollege = universityCollege;
	}

	public Double getPercentage() {
		return percentage;
	}

	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}

	public Integer getCompletionYear() {
		return completionYear;
	}

	public void setCompletionYear(Integer completionYear) {
		this.completionYear = completionYear;
	}
    
    
}