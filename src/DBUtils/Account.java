package com.wxhledu.cn.domain;

/**
 * javabean ：
 * @author wxhl
 *
 */
public class Account {

	/**
	 * 编号
	 */
	private int id;

	/**
	 * 名称
	 */
	private String name;

	/**
	 * 钱
	 */
	private double money;

	public Account() {
	}
	
	

	public Account(int id, String name, double money) {
		super();
		this.id = id;
		this.name = name;
		this.money = money;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", name=" + name + ", money=" + money + "]";
	}

}
