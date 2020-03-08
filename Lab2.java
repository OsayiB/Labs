package labs;

public class Lab2 
{

	public static void main(String[] args) 
	{
		Student stu1 = new Student("Chris", "12395678");
		Student stu2 = new Student("Walt", "82975283");
		Student stu3 = new Student("Shannon", "87493728");	
		stu1.enroll("Math151");
		stu1.enroll("Phys101");
		stu1.enroll("Hist102");
		stu1.showCourses();
		stu1.checkBalance();
		stu1.payTution(600);
		stu1.checkBalance();
		System.out.println(stu1.toString());
		

	}

}

class Student 
{
	//Properties
	private static int iD = 0;
	private String userId;
	private String name;
	private String ssn;
	private String email;
	private String phone;
	private String city;
	private String state;
	private String courses = "";
	private static final int costOfCourse = 800;
	private int balance = 0;

	public Student (String name, String ssn)
	{
		iD++;
		this.name = name;
		this.ssn = ssn;
		setUserId();
		setEmail();
	}
	
	private void setEmail()
	{
		email = name.toLowerCase() + "." + iD + "@studentuniversity.com";
		System.out.println("Your email: " + email);
	}
	public String getEmail()
	{
		return email;
	}
	
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	private void setUserId()
	{
		int max = 9000;
		int min = 1000;
		int randomNum = (int)( Math.random() * (max - min));
		randomNum = randomNum + min;
		userId = iD + "" + randomNum + ssn.substring(5);
		System.out.println("Your User ID: " + userId);
		
	}
	
	public void enroll(String course)
	{
		this.courses = this.courses + "\n" + course;
		balance = balance + costOfCourse;
		
	}
	public void payTution(int amount)
	{
		balance = balance - amount;
		System.out.println("Payment: $" + amount);
		
	}
	public void checkBalance()
	{
		System.out.println("Balance: $" + balance);
	}
	public void showCourses()
	{
		System.out.println(courses);
	}
	public String toString()
	{
		return "[Name: " + name + "]\n[Courses: " + courses + "]\nBalance: $" + balance + "]";
	}
}