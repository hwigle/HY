package com.project;

public class Board {

	private int bno;
	private String btitle;
	private String bcontents;
	private String bwriter;
	private String bdate;
	private int bpassword;

	public Board() {

	}

	public Board(int bno, String btitle, String bcontents, String bwriter, String bdate, int bpassword) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontents = bcontents;
		this.bwriter = bwriter;
		this.bdate = bdate;
		this.bpassword = bpassword;
	}

	public Board(int bno, String btitle, String bcontents, int bpassword) {
		this.bno = bno;
		this.btitle = btitle;
		this.bcontents = bcontents;
		this.bpassword = bpassword;
	}

	public Board(int bno, int bpassword) {
		this.bno = bno;
		this.bpassword = bpassword;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontents() {
		return bcontents;
	}

	public void setBcontents(String bcontents) {
		this.bcontents = bcontents;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBdate() {
		return bdate;
	}

	public String setBdate(String bdate) {
		return this.bdate = bdate;
	}

	public int getBpassword() {
		return bpassword;
	}

	public void setBpassword(int bpassword) {
		this.bpassword = bpassword;
	}

	@Override
	public String toString() {
		return "======================================================================================================\n"
				+ "자유게시판 " + "|" + bno + "|" + " [게시글제목: " + btitle + "] " + "[작성자 : " + bwriter + "] [작성일 : " + bdate
				+ "] \n" + "\n         " + bcontents
				+ "\n======================================================================================================\n";
	}

}
