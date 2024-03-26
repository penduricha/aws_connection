package i_dao;



import entites.*;
import java.util.*;
public interface I_Student_DAO {
	public int addToDynamo(Student student);
	public Student get_1_StudentFromDynamoDB(String student_id);
	public long getSize_Table();
	public void addListStudent_DynamoDB();
	public boolean add_1_Student(Student s);
	public List<Student> getListFromDynamo();
	public String getListFromDynamo_ToString();
}
