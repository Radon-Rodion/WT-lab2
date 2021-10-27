package main.java.by.tc.task01.dao.control.impl;

import main.java.by.tc.task01.entity.Refrigerator;
import main.java.by.tc.task01.dao.control.Controller;

/**
 * Controller to manipulate frige entity object's fields
 * 
 * @author Radon-Rodion (aka Pavel Rafeyev)
 *
 */
public class RefrigeratorController implements Controller {
	/**
	 * Controlled frige entity object
	 */
	private Refrigerator refrigerator;

	/**
	 * Constructor for controller of refrigerator
	 * 
	 * @param refrigerator - entity object to be controlled
	 */
	public RefrigeratorController(Refrigerator refrigerator) {
		this.refrigerator = refrigerator;
	}

	@Override
	public String takeInfo() {
		return this.refrigerator.toString();
	}

	@Override
	public boolean containsValue(String key, Object value) {
		boolean answer = true;
		switch (key) {
		case "PRICE":
			if (!(refrigerator.getPrice() == Double.parseDouble(value.toString()))) {
				answer = false;
			}
			break;
		case "POWER_CONSUMPTION":
			if (!(refrigerator.getPowerConsumption() == Double.parseDouble(value.toString()))) {
				answer = false;
			}
			break;
		case "WEIGHT":
			if (!(refrigerator.getWeight() == Double.parseDouble(value.toString()))) {
				answer = false;
			}
			break;
		case "FREEZER_CAPACITY":
			if (!(refrigerator.getFreezerCapacity() == Double.parseDouble(value.toString()))) {
				answer = false;
			}
			break;
		case "OVERALL_CAPACITY":
			if (!(refrigerator.getOverallCapacity() == Double.parseDouble(value.toString()))) {
				answer = false;
			}
			break;
		case "HEIGHT":
			if (!(refrigerator.getHeight() == Double.parseDouble(value.toString()))) {
				answer = false;
			}
			break;
		case "WIDTH":
			if (!(refrigerator.getWidth() == Double.parseDouble(value.toString()))) {
				answer = false;
			}
			break;

		default:
			answer = false;
		}
		return answer;
	}
}
