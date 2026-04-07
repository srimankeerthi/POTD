//ArmstrongNumbersx
import java.util.Scanner;
public class Armstrong{
	public static void main(String a[]){
	int number,originalNumber,remainder,result=0,n=0;
	Scanner sc= new Scanner(System.in);
	System.out.println("enter number: ");
	number=sc.nextInt();
	originalNumber=number;
	for(;originalNumber!=0;originalNumber/=10,++n);
	originalNumber=number;
	for(;originalNumber!=0;originalNumber/=10){
	remainder=originalNumber%10;
	result+=Math.pow(remainder,n);
	System.out.println(result);
	}if(result==number)
	System.out.println(number+" is an Armstrong number ");
	else
	System.out.println(number+" is not an Armstrong number ");
	}
}

