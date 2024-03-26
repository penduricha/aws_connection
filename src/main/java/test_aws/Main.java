package test_aws;

import entites.*;
import dao.*;
public class Main {

	public static void main(String[] args) {
		Student_DAO student_DAO=new Student_DAO();
		// TODO Auto-generated method stub
		/*
		Student student1=new Student("sv3", "Ben",true, 20);
		Student student2=new Student("sv4", "Paul",true, 20);
		Student student3=new Student("sv5", "Mari",false, 20);
		Student student4=new Student("sv6", "Lick",false, 20);
		
		Student_DAO student_DAO=new Student_DAO();
		student_DAO.add_1_Student(student1);
		student_DAO.add_1_Student(student2);
		student_DAO.add_1_Student(student3);
		student_DAO.add_1_Student(student4);
		//Thêm vào dynamodb
		student_DAO.addListStudent_DynamoDB();*/
		System.out.println(student_DAO.getSize());
		System.out.println(student_DAO.getListFromDynamo_ToString());
		System.out.println(student_DAO.get_1_StudentFromDynamoDB("sv2").toString());
		System.out.println(student_DAO.get_1_StudentFromDynamoDB("sv3").toString());
		System.out.println("Size table: "+student_DAO.getSize_Table());
	}

}
