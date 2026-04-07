//SumProductMinMax3
import java.util.Scanner;
public class SumProductMinMax3{
	public static void main(String a[]){
	 	Scanner sc=new Scanner(System.in);
		System.out.print("enter your first num:");
		int num_1=sc.nextInt();
		System.out.print("enter your second num:");
		int num_2=sc.nextInt();
                System.out.print("enter your third num:");
		int num_3=sc.nextInt();
		int sum=num_1+num_2+num_3;
		int product=num_1*num_2*num_3;
		MIN=num_1;
		if (num_2<MIN){
			MIN=num_2}
		if(num_3<MIN){
			MIN=num_3}
		MAX=num_1;
		if(num_2>MAX){
			MAX=num_2}
		if(num_3>MAX){
			MAX=num_3}
		System.out.println("The sum is"+sum);
		System.out.println("The product is"+product);
		System.out.println("The Max is"+MAX);
		System.out.println("The Min is"+MIN);
		Sc.close();
		}
}


