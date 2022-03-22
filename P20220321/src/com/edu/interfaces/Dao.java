package com.edu.interfaces;

public interface Dao extends RemoteControl, Run {
	
	public abstract void select();
//	public void select();
	public void insert();
	public void update();
	public void delete();
}
