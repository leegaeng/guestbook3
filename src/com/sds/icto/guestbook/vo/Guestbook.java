package com.sds.icto.guestbook.vo;

public class Guestbook {

	private int no;
	private String name;
	private String password;
	private String message;
	private String reg_date;

	public Guestbook() {
	}

	public Guestbook(String name, String password, String message) {
		this.name = name;
		this.password = password;
		this.message = message;
	}

	public Guestbook(int no, String name, String password, String message,
			String reg_date) {
		super();
		this.no = no;
		this.name = name;
		this.password = password;
		this.message = message;
		this.reg_date = reg_date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getReg_date() {
		return reg_date;
	}

	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Guestbook [no=");
		builder.append(no);
		builder.append(", name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", message=");
		builder.append(message);
		builder.append(", reg_date=");
		builder.append(reg_date);
		builder.append("]");
		return builder.toString();
	}

}
