package main.java.by.tc.task01.main;

import static main.java.by.tc.task01.entity.criteria.SearchCriteria.*;

import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.criteria.Criteria;
import main.java.by.tc.task01.service.ApplianceService;
import main.java.by.tc.task01.service.ServiceFactory;

import java.util.List;

public class Main {

	public static void main(String[] args) {
		List<Appliance> appliances;
		ServiceFactory factory = ServiceFactory.getInstance();
		ApplianceService service = factory.getApplianceService();

		//Printing ovens with price = 15
		Criteria criteriaOven = new Criteria(Oven.class.getSimpleName());
		criteriaOven.add(Oven.PRICE.toString(), 15);

		appliances = service.find(criteriaOven);

		for (int i = 0; i <appliances.size(); i++) {
			PrintApplianceInfo.print(appliances.get(i));
		}
		System.out.println();

		//Printing ovens with price = 15 and depth = 80
		criteriaOven.add(Oven.DEPTH.toString(), 80);

		appliances = service.find(criteriaOven);

		for (int i = 0; i <appliances.size(); i++) {
			PrintApplianceInfo.print(appliances.get(i));
		}
		System.out.println();

		//Printing tabletPC with color = blue, display = 14 inches and ROM = 4 GB 
		//(No such tabletPCs so nothing is printed)
		Criteria criteriaTabletPC = new Criteria(TabletPC.class.getSimpleName());
		criteriaTabletPC.add(TabletPC.COLOR.toString(), "blue");
		criteriaTabletPC.add(TabletPC.DISPLAY_INCHES.toString(), 14);
		criteriaTabletPC.add(TabletPC.MEMORY_ROM.toString(), 4);

		appliances = service.find(criteriaTabletPC);

		for (int i = 0; i <appliances.size(); i++) {
			PrintApplianceInfo.print(appliances.get(i));
		}
		System.out.println();

		
		System.out.println("Vacuum cleaners:");
		appliances=service.find(new Criteria(VacuumCleaner.class.getSimpleName()));
		for (int i = 0; i <appliances.size(); i++) {
			PrintApplianceInfo.print(appliances.get(i));
		}
		System.out.println("Cheapest appliance:");
		PrintApplianceInfo.print(service.findCheapest(""));
		System.out.println("Cheapest oven:");
		PrintApplianceInfo.print(service.findCheapest(Oven.class.getSimpleName()));
	}

}
