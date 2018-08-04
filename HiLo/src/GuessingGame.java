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
//	在第一步创建的对象里面，调用了这个猜数字的方法
	public void checkGuess() {
		String guessText = txtGuess.getText();
		String message = "";
		try {
//			每调用一次checkGuess，就让数字加一次
			numberOfTries++;
			int guess = Integer.parseInt(guessText);
			if (guess > theNumber) {
				message = (guess + " is too high, Try again");
			}else if(guess < theNumber){
				message = (guess + " is too low, Try again");
			}else {
				message = (guess + " is correct. You win after " +numberOfTries+" Tries!");
//				 添加重新玩一遍，再次生成一个数字
				btnPlayAgain.setVisible(true);
				btnGuess.setVisible(false);
			}
		} catch (Exception e) {
			// TODO: handle exception
			message = "Enter a whole number between 1 and 100.";
		}finally {
//			每猜一次，就把猜测的结果输出到lblOutput上面
			lblOutput.setText(message);
//			然后再获取焦点
			txtGuess.requestFocus();
//			焦点要全选，方便下一次操作
			txtGuess.selectAll();
//			显示输出猜测的数字，但是因为setText需要String类型，所以int类型需要转换
			lblTheNumber.setText(String.valueOf(theNumber));
		}//end finally
	}//end checkGuess()
		
//	游戏开始，需要有个随机数字
	public void newGame() {
		btnGuess.setVisible(true);
		btnPlayAgain.setVisible(false);
		theNumber = (int)(Math.random()*100+1);
		numberOfTries=0;
	}
//	第一步，创建对象界面类
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
//		txtGuess文本监听到你Enter回车之后来提交猜测
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
//		btnGuess按钮监听提交的材料
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
//		playAgin,再玩一次
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
//		第一步1，创建游戏对象，实例化上面创建的对象
		GuessingGame theGame = new GuessingGame();
//		第二步2，调用游戏对象的newGame方法，也就是创建要猜的数字
		theGame.newGame();
//		第三步3，设置创建对象的尺寸大小
		theGame.setSize(new Dimension(450, 300));
//		第四步4，使创建的对象显示出来
		theGame.setVisible(true);
	}
}
