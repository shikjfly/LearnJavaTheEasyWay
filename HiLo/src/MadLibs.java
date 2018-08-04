import java.util.Scanner;

public class MadLibs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a color: ");
		String color = scan.next();
		System.out.println("Enter a pastTenseVerb: ");
		String pastTenseVerb = scan.next();
		System.out.println("Enter a adjective: ");
		String adjective = scan.next();
		System.out.println("Enter a noun: ");
		String noun = scan.next();
		
		System.out.print("The " +color+ " dragon " +pastTenseVerb+ " at the " +adjective);
		System.out.println(" knight, who rode in on a study, giant "+ noun + " .");
		scan.close();
	}

}
