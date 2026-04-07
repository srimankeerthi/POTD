import java.util.*;
public class DiceProb{
	public static void main(String a[]){
	Scanner sc = new Scanner(System.in);
	System.out.print("enter the num");
	int n = sc.nextInt();
	if(n==1)
	System.out.println("6");
	else if(n==2)
	System.out.println("5");
	else if (n==3)
	System.out.println("4");
    else if (n==4)
	System.out.println("3");
    else if (n==5)
	System.out.println("2");
    else if (n==6)
	System.out.println("1");
	else 
		System.out.print("no number available");
	}
}

	
	
	
	