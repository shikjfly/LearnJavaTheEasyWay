import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MadLibs2 extends JFrame {
	private JTextField txtAdjective;
	private JTextField txtColor;
	private JTextField txtNoun;
	private JTextField txtPastTenseVerb;
	private JButton btnPress;
	private JTextArea txtArea;
	
	public void inputMessage() {

		String txtColors = txtColor.getText();
		String txtNouns = txtNoun.getText();
		String txtAdjs = txtAdjective.getText();
		String txtVer = txtPastTenseVerb.getText();		
		String message = " The " +txtColors+ " dragon " +txtVer+ " at the " +txtAdjs+ " knight, who rode in on a stury, giant " +txtNouns+" .";
		txtArea.setText(message);
	}
	
	public MadLibs2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Xzhao's GUI MadLibs");
		getContentPane().setLayout(null);
		
		JLabel lblXzhaosWackyMadlibs = new JLabel("Xzhao's Wacky MadLibs APP");
		lblXzhaosWackyMadlibs.setFont(new Font("MingLiU-ExtB", Font.BOLD, 15));
		lblXzhaosWackyMadlibs.setHorizontalAlignment(SwingConstants.CENTER);
		lblXzhaosWackyMadlibs.setBounds(10, 0, 414, 31);
		getContentPane().add(lblXzhaosWackyMadlibs);
		
		JLabel lblEnterAnAdjective = new JLabel("Enter an Adjective:");
		lblEnterAnAdjective.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterAnAdjective.setFont(new Font("Shonar Bangla", Font.PLAIN, 13));
		lblEnterAnAdjective.setBounds(10, 53, 135, 23);
		getContentPane().add(lblEnterAnAdjective);
		
		JLabel lblEnterAColor = new JLabel("Enter a Color:");
		lblEnterAColor.setFont(new Font("Shonar Bangla", Font.PLAIN, 13));
		lblEnterAColor.setBounds(246, 53, 82, 23);
		getContentPane().add(lblEnterAColor);
		
		JLabel lblEnterAVarb = new JLabel("Enter a varb Ending in -ed:");
		lblEnterAVarb.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEnterAVarb.setFont(new Font("Shonar Bangla", Font.PLAIN, 13));
		lblEnterAVarb.setBounds(10, 98, 135, 23);
		getContentPane().add(lblEnterAVarb);
		
		JLabel lblEnterANoun = new JLabel("Enter a Noun:");
		lblEnterANoun.setFont(new Font("Shonar Bangla", Font.PLAIN, 13));
		lblEnterANoun.setBounds(246, 98, 82, 23);
		getContentPane().add(lblEnterANoun);
		
		txtAdjective = new JTextField();
		txtAdjective.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputMessage();
			}
		});
		txtAdjective.setBounds(155, 53, 66, 21);
		getContentPane().add(txtAdjective);
		txtAdjective.setColumns(10);
		
		txtColor = new JTextField();
		txtColor.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputMessage();
			}
		});
		txtColor.setColumns(10);
		txtColor.setBounds(320, 53, 66, 21);
		getContentPane().add(txtColor);
		
		txtNoun = new JTextField();
		txtNoun.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputMessage();
			}
		});
		txtNoun.setColumns(10);
		txtNoun.setBounds(320, 100, 66, 21);
		getContentPane().add(txtNoun);
		
		txtPastTenseVerb = new JTextField();
		txtPastTenseVerb.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				inputMessage();
			}
		});
		txtPastTenseVerb.setColumns(10);
		txtPastTenseVerb.setBounds(155, 100, 66, 21);
		getContentPane().add(txtPastTenseVerb);
		
		btnPress = new JButton("Press Here to View Your MadLibs Creation!");
		btnPress.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inputMessage();
			}
		});
		btnPress.setBounds(87, 144, 279, 31);
		getContentPane().add(btnPress);
		
		txtArea = new JTextArea();
		txtArea.setLineWrap(true);
		txtArea.setFont(new Font("Comic Sans MS", Font.PLAIN, 18));
		txtArea.setText("xxx");
		txtArea.setBounds(10, 187, 414, 65);
		getContentPane().add(txtArea);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MadLibs2 madLibs = new MadLibs2();
		madLibs.setSize(new Dimension(450, 300));
		madLibs.setVisible(true);
	}
}
