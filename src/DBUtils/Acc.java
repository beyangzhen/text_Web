package com.wxhledu.cn.domain;

public class Acc {

	private int idx;
	
	private String username;
	
	private double rmb;
	
	public Acc() {
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getRmb() {
		return rmb;
	}

	public void setRmb(double rmb) {
		this.rmb = rmb;
	}

	@Override
	public String toString() {
		return "Acc [idx=" + idx + ", username=" + username + ", rmb=" + rmb + "]";
	}
	
	
}
