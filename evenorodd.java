import java.util.Scanner;
class evenorodd{

public static void main(String args[]){
int num;
Scanner input= new Scanner(System.in);
System.out.println("enter an integer");
num= input.nextInt();
if(num %2==0)
System.out.println("the number is even ");
else
System.out.println("the number is odd ");
}
}

