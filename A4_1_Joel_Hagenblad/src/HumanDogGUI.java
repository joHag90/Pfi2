import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.util.ArrayList;

public class HumanDogGUI extends JFrame {

	Human human;
	Dog dog;
	boolean correctHumanName;
	boolean correctDogName;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HumanDogGUI frame = new HumanDogGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public HumanDogGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 431);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);				
		
		textField = new JTextField();
		textField.setBounds(69, 88, 134, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(69, 141, 134, 28);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		JLabel lblInfo = new JLabel("Info");
		lblInfo.setBounds(79, 230, 61, 16);
		contentPane.add(lblInfo);
		
		textField_2 = new JTextField();
		textField_2.setBounds(69, 323, 404, 44);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(69, 249, 404, 44);
		contentPane.add(textField_3);
		
		JLabel lblErrorMessage = new JLabel("Error Message");
		lblErrorMessage.setBounds(79, 305, 88, 16);
		contentPane.add(lblErrorMessage);
		
		JLabel lblNewLabel = new JLabel("Humans and Dogs");
		lblNewLabel.setFont(new Font("Verdana", Font.BOLD, 22));
		lblNewLabel.setBounds(141, 25, 240, 37);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("New Human");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				human = new Human(textField.getText());
				System.out.println("Människan " + human.getName() + " skapad");
				correctHumanName = true;
				
				if (human.getError() != null){
					textField_2.setText(human.getError());
					correctHumanName = false;
				}
			}
		});
		btnNewButton.setBounds(239, 89, 117, 29);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Buy Dog");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					dog = human.buyDog(new Dog(textField_1.getText()));
					System.out.println("Hunden " + dog.getName() + " köpt av " + human.getName());
					correctDogName = true;
					
					if (dog.getError() != null){
						textField_2.setText("Hundens namn måste vara längre än 3 bokstäver");
						correctDogName = false;
					}
					}
				catch (NullPointerException g){
					textField_2.setText("Hunden måste ha ett namn och en ägare");
				}
				}
		});
		btnNewButton_1.setBounds(239, 142, 117, 29);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Print Info");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setText(null);
				textField_3.setText(null);
				try {
					if (correctHumanName || correctDogName){
						textField_3.setText(human.getInfo());
					} else {
						textField_2.setText("Ägaren och hunden måste ha ett namn");
						correctHumanName = false;
						correctDogName = false;
					}
				}
				catch (NullPointerException f) {
					textField_2.setText("Ägaren och hunden måste ha ett namn");
				}
				}
			
		});
		btnNewButton_2.setBounds(239, 196, 117, 29);
		contentPane.add(btnNewButton_2);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dog = null;
				human = null;
				textField_2.setText(null);
				textField_3.setText(null);
			}
		});
		btnClear.setBounds(399, 142, 117, 29);
		contentPane.add(btnClear);
		
	}
}
