import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.SwingConstants;


public class DigitalClockGUI extends JFrame {
	public boolean alarm = false;

	private JPanel contentPane;
	private JTextField textFieldHour;
	private JTextField textFieldMin;
	private JTextField textAlarmSet;
	private JTextField textClock;
	private ClockLogic clockLogic; 

	JLabel lblAlarmClock = new JLabel("00:00:00");
	JLabel lblAlarmset = new JLabel("No Alarm");
	JButton btnClearAlarm = new JButton("Clear Alarm");
	JLabel lblErrorMsg = new JLabel("");
	JLabel lblAlarmMsg = new JLabel("");
	
	
	//Random rand = new Random(); //Implementerar randomfunktionen för alarmet
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DigitalClockGUI frame = new DigitalClockGUI();
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
	public DigitalClockGUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 256, 312);
		contentPane = new JPanel();
		contentPane.setBackground(Color.GRAY);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnSetAlarm = new JButton("Set Alarm");
		btnSetAlarm.setBounds(61, 172, 117, 29);
		btnSetAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    int hourCheck = Integer.parseInt(textFieldHour.getText());
			    int minuteCheck = Integer.parseInt(textFieldMin.getText());

			    if (hourCheck < 0 || hourCheck > 23 || minuteCheck < 0
			      || minuteCheck > 59) {
			     textAlarmSet.setText("NEJ");
			    } else {
			     String s4 = "";
			     String s5 = "";
			     
			     if (hourCheck < 10){
			    	 s4 = "0";
				 }
				 if (minuteCheck < 10){
					 s5 = "0";
				 }				     
				  
				 textAlarmSet.setText(s4 + hourCheck + ":" + s5 + minuteCheck);
				     
				 clockLogic.setAlarm(hourCheck, minuteCheck);
				     
			    }
			    }
		});
		contentPane.setLayout(null);
		contentPane.add(btnSetAlarm);
								
		JButton btnClearAlarm = new JButton("Clear Alarm");
		btnClearAlarm.setBounds(61, 254, 117, 29);
		btnClearAlarm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldHour.setText("");
				textFieldMin.setText("");
				textAlarmSet.setText("No Alarm");
				clockLogic.clearAlarm();
				alarm = false;
			}
		});
		contentPane.add(btnClearAlarm);
		
		textFieldHour = new JTextField();
		textFieldHour.setBounds(61, 127, 41, 28);
		contentPane.add(textFieldHour);
		textFieldHour.setColumns(10);
		
		textFieldMin = new JTextField();
		textFieldMin.setBounds(137, 127, 41, 28);
		contentPane.add(textFieldMin);
		textFieldMin.setColumns(10);
		
		JLabel lblHours = new JLabel("Hours");
		lblHours.setBounds(61, 156, 61, 16);
		contentPane.add(lblHours);
		
		JLabel lblMinutes = new JLabel("Minutes");
		lblMinutes.setBounds(134, 156, 61, 16);
		contentPane.add(lblMinutes);
		
		textAlarmSet = new JTextField();
		textAlarmSet.setHorizontalAlignment(SwingConstants.CENTER);
		textAlarmSet.setBounds(77, 213, 83, 28);
		contentPane.add(textAlarmSet);
		textAlarmSet.setColumns(10);
		
		textClock = new JTextField();
		textClock.setForeground(Color.RED);
		textClock.setEditable(false);
		textClock.setHorizontalAlignment(SwingConstants.CENTER);
		textClock.setBorder(null);
		textClock.setBackground(Color.GRAY);
		textClock.setFont(new Font("Synchro LET", Font.PLAIN, 55));
		textClock.setBounds(0, 38, 251, 55);
		contentPane.add(textClock);
		textClock.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.GRAY);
		lblNewLabel.setBounds(0, 0, 251, 290);
		contentPane.add(lblNewLabel);
			
		clockLogic = new ClockLogic(this);
		}
	
		public void setTimeOnLabel (String time){
			textClock.setText(time);
		}
			
		public void alarm (boolean activate){
			if (true) {
				alarm = true;
				textAlarmSet.setText("ALARM!");
				JLabel lblNewLabel = new JLabel("");
				lblNewLabel.setBackground(new Color(255,255,255));
			}	
		}
}
