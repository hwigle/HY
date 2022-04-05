package com.work;

public class Reply {
	private int rno;

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	private String rcontents;
	private String rwriter;

	public Reply() {

	}

	public Reply(int rno, String rcontents, String rwriter) {
		super();
		this.rno = rno;
		this.rcontents = rcontents;
		this.rwriter = rwriter;

	}

	public String getRcontents() {
		return rcontents;
	}

	public void setRcontents(String rcontents) {
		this.rcontents = rcontents;
	}

	public String getRwriter() {
		return rwriter;
	}

	public void setRwriter(String rwriter) {
		this.rwriter = rwriter;
	}

	@Override
	public String toString() {
		return "Reply [rno=" + rno + ", rcontents=" + rcontents + ", rwriter=" + rwriter + "]";
	}

	

}
