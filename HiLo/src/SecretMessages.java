import java.util.Scanner;

public class SecretMessages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a message to encode or decode: ");
		String message = scan.nextLine();
		String output = "";
		char key = 13;
		for(int i=message.length()-1; i>=0; i--) {
			output += (char)(message.charAt(i) + key);
		}
		System.out.println(output);
		scan.close();
	}

}
