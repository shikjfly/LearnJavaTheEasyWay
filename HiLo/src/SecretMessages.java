import java.util.Scanner;

public class SecretMessages {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter a message to encode or decode: ");
		String message = scan.nextLine();
		String output = "";
//		自定义密匙
		System.out.println("Enter a secret key (-25 to 25)");
		int keyVal = Integer.parseInt(scan.nextLine());
//		char key = 13;
		char key = (char) keyVal;
		
		for (int x = 0; x < message.length(); x++) {
			char input = message.charAt(x);
//			大写加密
			if (input >= 'A' && input <='Z') {
				input += key;
				if (input > 'Z') 
					input -= 26;
				if (input < 'A')
					input += 26;				
			} 
//			小写加密
			else if (input >= 'a' && input <='z') {
				input += key;
				if (input > 'z') 
					input -= 26;
				if (input < 'a')
					input += 26;				
			}
//			数字加密
			else if (input >= '0' && input <= '9') {
				input += (keyVal%10);
				if (input > '9') 
					input -= 10;
				if (input < '0')
					input += 10;	
			}
			output += input;
		}
		
//		for(int i=message.length()-1; i>=0; i--) {
//			output += (char)(message.charAt(i) + key);
//		}
		System.out.println(output);
		scan.close();
	}

}
