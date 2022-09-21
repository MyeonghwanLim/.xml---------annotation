package com.lim.biz.member;

public class MemberVO {
private String mid;
private String mpw;
private String name;
private String role;
public String getMid() {
	return mid;
}
public void setMid(String mid) {
	this.mid = mid;
}
public String getMpw() {
	return mpw;
}
@Override
public String toString() {
	return "MemberVo [mid=" + mid + ", mpw=" + mpw + ", name=" + name + ", role=" + role + "]";
}
public void setMpw(String mpw) {
	this.mpw = mpw;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}

}
