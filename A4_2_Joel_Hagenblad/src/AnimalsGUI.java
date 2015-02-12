import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;


public class AnimalsGUI extends JFrame {

	private JPanel contentPane;

	ArrayList<Animal> animals;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AnimalsGUI frame = new AnimalsGUI();
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
	public AnimalsGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 604, 317);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Verdana", Font.PLAIN, 12));
		textArea.setBounds(6, 26, 592, 263);
		contentPane.add(textArea);
		
		JLabel lblAnimallist = new JLabel("Animallist");
		lblAnimallist.setFont(new Font("Verdana", Font.BOLD, 13));
		lblAnimallist.setBounds(6, 6, 109, 16);
		contentPane.add(lblAnimallist);
		
		animals = new ArrayList<Animal>();
		
		animals.add(new Dog("Canis latrans", 4, true, "Kalle"));
		animals.add(new Cat("Lynx Lynx", 4, 9, "Loppan"));
		animals.add(new Dog("Canis latrans", 4, true, "Salka"));
		animals.add(new Dog("Canis latrans", 4, true, "Doris"));
		animals.add(new Cat("Lynx lynx", 4, 9, "Flisa"));
		animals.add(new Snake("Python regius", true));
		animals.add(new Cat("Lynx pardinus", 5, 9, "Kajsa"));
		animals.add(new Snake("Leiopython fredparken", false));
		animals.add(new Dog("Canis aureus", 4, false, "Pelle"));
		
		for (int i = 0; i < animals.size();i++){
			textArea.append(animals.get(i).getInfo() + "\n");
		}
		
		
	}
}
