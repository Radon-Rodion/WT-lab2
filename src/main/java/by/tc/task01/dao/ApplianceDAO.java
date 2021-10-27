package main.java.by.tc.task01.dao;

import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.criteria.Criteria;

import java.util.List;

/**
 * Interface for data access objects to appliance entities
 * @author Radon-Rodion (aka Pavel Rafeyev)
 *
 */
public interface ApplianceDAO {
	/**
	 * Searches and filters appliance entity object by params of criteria
	 * @param criteria - object with params to filter
	 * @return list of found entities or null if nothing is found
	 */
	List<Appliance> find(Criteria criteria);
}
