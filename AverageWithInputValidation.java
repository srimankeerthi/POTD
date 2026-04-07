import java.util.Scanner;
public class AverageWithInputValidation{
	public static void main(String a[]){
	int numberIn;
	double average=0.0;
	int counter=0,sum=0;
	Scanner in=new Scanner(System.in);
	do{
	System.out.print("enter a mark between(0-100)for student: ");
	numberIn=in.nextInt();
	if((numberIn>=0 && numberIn<=100))
		{
		sum+=numberIn;
		counter++;
		}
	 else{	
		System.out.println("Invalid input,try again..");
	}
}
	while(counter!=3);
	average=sum/3;
	System.out.printf("The average is: "+average);
	}
}