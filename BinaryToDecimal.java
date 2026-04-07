//BinaryToDecimal
import java.util.Scanner;
class BinaryToDecimal{
 public static void main(String a[]){
	Scanner sc= new Scanner(System.in);
	System.out.print("enter a binary number:");
	String BinaryInput=sc.nextLine();
	int decimal=Integer.parseInt(BinaryInput,2);
	System.out.println(BinaryInput+"in binary="+decimal+"in decimal");
	sc.close();
	}
}