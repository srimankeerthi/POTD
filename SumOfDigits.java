//sum of digits 
import java.util.*;
public class SumOfDigits{
	public static void main(String args[]){
	int sum=0;
	Scanner sc=new Scanner(System.in);
	System.out.print("enter the number");
	int n = sc.nextInt();
	while (n!=0){
	int last = n % 10;
	sum+=last;
	n/=10; 
	}
	System.out.print(sum);
	
	}
	}