package com.springboot.TrainingCenters.Entity;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="TrainingCentersData")
public class TrainingCentersEntity {	

	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name="trainingCenterId")
	    private Long id;

	    @NotEmpty(message = "Center name cannot be empty")
	    @Size(max = 40, message = "Center name cannot exceed 40 characters")
	    private String centerName;

	    @NotEmpty(message = "Center code cannot be empty")
	    @Pattern(regexp = "^[A-Za-z0-9]{5}$", message = "Center code must be 4 alphanumeric characters")
	    private String centerCode;

	    @Embedded
	    private Address address;

	    @Min(value = 1, message = "Student capacity cannot be less than 1")
	    private Integer studentCapacity;

	    @NotEmpty
	    @OneToMany(fetch = FetchType.EAGER, cascade =  CascadeType.ALL)
		@JoinColumn(name="courseId", referencedColumnName = "trainingCenterId")		
	    private List<Courses> coursesOffered;

	    @Column(updatable = false)
	    private Long createdOn = System.currentTimeMillis();

	    @Email(message = "Invalid email format")
	    private String contactEmail;

	    @NotEmpty(message = "Contact phone number cannot be empty")
	    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[\\s.-]*[0-9]{6}[\\s.-]*[0-9]{4}$", message = "Invalid phone number format")
	    private String contactPhone;

		public TrainingCentersEntity() {
			super();
			// TODO Auto-generated constructor stub
		}

		public TrainingCentersEntity(Long id,
				@NotEmpty(message = "Center name cannot be empty") @Size(max = 40, message = "Center name cannot exceed 40 characters") String centerName,
				@NotEmpty(message = "Center code cannot be empty") @Pattern(regexp = "^[A-Za-z0-9]{12}$", message = "Center code must be 12 alphanumeric characters") String centerCode,
				Address address,
				@Min(value = 1, message = "Student capacity cannot be less than 1") Integer studentCapacity,
				@NotEmpty List<Courses> coursesOffered, Long createdOn,
				@Email(message = "Invalid email format") String contactEmail,
				@NotEmpty(message = "Contact phone number cannot be empty") @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[\\s.-]*[0-9]{3}[\\s.-]*[0-9]{4}$", message = "Invalid phone number format") String contactPhone) {
			super();
			this.id = id;
			this.centerName = centerName;
			this.centerCode = centerCode;
			this.address = address;
			this.studentCapacity = studentCapacity;
			this.coursesOffered = coursesOffered;
			this.createdOn = createdOn;
			this.contactEmail = contactEmail;
			this.contactPhone = contactPhone;
		}

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getCenterName() {
			return centerName;
		}

		public void setCenterName(String centerName) {
			this.centerName = centerName;
		}

		public String getCenterCode() {
			return centerCode;
		}

		public void setCenterCode(String centerCode) {
			this.centerCode = centerCode;
		}

		public Address getAddress() {
			return address;
		}

		public void setAddress(Address address) {
			this.address = address;
		}

		public Integer getStudentCapacity() {
			return studentCapacity;
		}

		public void setStudentCapacity(Integer studentCapacity) {
			this.studentCapacity = studentCapacity;
		}

		public List<Courses> getCoursesOffered() {
			return coursesOffered;
		}

		public void setCoursesOffered(List<Courses> coursesOffered) {
			this.coursesOffered = coursesOffered;
		}

		public Long getCreatedOn() {
			return createdOn;
		}

		public void setCreatedOn(Long createdOn) {
			this.createdOn = createdOn;
		}

		public String getContactEmail() {
			return contactEmail;
		}

		public void setContactEmail(String contactEmail) {
			this.contactEmail = contactEmail;
		}

		public String getContactPhone() {
			return contactPhone;
		}

		public void setContactPhone(String contactPhone) {
			this.contactPhone = contactPhone;
		}

		@Override
		public String toString() {
			return "TrainingCentersEntity [id=" + id + ", centerName=" + centerName + ", centerCode=" + centerCode
					+ ", address=" + address + ", studentCapacity=" + studentCapacity + ", coursesOffered="
					+ coursesOffered + ", createdOn=" + createdOn + ", contactEmail=" + contactEmail + ", contactPhone="
					+ contactPhone + "]";
		}

	    	    	
}