//AmicableNumbers
import java.util.Scanner;
public class AmicableNumbers{
	public static void main(String a[]){
	int firstDivisorSum=0,SecondDivisorSum=0,firstNumber,SecondNumber;
	Scanner sc=new Scanner(System.in);
	System.out.print("enter the firstNumber: ");
	firstNumber=sc.nextInt();
	System.out.print("Enter the secondNumber: ");
	SecondNumber=sc.nextInt();
	for(int i=1;i<firstNumber;i++){
	if(firstNumber %i==0){
	firstDivisorSum=firstDivisorSum+i;
	}
	}
	for(int i=1;i<SecondNumber;i++){
	if(SecondNumber%i==0){
	SecondDivisorSum=SecondDivisorSum+i;
	}
}
if((firstNumber==SecondDivisorSum)&&(SecondNumber==firstDivisorSum))
{
System.out.println(firstNumber+","+SecondNumber+"are amicable numbers ");
}
else{
System.out.println(firstNumber+","+SecondNumber+"are not amicable numbers");
}
}
}