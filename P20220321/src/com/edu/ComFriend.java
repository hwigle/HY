package com.edu;

public class ComFriend extends Friend {
	// 회사: 회사이름, 회사업무
	private String company;
	private String work;

	public ComFriend() {
	} // super();

	public ComFriend(String name, int age, double height, double weight, String phone, String company, String work) {
		super(name, age, height, weight, phone);
		this.company = company;
		this.work = work;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getWork() {
		return work;
	}

	public void setWork(String work) {
		this.work = work;
	}

	@Override
	public String toString() {		
			String str ="친구의 이름은 " + super.getName() + "이고 \n";
			str += "나이는 " + super.getAge() + "이고 \n";
			str += "연락처는 " + this.getPhone() + "입니다. \n";
			str += " =========<추가 정보>========= \n";
			str += "회사 이름은 " + this.getCompany() +"이고 \n";
			str += "직책은 " + this.getWork() + "입니다. \n";
			return str;
		}
}
