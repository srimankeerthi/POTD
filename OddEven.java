//oddeven
import java.util.Scanner;
public class OddEven{
	public static void main(String a[]){
		Scanner sc=new Scanner(System.in);
		System.out.println("provide a number:");
		int num=sc.nextInt();
		if (num%2==1){
		System.out.println("ODD");
		}else{
		System.out.println("EVEN");
		}
	}
}