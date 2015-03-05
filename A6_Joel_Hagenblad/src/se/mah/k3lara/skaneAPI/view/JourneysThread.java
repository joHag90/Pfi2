package se.mah.k3lara.skaneAPI.view;

import java.util.Calendar;

import se.mah.k3lara.skaneAPI.control.Constants;
import se.mah.k3lara.skaneAPI.model.Journey;
import se.mah.k3lara.skaneAPI.model.Journeys;
import se.mah.k3lara.skaneAPI.xmlparser.Parser;

public class JourneysThread extends Thread {
	
	private Parser parser;
	private JourneyGUI gui;
	public JourneysThread(Parser p, JourneyGUI g) {
		this.parser = p;
		this.gui = g;
	}
	public void run() {
		//search journeys
		gui.resultJourney.setText(null);
		String searchURL = Constants.getURL(gui.fromTextField.getText(), gui.toTextField.getText(), 1);
		//
		
		Journeys journeys = Parser.getJourneys(searchURL);
		for (Journey journey : journeys.getJourneys()) {
			gui.resultJourney.setText(null);
			gui.resultJourney.append(journey.getStartStation()+" - " +journey.getEndStation() + "\n" );
			String time = journey.getDepDateTime().get(Calendar.HOUR_OF_DAY)+":"+journey.getDepDateTime().get(Calendar.MINUTE);
			gui.resultJourney.append("Departs " + time +" that is in "+journey.getTimeToDeparture()+ " minutes. \nAnd it is "+journey.getDepTimeDeviation()+" min late");
		}
	}
}