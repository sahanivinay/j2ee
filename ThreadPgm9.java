import java.util.*;
public class ThreadPgm9 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Process1 ob1=new Process1();
		Process2 ob2=new Process2();
		ob1.start();
		Thread.sleep(5000);
		
		ob2.start();
	}

}

class Process1 extends Thread {
	public String word;
	public static String vowels="aeiou";
	public void run()
	{
		Scanner read=new Scanner(System.in);
		System.out.println("Enter word");
		word=read.next();
		int count=0;
		for(char item1: vowels.toCharArray())
		{
			for(char item2: word.toCharArray())
			{
				if(item1==item2)    count++;
			}
		}
		System.out.println("Number of vowels given word="+count);
	}
}


class Process2 extends Thread {
	public static String digits[]= {"zero","one","two","three","four","five","six","seven","eight","nine"};
	public String number;
	public void run()
	{
		Scanner read=new Scanner(System.in);
		System.out.println("Enter more then 4 digits number:");
		number=read.next();
		for(char ch: number.toCharArray() )
		{   
			int i=(int)ch-48;
			System.out.print("  "+digits[i]);
		}
	}
}


