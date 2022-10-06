package inheritance_pack;
class college{
	static int colleId;
	char grade;
	college(){
		colleId=1;
		grade='A';
		System.out.println("***********");
	}
}
class employee extends college{
	static int rollno;
	int marks;
	employee(int r,int m){
		rollno=r;
		marks=m;
		System.out.println("employee roll no:"+r);
		System.out.println("employee marks:"+m);
		//System.out.println("Student college Id:"+colleId);
		//System.out.println("Student grade:"+grade);
		
	}
}
public class Inh_Example1 {
	static{
		System.out.println("**********Program Start***********");
	}
	{
		System.out.println("******Program Ends*********");
	}
	public static void main() {
		//college c1=new college();
		employee s1=new employee(1,65);
		//System.out.println("Static");
		}
}
