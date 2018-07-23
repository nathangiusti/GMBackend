package com.nathangiusti.gmbackend;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Record {
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(LocalDate created_dt) {
		this.createdDate = created_dt;
	}
	public String getClient() {
		return client;
	}
	public void setClient(String client) {
		this.client = client;
	}
	public String getProject() {
		return project;
	}
	public void setProject(String project) {
		this.project = project;
	}
	public String getProjectCode() {
		return projectCode;
	}
	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}
	public String getTask() {
		return task;
	}
	public void setTask(String task) {
		this.task = task;
	}
	public BigDecimal getHours() {
		return hours;
	}
	public void setHours(BigDecimal hours) {
		this.hours = hours;
	}
	public boolean isBillable() {
		return billable;
	}
	public void setBillable(boolean billable) {
		this.billable = billable;
	}
	public boolean isInvoiced() {
		return invoiced;
	}
	public void setInvoiced(boolean invoiced) {
		this.invoiced = invoiced;
	}
	public boolean isApproved() {
		return approved;
	}
	public void setApproved(boolean approved) {
		this.approved = approved;
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
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public int getBillablerate() {
		return billablerate;
	}
	public void setBillablerate(int billablerate) {
		this.billablerate = billablerate;
	}
	public int getCostRate() {
		return costRate;
	}
	public void setCostRate(int costRate) {
		this.costRate = costRate;
	}
	public int getCostAmmount() {
		return costAmmount;
	}
	public void setCostAmmount(int costAmmount) {
		this.costAmmount = costAmmount;
	}
	public String getCurrency() {
		return currency;
	}
	public void setCurrency(String currency) {
		this.currency = currency;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public BigDecimal getHoursRounded() {
		return hoursRounded;
	}
	public void setHoursRounded(BigDecimal hoursRounded) {
		this.hoursRounded = hoursRounded;
	}
	
	public boolean isEmployee() {
		return employee;
	}
	public void setEmployee(boolean employee) {
		this.employee = employee;
	}

	private int id;
	private LocalDate createdDate;
	private String client;
	private String project;
	private String projectCode;
	private String task;
	private BigDecimal hours;
	private BigDecimal hoursRounded;
	private boolean billable;
	private boolean invoiced;
	private boolean approved;
	private String firstName;
	private String lastName;
	private String department;
	private boolean employee;
	private int billablerate;
	private int costRate;
	private int costAmmount;
	private String currency;
	private String url;

}
