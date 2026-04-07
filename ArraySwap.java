public class ArraySwap{
public static Boolean swap(int[]array1,int[] array2){
if (array1.length!=array2.length)
{
	return false;
}
for (int i=0;i<array1.length;i++){
	int temp=array1[i];
	array1[i]=array2[i];
	array2[i]=temp;
	}
	return true;
	}
public static void main(String a[]){
	int[] array1={1,2,3};
	int[] array2={4,5,6};
	boolean swapped=swap(array1,array2);
	System.out.println("\n\nAfter swapping:");
if (swapped){
System.out.print("Array 1: ");
for(int num:array1){
System.out.print(num + " ");
}
System.out.print("\nArray 2: ");
for(int num :array2){
System.out.print(num+" ");
}
}
else{
System.out.println("Swap not possible.");
}
}
}

