package com.prod;

public class Employee {
	// field.
	private int employeeId;
	private String EmployeeName;
	private String department;
	private String job;
	private int salary;

	public void setEmployeeId(int employeeID) {
		this.employeeId = employeeId;
	}

	public int getEmployeeId() {
		return this.employeeId;
	}

	public void setEmployeeName(String employeeName) {
		this.EmployeeName = employeeName;
	}

	public String getEmployeeName() {
		return this.EmployeeName;
	}

	public void setdpartment(String department) {
		this.department = department;
	}

	public String getdepartment() {
		return this.department;
	}

	public void setjob(String job) {
		this.job = job;
	}

	public String getjob() {
		return this.job;
	}

	public void setSalary(int salary) {
		if (salary < 0) {
			this.salary = 100000;
		} else {
			this.salary = salary;
		}

	}

	public int getSalary() {
		return this.salary;
	}
	public String getEmpinfo() {
		String result = this.EmployeeName + "의 부서는 " + this.department + "이고 " + "직무는 " + this.job + "이고 " + this.salary + "원 입니다.";
		return result;
	}
}
