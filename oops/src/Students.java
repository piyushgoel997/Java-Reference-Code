
public class Students implements compareInterface<Students> {
	
	String name;
	int marks;
	
	
	public int compareTo(Students s)
	{
		if(this.marks > s.marks)
		{
			return 1;
		}
		else if (this.marks < s.marks)
		{
			return -1;
		}
		else
			return 0;
	}
	
	

	public static void main(String[] args) {
		
	}


	
}
