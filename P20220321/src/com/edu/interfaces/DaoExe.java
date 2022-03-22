package com.edu.interfaces;

public class DaoExe {
	public static void main(String[] args) {
		Dao dao = new MySqlDao(); // new OracleDB();
		
		dao.select();
		
		dao.insert();
		
		dao.update();
		
		dao.delete();
	}
}
