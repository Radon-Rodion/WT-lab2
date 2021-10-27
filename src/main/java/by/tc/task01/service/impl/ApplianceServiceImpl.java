package main.java.by.tc.task01.service.impl;

import main.java.by.tc.task01.dao.ApplianceDAO;
import main.java.by.tc.task01.dao.DAOFactory;
import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.criteria.Criteria;
import main.java.by.tc.task01.service.ApplianceService;
import main.java.by.tc.task01.service.validation.Validator;

import java.util.List;

public class ApplianceServiceImpl implements ApplianceService{

	@Override
	public List<Appliance> find(Criteria criteria) {
		if (!Validator.criteriaValidator(criteria)) {
			return null;
		}

		DAOFactory factory = DAOFactory.getInstance();
		ApplianceDAO applianceDAO = factory.getApplianceDAO();


		return applianceDAO.find(criteria);
	}

	@Override
	public Appliance findCheapest(String groupName) {
		List<Appliance> appliances;
		if(groupName.equals("")){
			appliances=find(new Criteria(""));
		}else {
			appliances=find(new Criteria(groupName));
		}
		if(appliances==null){
			return null;
		}
		int indexOfMin=0;
		double min=appliances.get(0).getPrice();
		for (int i = 1; i <appliances.size(); i++) {
			if(appliances.get(i).getPrice()<min){
				min=appliances.get(i).getPrice();
				indexOfMin=i;
			}
		}
		return appliances.get(indexOfMin);
	}
}



