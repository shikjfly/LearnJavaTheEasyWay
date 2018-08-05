import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class SecretMessagesGUI extends JFrame {
	private JTextField txtKey;
	private JTextArea txtIn;
	private JTextArea txtOut;
	private JSlider slider;
	private JButton btnMoveUp;
	private JScrollPane scrollPane;
	private JScrollPane scrollPane_1;
//	加密方法
 	public String encode(String message, int keyVal) {
		String output = "";
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
		return output;
		
	}
	
	public SecretMessagesGUI() {
		getContentPane().setBackground(new Color(72, 209, 204));
		setTitle("Xzhao's Secret Message App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 10, 564, 140);
		getContentPane().add(scrollPane);
		
		txtIn = new JTextArea();
		scrollPane.setViewportView(txtIn);
		txtIn.setWrapStyleWord(true);
		txtIn.setLineWrap(true);
		txtIn.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));
		
		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(10, 212, 564, 140);
		getContentPane().add(scrollPane_1);
		
		txtOut = new JTextArea();
		scrollPane_1.setViewportView(txtOut);
		txtOut.setWrapStyleWord(true);
		txtOut.setLineWrap(true);
		txtOut.setFont(new Font("Lucida Sans Typewriter", Font.PLAIN, 18));
		
		txtKey = new JTextField();
		txtKey.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					slider.setValue(Integer.parseInt(txtKey.getText()));
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Please enter a whole number between -26 and 26.");
				}
			}
		});
		txtKey.setBounds(299, 169, 40, 21);
		getContentPane().add(txtKey);
		txtKey.setColumns(10);
		
		JLabel lblKey = new JLabel("Key:");
		lblKey.setHorizontalAlignment(SwingConstants.RIGHT);
		lblKey.setBounds(256, 172, 33, 15);
		getContentPane().add(lblKey);
		
		JButton btnEncodedecode = new JButton("Encode/Decode");
//		btn按钮点击事件
		btnEncodedecode.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
//					获取输入信息
					String message = txtIn.getText();
//					获取密匙
					int keyVal = Integer.parseInt(txtKey.getText());
//					调用加密方法
					String output = encode(message, keyVal);
//					输出加密信息
					txtOut.setText(output);
				} catch (Exception e2) {
					// TODO: handle exception
					JOptionPane.showMessageDialog(null, "Please enter a whole number value for the encryption key.");
					txtKey.requestFocus();
					txtKey.selectAll();
				}
			}
		});
		btnEncodedecode.setBounds(349, 168, 111, 23);
		getContentPane().add(btnEncodedecode);
		
		slider = new JSlider();
//		slide滑动条数字变动事件
		slider.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				txtKey.setText("" + slider.getValue() );
//				获取输入信息
				String message = txtIn.getText();
//				获取密匙
				int key = slider.getValue();
//				调用加密方法
				String output = encode(message, key);
//				输出加密信息
				txtOut.setText(output);
			}
		});
		slider.setPaintLabels(true);
		slider.setPaintTicks(true);
		slider.setValue(3);
		slider.setMajorTickSpacing(13);
		slider.setMinorTickSpacing(1);
		slider.setMaximum(26);
		slider.setMinimum(-26);
		slider.setBackground(new Color(72, 209, 204));
		slider.setBounds(46, 160, 200, 46);
		getContentPane().add(slider);
		
		btnMoveUp = new JButton("Move Up");
		btnMoveUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				把输出的值当输入
				txtIn.setText(txtOut.getText());
//				方式一：把获取到的滚动条数字，取负再加载
				txtKey.setText("" + (-slider.getValue()) );
//				方式二：把获取到的文本数字，取负再加载
//				txtKey.setText("-"+txtKey.getText());
				slider.setValue((-slider.getValue()));
			}
		});
		btnMoveUp.setBounds(481, 168, 75, 23);
		getContentPane().add(btnMoveUp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SecretMessagesGUI theApp = new SecretMessagesGUI();
		theApp.setSize(new java.awt.Dimension(600, 400));
		theApp.setVisible(true);
	}
}
