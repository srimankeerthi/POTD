import java.util.Scanner;
public class boxpattern{
	public static void main(String a[]){
	int i;
	int j;
	Scanner sc=new Scanner(System.in);
	System.out.print("enter no of rows:");
	int num=sc.nextInt();
	for(i=1;i<=num;i++){
	   for(j=1;j<=num;j++){
		System.out.print(" #");
		}
	System.out.println();
	}
	}
}
	
	
	