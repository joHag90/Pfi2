package se.mah.k3lara.skaneAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;

import se.mah.k3lara.skaneAPI.model.Lines;
import se.mah.k3lara.skaneAPI.model.Station;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

import java.awt.Font;
import java.util.Calendar;

public class GUI extends JFrame {

	private JPanel contentPane;
	private SearchThread t;
	JLabel labelLinje1 = new JLabel("");
	JLabel labelLinje2 = new JLabel("");
	JLabel labelLinje3 = new JLabel("");
	JLabel labelLinje4 = new JLabel("");
	
	JLabel labelDes1 = new JLabel("");
	JLabel labelDes2 = new JLabel("");
	JLabel labelDes3 = new JLabel("");
	JLabel labelDes4 = new JLabel("");
	
	JLabel labelTime1 = new JLabel("");
	JLabel labelTime2 = new JLabel("");
	JLabel labelTime3 = new JLabel("");
	JLabel labelTime4 = new JLabel("");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI frame = new GUI();
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
	public GUI() {
		setFont(new Font("Calibri", Font.BOLD, 20));
		setTitle("Sk\u00E5netrafiken");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 449, 301);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUbtshallen = new JLabel("Ub\u00E5tshallen");
		lblUbtshallen.setForeground(Color.YELLOW);
		lblUbtshallen.setFont(new Font("Verdana", Font.BOLD, 25));
		lblUbtshallen.setBackground(new Color(240, 240, 240));
		lblUbtshallen.setBounds(123, 6, 189, 31);
		contentPane.add(lblUbtshallen);
		
		JLabel lblLinje = new JLabel("Linje");
		lblLinje.setForeground(Color.YELLOW);
		lblLinje.setFont(new Font("Verdana", Font.BOLD, 20));
		lblLinje.setBounds(12, 46, 56, 26);
		contentPane.add(lblLinje);
		
		JLabel lblDestination = new JLabel("Destination");
		lblDestination.setFont(new Font("Verdana", Font.BOLD, 20));
		lblDestination.setForeground(Color.YELLOW);
		lblDestination.setBounds(91, 46, 159, 26);
		contentPane.add(lblDestination);
		
		JLabel lblAvgar = new JLabel("Avg\u00E5r");
		lblAvgar.setForeground(Color.YELLOW);
		lblAvgar.setFont(new Font("Verdana", Font.BOLD, 20));
		lblAvgar.setBounds(337, 48, 76, 23);
		contentPane.add(lblAvgar);
		
		
		labelLinje1.setForeground(Color.WHITE);
		labelLinje1.setFont(new Font("Verdana", Font.PLAIN, 18));
		labelLinje1.setBounds(12, 70, 84, 31);
		contentPane.add(labelLinje1);
		
		
		labelLinje2.setForeground(Color.WHITE);
		labelLinje2.setFont(new Font("Verdana", Font.PLAIN, 18));
		labelLinje2.setBounds(12, 114, 84, 31);
		contentPane.add(labelLinje2);
		
		
		labelLinje3.setForeground(Color.WHITE);
		labelLinje3.setFont(new Font("Verdana", Font.PLAIN, 18));
		labelLinje3.setBounds(12, 158, 84, 31);
		contentPane.add(labelLinje3);
		
		
		labelLinje4.setForeground(Color.WHITE);
		labelLinje4.setFont(new Font("Verdana", Font.PLAIN, 18));
		labelLinje4.setBounds(12, 202, 84, 31);
		contentPane.add(labelLinje4);
		
		
		labelDes1.setForeground(Color.WHITE);
		labelDes1.setFont(new Font("Verdana", Font.PLAIN, 18));
		labelDes1.setBounds(91, 70, 240, 31);
		contentPane.add(labelDes1);
		
		
		labelDes2.setForeground(Color.WHITE);
		labelDes2.setFont(new Font("Verdana", Font.PLAIN, 18));
		labelDes2.setBounds(91, 114, 240, 31);
		contentPane.add(labelDes2);
		
		
		labelDes3.setForeground(Color.WHITE);
		labelDes3.setFont(new Font("Verdana", Font.PLAIN, 18));
		labelDes3.setBounds(91, 158, 240, 31);
		contentPane.add(labelDes3);
		
		
		labelDes4.setForeground(Color.WHITE);
		labelDes4.setFont(new Font("Verdana", Font.PLAIN, 18));
		labelDes4.setBounds(91, 202, 240, 31);
		contentPane.add(labelDes4);
		
		
		labelTime1.setForeground(Color.WHITE);
		labelTime1.setFont(new Font("Calibri", Font.PLAIN, 20));
		labelTime1.setBounds(337, 71, 84, 31);
		contentPane.add(labelTime1);
		
		
		labelTime2.setForeground(Color.WHITE);
		labelTime2.setFont(new Font("Calibri", Font.PLAIN, 20));
		labelTime2.setBounds(337, 115, 84, 31);
		contentPane.add(labelTime2);
		
		
		labelTime3.setForeground(Color.WHITE);
		labelTime3.setFont(new Font("Calibri", Font.PLAIN, 20));
		labelTime3.setBounds(337, 159, 84, 31);
		contentPane.add(labelTime3);
		
		
		labelTime4.setForeground(Color.WHITE);
		labelTime4.setFont(new Font("Calibri", Font.PLAIN, 20));
		labelTime4.setBounds(337, 203, 84, 31);
		contentPane.add(labelTime4);
		  
		  	UpdateLables();
		  	Thread t = new SearchThread (this); 
		  	t.start();
			  
	}
	
	public void UpdateLables(){
		Lines lines = Parser.getStationResults(new Station("80046"));

		  labelLinje1.setText(lines.getLines().get(0).getLine());
		  labelLinje2.setText(lines.getLines().get(1).getLine());
		  labelLinje3.setText(lines.getLines().get(2).getLine());
		  labelLinje4.setText(lines.getLines().get(3).getLine());
		  
		  labelDes1.setText(lines.getLines().get(0).getDestination());
		  labelDes2.setText(lines.getLines().get(1).getDestination());
		  labelDes3.setText(lines.getLines().get(2).getDestination());
		  labelDes4.setText(lines.getLines().get(3).getDestination());
		  
		  labelTime1.setText(FixThatClock(lines.getLines().get(0).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(0).getDepTime().get(Calendar.MINUTE)));
		  labelTime2.setText(FixThatClock(lines.getLines().get(1).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(1).getDepTime().get(Calendar.MINUTE)));
		  labelTime3.setText(FixThatClock(lines.getLines().get(2).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(2).getDepTime().get(Calendar.MINUTE)));
		  labelTime4.setText(FixThatClock(lines.getLines().get(3).getDepTime().get(Calendar.HOUR_OF_DAY)) + ":" + FixThatClock(lines.getLines().get(3).getDepTime().get(Calendar.MINUTE)));
		
	}
	
	public String FixThatClock(int time){
		  // Some variables that will create a '0' if a number is single digit, to
		  // make it nicer.
		  String zero = "";

		  if (time < 10) {
		   zero = "0";
		  }

		  // Compiles the values to nice, readable strings.
		  String finalTimeString = zero + Integer.toString(time);

		  zero = "";
		  
		  return finalTimeString;
		 }
	
}