public class ArrayCopy{
public static int[] copyOf(int[] original){
int [] copy=new int[original.length];
for(int i=0;i<original.length;i++)
{
copy[i]=original[i];
}
return copy;
}
public static void main(String a[]){
int [] originalArray={1,2,3,4,5};
int [] copiedArray = copyOf(originalArray);
System.out.print("original Array: ");
for(int num: originalArray)
{
System.out.print(num+" ");
}
System.out.println();
System.out.print("\nCopied Array: ");
for (int num :copiedArray){
System.out.print(num+" ");
}
}
}
