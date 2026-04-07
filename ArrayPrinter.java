public class ArrayPrinter{
public static void print(int[] array){
if (array == null|| array.length==0){
	System.out.println("[]");
	return;
}
System.out.print("[");
for(int i=0;i< array.length;i++){
System.out.print(array[i]);
if(i<array.length-1){
System.out.print(",");
}
}
System.out.println("]");
}
public static void main(String a[]){
	int[] array1={10,20,30,40,50};
	int[] array2={};
	int[] array3=null;
System.out.print("Array 1: ");
print(array1);
System.out.print("Array 2: ");
print(array2);
System.out.print("Array 3: ");
print(array3);
}
}