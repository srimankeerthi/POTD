/*
String, StringBuffer, StringBuilder
-----------------------------------
String:
-------
public final class String extends Object implements Serializable, Comparable, CharSequence {
	
}

Object is super classes to all java classes, override equals(), hashCode(), toString() methods

String is a fixed length char array. Though String is a data type it is also a class unlike byte, short, int, long, float, double, boolean & char primitive data types. It is a secondary data type (arrays and classes are secondary data types). String internal representation is char array. If we store ActiveNET in String (String str="ActiveNET"), A is stored @ 0th index, c is stored @ 1 index so on like that upto T is stored in index 8 because "ActiveNET" is having 9 characters.

String is a secondary data type, predefined class. It internally represents a char array

class object creation syntax:
-----------------------------
ClassName objRef=new ClassNameAsConstructor();

String important constructors are:
-------------------------------------
public String()
public String(byte b[])
public String(byte b[], int offset, int len)
public String(char ch[])
public String(char ch[], int offset, int len)
public String(String str)
public String(StringBuffer sb)
public String(StringBuilder sb)

String class object can be created in following number of ways:
Except String class all other java class objects must be created with new operator and constructor. String class object can be created by directly assigning value to it. 

String str="ActiveNET"; 
without using new operator and constructor, by directly assigning value to variable/identifier String class object can be created. But such objects are stored in String pool. String objects created using new operator and constructor are stored in a seperate heap memory.

String str1=new String("ActiveNET"); // using String argument in constructor

String str="ActiveNET";
String str1=new String("ActiveNET");
String str2="ActiveNET";
String str3=new String("ActiveNET");

Comparing String objects using equals() method and == operator:
-------------------------------------------------------------------------
== is used to compare primitive types
.equals(Object o) is used to compare objects
== operator on objects compares their address

if(str.equals(str1)) {} // true
if(str==str1) {} // false
if(str==str2) {} // true
if(str.equals(str2)) {} // true
if(str1.equals(str3)) {} // true
if(str1==str3) {} // false

byte[] b={65,99,116,105,118,101,78,69,84};
String str2=new String(b); // using byte[] argument constructor

String str3=new String(b, 0, 6);

char ch[]={'A','c','t','i','v','e','N','E','T'};
String str3=new String(ch);  // using char[] argument constructor

String str4=new String(ch, 6, 3);

String str5=new String("ActiveNET");  // using directly passing String value/literal into constructor
*/

// StringClassDemo.java
public class StringClassDemo {
   public static void main(String rags[]) throws Exception {
		
		// all String literals are instances of String class/String objects
		// assgining String literal to String object reference
		String str="ActiveNET";

		String str1=new String(); // No Arg Constrcutor

		byte[] b={65,99,116,105,118,101,78,69,84};
		String str2=new String(b); // byte[] as an argument in constructor

		String str3=new String(b, 0, 6);

		char ch[]={'A','c','t','i','v','e','N','E','T'};
		String str4=new String(ch); // char[] as an argumnt in constructor

		String str5=new String(ch, 6, 3);

		String str6=new String("ActiveNET"); // String literal as argument in Constructor
		
        System.out.println(str.indexOf('e'));
        System.out.println(str.lastIndexOf('e'));
		
        System.out.println(str.startsWith("Act"));
        System.out.println(str.endsWith("NET"));
        System.out.println(str.charAt(5));

        System.out.println(str.replace('T','t'));
		
		System.out.println(str.length());
		System.out.println(str.isEmpty());
		
		byte b2[]=str.getBytes();
		
		// iterating over array
		// old technique
		int len=b2.length;
		for(int i=0;i<len;i++) {
			System.out.print((char)b2[i]);
		}
		System.out.println();
		
		// for-each way
		for(byte b1:b2) {
			System.out.print((char)b1);
		}
		System.out.println();
		
		char ch4[]=new char[9];
		str.getChars(0, 6, ch4, 0);
		
		// for-each way
		for(char ch1:ch4) {
			System.out.print(ch1);
		}
		System.out.println();
		
		char ch2[]=str.toCharArray();
		
		// for-each way
		for(char ch3:ch2) {
			System.out.print(ch3);
		}
		System.out.println();
		
		// codePointAt(int index) returns the index given char's unicode value
		System.out.println(str.codePointAt(5));
		
		// natual sorting
		// ActiveNET
		String str11="Activenet";
		System.out.println(str.compareTo(str11));
		if(str.compareTo(str11)==1) {
			System.out.println("ActiveNET is bigger than Activenet");
		} else if(str.compareTo(str11)==-1) {
			System.out.println("ActiveNET is smaller than Activenet");
		} else if(str.compareTo(str11)==0)  {
			System.out.println("ActiveNET is equal to Activenet");
		} else {
			System.out.println("No result");
		}
		
		System.out.println(str.concat(" Informatics Pvt Ltd"));

		String str7="Are you having IDEA Number";
		String str8=str7.substring(15, 19);
		System.out.println(str8);
	       
		System.out.println(str.toLowerCase());
		System.out.println(str.toUpperCase());
		
		String str9="  ActiveNET   ";
		System.out.println(str9.trim()); // leading/before and trailing/after spaces are removed
		
		if(str9.equalsIgnoreCase("Activenet")) {
			System.out.println("ActiveNET and Activenet are equal with ignore case");
		} else {
			System.out.println("ActiveNET and Activenet are not equal");
		}
		
		System.out.println(str.hashCode());
		
		System.out.println(str.toString());
		
		// public boolean matches(String regExpr)
		// comparing String using Regular Expression
		/* meta characters in Regular Expression
				. - any single character except new line
				\d - 0-9 digit
				\s - whitespace characters (space, tab, \n => (\r\f) )
				\w - any word character (letters, numbers, underscore)
				^ - begins with
				$ - ends with
		*/
		str="Habib";
		boolean b1=str.matches("\\d"); // false
		str="Hab12ib45";
		b1=str.matches("\\d"); // true
		b1=str.matches("[abcABC]"); // true
		str="Habib";
		b1=str.matches("b{2}"); // true
		b1=str.matches("b{2,3}"); // true
		b1=str.matches("b{2,}"); // true
		b1=str.matches("b$"); // true
		b1=str.matches("^b"); // false
   }
}
