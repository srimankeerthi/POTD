// multiply 2 floating numbers
import java.util.Scanner;
public class Multiply2FloatingNumbers{
 	public static void main(String a[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("enter your first number:");
		float num_1=sc.nextFloat();
		System.out.println("enter your second number:");
		float num_2=sc.nextFloat();
		float sum=num_1*num_2;
		System.out.println("this is your product:"+ sum);
		}
}