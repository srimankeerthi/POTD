//	BinaryToHexadecimal
import java.util.Scanner;
public class BinaryToHexadecimal{
	public static void main(String a[]){
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter a number:");
		String binaryInput=sc.nextLine();
		int decimalvalue=Integer.parseInt(binaryInput,2);
		String hexadecimalValue=Integer.toHexString(decimalvalue).toUpperCase();
		System.out.println("Hexadecimal number :" + hexadecimalValue);
		sc.close();
		}
}