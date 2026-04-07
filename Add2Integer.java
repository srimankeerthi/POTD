import java.util.Scanner;
public class Add2Integer{
	public static void main(String a[]){
		Scanner sc= new Scanner(System.in);
		System.out.println("enter your 1st number:");
		int num_1=sc.nextInt();
		System.out.println("enter your 2nd number:");
		int num_2=sc.nextInt();
		int sum=num_1+num_2;
		System.out.println("The sum of two given numbers is:"+sum);
		sc.close();
		}
}