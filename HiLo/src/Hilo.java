import java.util.*;

public class Hilo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int retry;
		do {
			System.out.println("Guss a number between 1 and 100");
			Scanner scan = new Scanner(System.in);
			int theNumber = (int)(Math.random()*100+1);
			System.out.println(theNumber);
			
			int guss;
			int n=0;
			do {
				guss = scan.nextInt();
				
				if (guss>theNumber) {
					System.out.println(guss+" is too high. Try again");
				}else if (guss<theNumber) {
					System.out.println(guss+" is too low. Try again");			
				}else {
					System.out.println(guss+" is correct. You win");
				}	
				n++;
			}while(guss != theNumber);
			System.out.println("It only took you "+n+" tries! Good work!");
			System.out.println("Would you like to play again(1/0)?");
			retry = scan.nextInt();
		} while ( retry == 1);

		

		
	}

}
