package localization;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

public class Main {

	public static void main(String[] args) {
		Locale us = new Locale("tr", "TR");
		ResourceBundle rb = ResourceBundle.getBundle("Gym", us);

		Properties props = new Properties();
		rb.keySet().stream().forEach(k -> props.put(k, rb.getString(k)));

		System.out.println(props.getProperty("name"));
		System.out.println(props.getProperty("info"));
	}

}
