package pageObjects;


public class googleMapPage {

	public String searchBox = "searchboxinput";
	public String directionButton = "body jsl div.searchbox-directions-container button";
	public String sourceInputBox = ".widget-directions-searchboxes>div:nth-of-type(1) input";
	public String destinationInputBox = ".widget-directions-searchboxes>div:nth-of-type(2) input";
	public String listedRoutes = "div.section-directions-trip";
	public String searchDirectionButton = "div.widget-directions-searchboxes>div:nth-of-type(2) button.searchbox-searchbutton";
	public String routeStepsButton = "button[aria-label='Steps']";
	public String selectedRouteText = "div.section-trip-details";
}
