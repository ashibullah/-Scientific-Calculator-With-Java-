import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.SystemColor;

public class Scalculator {

	private JFrame frame;
	private JTextField textField;


	double n1,n2,result;
	String operator, answer;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scalculator window = new Scalculator();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Scalculator() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Calculator");
		frame.getContentPane().setBackground(UIManager.getColor("Button.background"));
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(12, 38, 291, 36);
		textField.setFont(new Font("Arial", Font.BOLD, 18));
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnroot = new JButton("√");
		btnroot.setBounds(12, 75, 64, 36);
		btnroot.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.pow(Double.parseDouble(textField.getText()),(0.5));
				textField.setText("");
				textField.setText(textField.getText()+a);
				

			}
		});
		frame.getContentPane().add(btnroot);
		
		JButton btnmod = new JButton("%");
		btnmod.setBounds(240, 124, 64, 36);
		btnmod.setFont(new Font("Dialog", Font.BOLD, 18));
		btnmod.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textField.getText());
				textField.setText("");
				operator = "%";
			}
		});
		frame.getContentPane().add(btnmod);
		
		JButton btnsin = new JButton("Sin");
		btnsin.setBounds(88, 75, 64, 36);
		btnsin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			double a = Math.sin(Double.parseDouble(textField.getText()));
			textField.setText("");
			textField.setText(textField.getText()+a);
			
			}
		});
		frame.getContentPane().add(btnsin);
		
		JButton btncos = new JButton("Cos");
		btncos.setBounds(164, 75, 64, 36);
		btncos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.cos(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
			
		});
		frame.getContentPane().add(btncos);
		
		JButton btntan = new JButton("Tan");
		btntan.setBounds(240, 75, 64, 36);
		btntan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double a = Math.tan(Double.parseDouble(textField.getText()));
				textField.setText("");
				textField.setText(textField.getText()+a);
			}
		});
		frame.getContentPane().add(btntan);
		
		JButton btnback = new JButton(" ←");
		btnback.setBounds(12, 124, 64, 36);
		btnback.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().length()>0) {
				String backspace = null;
				StringBuilder str = new StringBuilder(textField.getText());
				str.deleteCharAt(textField.getText().length()-1);
				backspace = str.toString();
				textField.setText(backspace);
				}
			}
		});
		btnback.setFont(new Font("Arial Black", Font.BOLD, 20));
		frame.getContentPane().add(btnback);
		
		JButton btnC = new JButton("C");
		btnC.setBounds(88, 124, 64, 36);
		btnC.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				
			}
		});
		frame.getContentPane().add(btnC);
		
		JButton btn7 = new JButton("7");
		btn7.setBounds(12, 173, 64, 36);
		btn7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String number = textField.getText()+btn7.getText();
			textField.setText(number);
			}
		});
		btn7.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btn7);
		
		JButton btnmul = new JButton("*");
		btnmul.setBounds(240, 174, 64, 36);
		btnmul.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textField.getText());
				textField.setText("");
				operator = "*";
			}
		});
		btnmul.setFont(new Font("Dialog", Font.BOLD, 18));
		frame.getContentPane().add(btnmul);
		
		JButton btndiv = new JButton("/");
		btndiv.setBounds(164, 124, 64, 36);
		btndiv.setFont(new Font("Dialog", Font.BOLD, 20));
		btndiv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textField.getText());
				textField.setText("");
				operator = "/";
			}
		});
		frame.getContentPane().add(btndiv);
		
		JButton btnequal = new JButton("=");
		btnequal.setBounds(240, 322, 64, 36);
		btnequal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n2 = Double.parseDouble(textField.getText());
				if (operator == "+") {
					result = n1 + n2;
					answer = String.format("%.2f ", result);
					textField.setText(answer);
				}
				
				else if (operator == "-") {
					result = n1 - n2;
					answer = String.format("%.2f ", result);
					textField.setText(answer);
				}
				
				else if (operator == "*") {
					result = n1 * n2;
					answer = String.format("%.2f ", result);
					textField.setText(answer);
				}
				
				else if (operator == "/") {
					result = n1 / n2;
					answer = String.format("%.2f ", result);
					textField.setText(answer);
				}
				
				else if (operator == "%") {
					result = n1 % n2;
					answer = String.format("%.2f ", result);
					textField.setText(answer);
				}
				
			}
		});
		btnequal.setFont(new Font("Dialog", Font.BOLD, 15));
		frame.getContentPane().add(btnequal);
		
		JButton btnplus = new JButton("+");
		btnplus.setBounds(239, 268, 64, 36);
		btnplus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			n1 = Double.parseDouble(textField.getText());
			textField.setText("");
			operator = "+";
			}
		});
		btnplus.setForeground(UIManager.getColor("Button.foreground"));
		btnplus.setFont(new Font("Dialog", Font.BOLD, 16));
		frame.getContentPane().add(btnplus);
		
		JButton btn8 = new JButton("8");
		btn8.setBounds(88, 172, 64, 36);
		btn8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		String number = textField.getText()+btn8.getText();
		textField.setText(number);
			}
		});
		btn8.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btn8);
		
		JButton btn9 = new JButton("9");
		btn9.setBounds(164, 172, 64, 36);
		btn9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String number = textField.getText()+btn9.getText();
			textField.setText(number);
			}
		});
		btn9.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btn9);
		
		JButton btn4 = new JButton("4");
		btn4.setBounds(12, 221, 64, 36);
		btn4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String number = textField.getText()+btn4.getText();
			textField.setText(number);
			}
		});
		btn4.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btn4);
		
		JButton btn5 = new JButton("5");
		btn5.setBounds(88, 222, 64, 36);
		btn5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String number = textField.getText()+btn5.getText();
			textField.setText(number);
			}
		});
		btn5.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btn5);
		
		JButton btn6 = new JButton("6");
		btn6.setBounds(164, 220, 64, 36);
		btn6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String number = textField.getText()+btn6.getText();
			textField.setText(number);
			}
		});
		btn6.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btn6);
		
		JButton btn1 = new JButton("1");
		btn1.setBounds(12, 271, 64, 36);
		btn1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn1.getText();
				textField.setText(number);
			}
		});
		btn1.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btn1);
		
		JButton btn2 = new JButton("2");
		btn2.setBounds(88, 271, 64, 36);
		btn2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn2.getText();
				textField.setText(number);
			}
		});
		btn2.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btn2);
		
		JButton btn3 = new JButton("3");
		btn3.setBounds(164, 271, 64, 36);
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number;
				number = textField.getText()+btn3.getText();
				textField.setText(number);
			}
		});
		btn3.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btn3);
		
		JButton btn0 = new JButton("0");
		btn0.setBounds(12, 320, 140, 36);
		btn0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btn0.getText();
				textField.setText(number);
			}
		});
		btn0.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btn0);
		
		JButton btnminus = new JButton("-");
		btnminus.setBounds(239, 221, 64, 36);
		btnminus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				n1 = Double.parseDouble(textField.getText());
				textField.setText("");
				operator = "-";
			}
		});
		btnminus.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btnminus);
		
		JButton btnpoint = new JButton(".");
		btnpoint.setBounds(164, 319, 64, 36);
		btnpoint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String number = textField.getText()+btnpoint.getText();
				textField.setText(number);
			}
		});
		btnpoint.setFont(new Font("Dialog", Font.BOLD, 20));
		frame.getContentPane().add(btnpoint);
		
		JLabel lblNewLabel = new JLabel("Friday Calculator");
		lblNewLabel.setForeground(new Color(0, 100, 0));
		lblNewLabel.setFont(new Font("Fontjek", Font.PLAIN, 23));
		lblNewLabel.setBounds(12, -2, 176, 36);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 335, 407);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
