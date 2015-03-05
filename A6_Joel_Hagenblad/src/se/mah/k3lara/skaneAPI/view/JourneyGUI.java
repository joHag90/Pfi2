package se.mah.k3lara.skaneAPI.view;


import se.mah.k3lara.skaneAPI.xmlparser.Parser;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JTextArea;
import se.mah.k3lara.skaneAPI.model.Station;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

public class JourneyGUI extends JFrame {

	public JPanel contentPane;
	public final JPanel panel = new JPanel();
	public JTextField searchStationText;
	public ArrayList<Station> guiSearch = new ArrayList<Station>();
	public JTextArea resultArea;
	public JPanel panel_1;
	public JTextField fromTextField;
	public JTextField toTextField;
	public JTextArea resultJourney;
	   
	JourneyGUI g = this;
	
	private Parser p = new Parser();
	
	Thread tJ = new JourneysThread (p, this);
	Thread tS = new StationsThread (p, this);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JourneyGUI frame = new JourneyGUI();
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
	public JourneyGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 588, 311);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panel.setBounds(0, 0, 197, 289);
		contentPane.add(panel);
		panel.setLayout(null);
		
		searchStationText = new JTextField();
		searchStationText.setBounds(25, 6, 134, 28);
		panel.add(searchStationText);
		searchStationText.setColumns(10);
		
		//Search button for stations
		JButton searchButton = new JButton("Sök hållplats");
		searchButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread tS = new StationsThread (p, g);
				tS.start();
			}
		});
		searchButton.setBounds(31, 38, 125, 29);
		panel.add(searchButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(6, 71, 185, 212);
		panel.add(scrollPane);
		
		resultArea = new JTextArea();
		resultArea.setEditable(false);
		scrollPane.setViewportView(resultArea);
		
		panel_1 = new JPanel();
		panel_1.setBounds(197, 0, 391, 289);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		fromTextField = new JTextField();
		fromTextField.setBounds(6, 24, 134, 28);
		panel_1.add(fromTextField);
		fromTextField.setColumns(10);
		
		toTextField = new JTextField();
		toTextField.setBounds(6, 85, 134, 28);
		panel_1.add(toTextField);
		toTextField.setColumns(10);
		
		JLabel lblFrn = new JLabel("Från:");
		lblFrn.setBounds(6, 6, 61, 16);
		panel_1.add(lblFrn);
		
		JLabel lblTill = new JLabel("Till:");
		lblTill.setBounds(6, 64, 61, 16);
		panel_1.add(lblTill);
		
		//Search button for journeys
		JButton searchJourney = new JButton("Sök resa");
		searchJourney.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Thread tJ = new JourneysThread (p, g);
				tJ.start();
			}
		});
		searchJourney.setBounds(16, 125, 117, 29);
		panel_1.add(searchJourney);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(149, 13, 236, 270);
		panel_1.add(scrollPane_1);
		
		resultJourney = new JTextArea();
		resultJourney.setEditable(false);
		resultJourney.setAutoscrolls(false);
		scrollPane_1.setViewportView(resultJourney);
		

	}
}