package com.hxz.stu.bean;

/**
 * @author 
 */
public class Student {
	/**  ����  **/
	private Integer id;
	private String name;
	private String gender;
	private int age;
	private Integer score;

	/**  ���췽�� **/
	
	public Student() {}

	public Student(Integer id, String name, String gender, Integer age, Integer score) {
		this.id = id;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.score = score;
	}
	
	/** setters & getters **/

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
