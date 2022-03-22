package com.edu.api;

public class Member {
	private String id;
	private String name;

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public int hashCode() {
		return 1111;
	}

	@Override
	public boolean equals(Object obj) {
		Member member = null;
		if (obj instanceof Member) {
			member = (Member) obj;
			if (this.id == member.id && this.name == member.name) {
//				(id.equals(member.id) && id.equals(member.id)
				return true;
			}
		}
		return false;
	}

}
