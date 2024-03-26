package dao;

import java.util.*;

import com.amazonaws.services.dynamodbv2.document.spec.PutItemSpec;
import com.amazonaws.services.dynamodbv2.model.ReturnValue;

import database.AWS_Connect;
import entites.Student;
import i_dao.I_Student_DAO;

import software.amazon.awssdk.services.dynamodb.model.*;
import com.amazonaws.services.dynamodbv2.document.Item;
public class Student_DAO implements I_Student_DAO{
	//String accessKey, region, secretKey, bucketName, tableName,
	String accessKey="AKIA5FTZEKGZ4FSAM7GJ";
	String secretKey="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";
	String region="ap-southeast-1";
	String bucketName="buckettqn";
	String tableName="Student";
	
	List<Student> listStudent=new ArrayList<>();
	
	/*
	 * String accessKey, String region, String secretKey, String bucketName, String tableName)
	 */
	AWS_Connect aws_Connect=new AWS_Connect(accessKey, region, secretKey, bucketName, tableName);

	public Student_DAO() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int addToDynamo(Student student) {
		try {
            Item item = new Item().withPrimaryKey("student_id", student.getStudent_id())
                    .withString("name", student.getName())
                    .withBoolean("gender", student.isGender())
                    .withInt("age", student.getAge());
            PutItemSpec putItemSpec = new PutItemSpec().withItem(item)
                    .withReturnValues(ReturnValue.ALL_OLD); // Trả về giá trị cũ nếu có
            aws_Connect.getTable().putItem(putItemSpec);
            System.out.println("Đã thêm sinh viên " + student.getName() + " vào bảng DynamoDB");
            return 1;
        } catch (Exception e) {
            System.err.println("Lỗi khi thêm sinh viên vào bảng DynamoDB: " + e.getMessage());
            return 0;
        }
	}

	@Override
	public void addListStudent_DynamoDB() {
		// TODO Auto-generated method stub
		for (Student s: listStudent)
		{
			if(addToDynamo(s)==0)
				break;
			else
			{
				if(addToDynamo(s)==1)
				{
					System.out.println("Đã thêm: "+s.getStudent_id());
				}
			}
		}
		
	}

	@Override
	public boolean add_1_Student(Student s) {
		if(!listStudent.contains(s))
		{
			listStudent.add(s);
			return true;
		}
		return false;		
	}
	
	@Override
	public List<Student> getListFromDynamo(){
		/*
		*/
		//for(int i=0;)		
		for(long i=1;i<=getSize_Table();i++)
		{
			Student student=get_1_StudentFromDynamoDB("sv"+i);
			System.out.println(i);
			if (student != null) {
	            listStudent.add(student);
	        }
		}
        return listStudent;
	}
	

	@Override
	public String getListFromDynamo_ToString() {
		String s="";
		
		for(Student st: getListFromDynamo())
		{
			s+=st.toString()+"\n";
		}
		/*
		for(long i=1;i<=getSize();i++)
		{
			System.out.println(i);
			s+=get_1_StudentFromDynamoDB("sv"+i).toString()+"\n";
		}*/
		return s;
	}
	public int getSize()
	{
		return listStudent.size();
	}

	@Override
	public Student get_1_StudentFromDynamoDB(String student_id) {
		// TODO Auto-generated method stub
		Item item = aws_Connect.getTable().getItem("student_id", student_id);
		if (item != null) {
            String name = item.getString("name");
            boolean gender = item.getBoolean("gender");
            int age = item.getInt("age");
            return new Student(student_id, name, gender, age);
            
        } else {
            System.out.println("Không tìm thấy sinh viên ");
            return null;
        }	
	}

	@Override
	public long getSize_Table() {
		// TODO Auto-generated method stub
		return aws_Connect.getTableSize()+1;
	}
}
