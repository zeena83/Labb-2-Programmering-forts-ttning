
import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		
		Model m = new Model();
		
		Scanner s = new Scanner(System.in);
		
		System.out.println("Add a positive number, -1 to clear or -2 to quit");
		
		int input = 0;
		
		
		
		while(input != -2){
		
		input = s.nextInt();
		
		if(input == -1){
			m.clearMemory();
			System.out.println("Memory cleared");
		}
			else if(input == -2){
			m.clearMemory();
			System.out.println("Memory cleared");
			System.out.println("Program quits");
		}
		else if(input >= 0){
			System.out.println("2^n = " + m.compute2Power(input));
		}
		else{
			try{
				System.out.println("Invalid input");
			}catch(IllegalArgumentException e){
			}
		
		}		
	}
		System.exit(0);
	}
}

