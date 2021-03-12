package org.comstudy21.webapp.model;

public class SaramVo {
	private String name;
	private String age;

	public SaramVo() { }

	public SaramVo(String name, String age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

}
