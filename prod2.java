import java.util.Scanner;
class prod2{
public static void main(String args[]){
int a;
float b;
String s;
Scanner in= new Scanner(System.in);
System.out.println("enter an integer");
a = in.nextInt();
System.out.println("you entered integer " +a);
System.out.println("enter a float");
b=in.nextFloat();
System.out.println("you entered a float " +b);
System.out.println("enter a string");
s=in.nextLine();
System.out.println("you entered a string " +s);
}
}

