//Write a Java program to get a number from the user and print whether it is positive or negative.
import java.util.Scanner;
public class PositiveOrNegative{
     	public static void main(String a[]){
		Scanner sc=new Scanner(System.in);
		System.out.print("enter your number:");
		int num=sc.nextInt();
				
		if(num>0){
			System.out.println("given number is positive");
		}else{
			System.out.println("given number is negative");
		}
	}
}
	
