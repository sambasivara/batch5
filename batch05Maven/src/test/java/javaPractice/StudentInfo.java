package javaPractice;

public class StudentInfo {

	int rollno;
	String name;
	static String college="pvpsit";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StudentInfo s1=new StudentInfo();
		s1.studentDetains("samba",36);
		s1.display();
		
		StudentInfo s2=new StudentInfo();
		s2.college="VR";
		s2.name="siva";
		s2.rollno=26;
		//s2.studentDetains("siva",26);
		s2.display();
		
		StudentInfo s3=new StudentInfo();
		//s3.studentDetains("rao",46);
		s2.name="rao";
		s2.rollno=46;
		s3.display();
		
	}

	public void studentDetains(String n,int r) {
		rollno=r;
		name=n;
	}
	public void display() {
	 System.out.println("Student details are:");
	 System.out.println("name is:"+name);
	 System.out.println("rollno is:"+rollno);
	 System.out.println("collegename is:"+college);
	}
}
