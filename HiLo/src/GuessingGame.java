import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GuessingGame extends JFrame {
	private JTextField txtGuess;
	private JLabel lblOutput;
	private int theNumber;
	private int numberOfTries;
	private JLabel lblTheNumber;
	private JButton btnGuess;
	private JButton btnPlayAgain;
//	�ڵ�һ�������Ķ������棬��������������ֵķ���
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
//			ÿ����һ��checkGuess���������ּ�һ��
			numberOfTries++;
			int guess = Integer.parseInt(guessText);
			if (guess > theNumber) {
				message = (guess + " is too high, Try again");
			}else if(guess < theNumber){
				message = (guess + " is too low, Try again");
			}else {
				message = (guess + " is correct. You win after " +numberOfTries+" Tries!");
//				 ���������һ�飬�ٴ�����һ������
				btnPlayAgain.setVisible(true);
				btnGuess.setVisible(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			message = "Enter a whole number between 1 and 100.";
		}finally {
//			ÿ��һ�Σ��ͰѲ²�Ľ�������lblOutput����
			lblOutput.setText(message);
//			Ȼ���ٻ�ȡ����
			txtGuess.requestFocus();
//			����Ҫȫѡ��������һ�β���
			txtGuess.selectAll();
//			��ʾ����²�����֣�������ΪsetText��ҪString���ͣ�����int������Ҫת��
			lblTheNumber.setText(String.valueOf(theNumber));
		}//end finally
	}//end checkGuess()
		
//	��Ϸ��ʼ����Ҫ�и��������
	public void newGame() {
		btnGuess.setVisible(true);
		btnPlayAgain.setVisible(false);
		theNumber = (int)(Math.random()*100+1);
		numberOfTries=0;
	}
//	��һ�����������������
	public  GuessingGame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Xzhao's Hi-Lo Guessing Game");
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Xzhao's Hi-Lo Guessing Game");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 31, 414, 28);
		getContentPane().add(lblNewLabel);
		
		JLabel lblGuessingANumber = new JLabel("Guessing a number between 1 and 100: ");
		lblGuessingANumber.setBounds(70, 90, 236, 28);
		getContentPane().add(lblGuessingANumber);
		
		txtGuess = new JTextField();
//		txtGuess�ı���������Enter�س�֮�����ύ�²�
		txtGuess.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				checkGuess();
			}
		});
		txtGuess.setHorizontalAlignment(SwingConstants.LEFT);
		txtGuess.setBounds(302, 91, 66, 28);
		getContentPane().add(txtGuess);
		txtGuess.setColumns(10);
		
		btnGuess = new JButton("Guess!");
//		btnGuess��ť�����ύ�Ĳ���
		btnGuess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				checkGuess();
			}
		});
		btnGuess.setBounds(166, 149, 93, 23);
		getContentPane().add(btnGuess);
		
		lblOutput = new JLabel("Enter a number above, and click Guess!");
		lblOutput.setHorizontalAlignment(SwingConstants.CENTER);
		lblOutput.setBounds(10, 182, 414, 28);
		getContentPane().add(lblOutput);
		
		lblTheNumber = new JLabel("theNumber is :");
		lblTheNumber.setHorizontalAlignment(SwingConstants.CENTER);
		lblTheNumber.setBounds(10, 10, 72, 32);
		getContentPane().add(lblTheNumber);
		
		btnPlayAgain = new JButton("PlayAgain");
//		playAgin,����һ��
		btnPlayAgain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newGame();	
			}
		});
		btnPlayAgain.setVisible(false);
		btnPlayAgain.setBounds(166, 220, 93, 23);
		getContentPane().add(btnPlayAgain);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		��һ��1��������Ϸ����ʵ�������洴���Ķ���
		GuessingGame theGame = new GuessingGame();
//		�ڶ���2��������Ϸ�����newGame������Ҳ���Ǵ���Ҫ�µ�����
		theGame.newGame();
//		������3�����ô�������ĳߴ��С
		theGame.setSize(new Dimension(450, 300));
//		���Ĳ�4��ʹ�����Ķ�����ʾ����
		theGame.setVisible(true);
	}
}
