package entites;

import java.util.Objects;

public class Student {
	private String student_id;
	private String name;
	private boolean gender;
	private int age;
	public String getStudent_id() {
		return student_id;
	}
	public void setStudent_id(String student_id) {
		this.student_id = student_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String student_id, String name, boolean gender, int age) {
		super();
		this.student_id = student_id;
		this.name = name;
		this.gender = gender;
		this.age = age;
	}
	@Override
	public int hashCode() {
		return Objects.hash(student_id);
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
		return Objects.equals(student_id, other.student_id);
	}
	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", name=" + name + ", gender=" + gender + ", age=" + age + "]";
	}
	
}
