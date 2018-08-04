import java.util.Scanner;

public class HiLo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);		
		String playAgain = "";
		do {
//			生成要让用户去猜的随机数
			int theNumber = (int)(Math.random()*100+1);
			System.out.println(theNumber);
			int guess = 0;
			int numberOftries = 0;
			while (guess != theNumber) {
				numberOftries++;
				System.out.println("Guess a number between 1 and 100: ");
				guess = scan.nextInt();
//				System.out.println("You entered " + guess + " .");
				if (guess > theNumber) {
					System.out.println(guess + " is too high, Try again");
				}else if(guess < theNumber){
					System.out.println(guess + " is too low, Try again");
				}else {
					System.out.println(guess + " is correct. You win!");
					System.out.println("It only took you "+ numberOftries +" Tries! Good work!" );
				}
			} // 让用户不断去猜的while循环结束
			System.out.println("Would you like to play again(y/n)?");
			playAgain = scan.next();
		} while (playAgain.equalsIgnoreCase("y"));
		System.out.println("Thank you for playing! Goodbye.");
		scan.close();
	}

}
