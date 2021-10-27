package main.java.by.tc.task01.dao.impl;

import main.java.by.tc.task01.dao.ApplianceDAO;
import main.java.by.tc.task01.entity.Appliance;
import main.java.by.tc.task01.entity.criteria.Criteria;
import main.java.by.tc.task01.dao.parser.Parser;
import main.java.by.tc.task01.dao.parser.XMLParser;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.List;

/**
 * Data access object class to appliance entities
 * @author Radon-Rodion (aka Pavel Rafeyev)
 *
 */
public class ApplianceDAOImpl implements ApplianceDAO{

	@Override
	public List<Appliance> find(Criteria criteria) {
		Parser parser=new XMLParser();
		try {
			parser.parse("src/main/resources/file.xml");
		} catch (ParserConfigurationException | SAXException | IOException e) {
			e.printStackTrace();
		}

		return parser.take(criteria);
	}
	

}
