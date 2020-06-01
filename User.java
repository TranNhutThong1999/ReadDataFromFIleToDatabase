package com.thong.controller;

import java.math.BigDecimal;

public class User {
private String name;
private String maleOrFemal;
private int age;
private String address;
private BigDecimal  asset;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getMaleOrFemal() {
	return maleOrFemal;
}
public void setMaleOrFemal(String maleOrFemal) {
	this.maleOrFemal = maleOrFemal;
}
public int getAge() {
	return age;
}
public void setAge(int age) {
	this.age = age;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public BigDecimal  getAsset() {
	return asset;
}
public void setAsset(BigDecimal  asset) {
	this.asset = asset;
}
public User(String name, String maleOrFemal, int age, String address, BigDecimal  asset) {
	super();
	this.name = name;
	this.maleOrFemal = maleOrFemal;
	this.age = age;
	this.address = address;
	this.asset = asset;
}
@Override
public String toString() {
	return "User [name=" + name + ", maleOrFemal=" + maleOrFemal + ", age=" + age + ", address=" + address + ", asset="
			+ asset + "]";
}

}
