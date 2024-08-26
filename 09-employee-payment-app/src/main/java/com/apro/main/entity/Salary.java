package com.apro.main.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="salary")
public class Salary {
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	long salaryld;
	@Column
	int salaryMonth;
	@Column
	double grossSalary;
	@Column
	double deductions;
	@Column
	double netSalary;
	@Column
	LocalDate paymentDate;
	@Column
	SalaryStatus salaryStatus;
	

}
