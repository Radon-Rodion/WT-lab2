package main.java.by.tc.task01.main;

import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.dao.control.Controller;
import main.java.by.tc.task01.dao.control.ControllerFactory;

/**
 * Class for printing fields of appliance entity object to console
 * 
 * @author Radon-Rodion (aka Pavel Rafeyev)
 *
 */
public class PrintApplianceInfo {
	/**
	 * Prints fields of appliance entity object to console
	 * @param appliance - appliance entity object
	 */
	public static void print(Appliance appliance) {
		ControllerFactory controllerFactory = ControllerFactory.getInstance();
		Controller controller = controllerFactory.takeApplianceConrtoller(appliance);
		System.out.println(controller.takeInfo());
	}
}
