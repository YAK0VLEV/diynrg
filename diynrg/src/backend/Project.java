package backend;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Blueprint to create projects.
 * 
 * @author Denis Yakovlev
 */
public class Project {

	/**
	 * The project name.
	 */
	private String myProjectName;
	/**
	 * The project creation date.
	 */
	private Date myProjectDate = new Date();
	
	/**
	 * @author mike briden
	 * price for electricity $0.0853/kWh
	 */
	private final double RATE = .0853; 
	
	/**
	 * A list to store items.
	 */
	private List<AbstractItem> myItems = new ArrayList<AbstractItem>();;

	/**
	 * The class constructor
	 * 
	 * @param theName - a name's chosen for the current project by a user
	 */
	public Project(String theName) {
		myProjectName = theName;
	}

	/**
	 * A method to add items in the current project
	 * 
	 * @param theItem - an item's chosen ti replace
	 */
	public void addItem(AbstractItem theItem) {
		myItems.add(theItem);
	}

	/**
	 * The current project name.
	 * 
	 * @return a project name
	 */
	public String getProjectName() {
		return myProjectName;
	}

	/**
	 * Project creation date.
	 * 
	 * @return a project creation date
	 */
	public Date getDate() {
		return myProjectDate;
	}

	/**
	 * Method calculates a cost for items to replace in the current 
	 * project 
	 * 
	 * @return total cost all item in the project
	 */
	public float getTotalCost() {
		float totalCost = 0.0f;

		for (AbstractItem item : myItems) {
			totalCost += item.getPriceForQuantity();
		}
		
		return totalCost;
	}
	
	/**
	 * @author mike briden
	 * Calculates the savings for a given item
	 * @return saved per year for a given DIYproject
	 */
	public double EnergySavedPerItem(AbstractItem item) {
		double saving = 0;
		saving = item.getBaseEnergyConsumptionForQuantity() - 
					item.getEnergyConsumptionForQuantity();
		return saving;
	}
	
	/**
	 * @author mike briden 3/2/2018
	 * Calculates the savings per year for a given DIYproject.
	 * assumes 12hrs use per day.
	 * 
	 * @return saved per year for a given DIYproject
	 */
	public double EnergySavedPerYear() {
		double saving = 0;
		int count = 0;
		for (AbstractItem item : myItems) {
			System.out.println(count);
			saving += 365*EnergySavedPerItem(item);
			count++;
		}	
		//return savings
		return saving;
	}
	
	
	
	/**
	 * NEED a formula (Implemented User Story #2)
	 * @author mike briden
	 * @return saved per year for a given DIYproject
	 */
	public double savingPerYearForGivenDIYproject() {
		return EnergySavedPerYear() / 1000 * RATE;
	}
	
	/**
	 * NEED a formula (Implemented User Story #3)
	 * @author mike Briden
	 * @return estimated time for how long it will cost to �break even� in years
	 */
	public double estimationBreakEvenTime() {
		return getTotalCost() / savingPerYearForGivenDIYproject();
	}		

	/**
	 * @author mike briden
	 * A method to test in text mode
	 */
	public String showItems() {
		System.out.println(myItems.size());
			StringBuilder s1 = new StringBuilder();
			s1.append("Project Summary\n");
		for (AbstractItem item : myItems) {
			s1.append("Item : ");
			s1.append(item.name());
			s1.append(", Quantity : " + item.getQuantity());
			s1.append(", Area : ");
			s1.append( item.getArea());
			s1.append(", Price for Item set : "); 
			s1.append(item.getPriceForQuantity());
			s1.append("\n");
		}
		s1.append("The time to break even (years): ");
		s1.append(String.format("%.3f", estimationBreakEvenTime()));
		s1.append("\n");
		return s1.toString();
	}
}
