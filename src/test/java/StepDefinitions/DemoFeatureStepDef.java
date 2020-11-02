package StepDefinitions;

import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import com.google.common.base.Verify;
import PICOContainers.TestContext;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.googleMapPage;
import utilities.UI;
import utilities.fileHandling;

public class DemoFeatureStepDef extends TestContext {
	
	private TestContext base;
	
	private googleMapPage _googleMapPage;
	private List<WebElement> listedRoutes;
	private fileHandling fHandling;
	private UI ui;
	
	public DemoFeatureStepDef(TestContext _base, UI ui) 
	{
		this.base = _base;
		this.ui = ui;
		_googleMapPage = new googleMapPage();
		fHandling = new fileHandling();
	}
	
	@Given("user is navigate to {string}")
	public void user_is_navigate_to(String url) {
		base.getDriver().get(url);
	}

	@When("user search for {string}")
	public void user_search_for(String place) throws InterruptedException {
		ui.element(_googleMapPage.searchBox).sendKeys(place);
		ui.element(_googleMapPage.searchBox).sendKeys(Keys.ENTER);
		Thread.sleep(10000);
	    }

	@Then("user verify the coordinates for {string} are {double},{double}")
	public void user_verify_the_coordinates_for_are(String placeName, double xcordinate, double ycordinate) {
		String s = base.getDriver().getCurrentUrl();
		String sub = s.substring(s.indexOf("@")+1);
		String[] s1 = sub.split(",");
		System.out.println("This is in string " + s1[0]);
		System.out.println("This is in string " + s1[1]);
		Double xValue = Double.valueOf(s1[0]);
		Double yValue = Double.valueOf(s1[1]);
		Verify.verify(xValue==xcordinate, "X Values not mactched.");
		Verify.verify(yValue==ycordinate, "Y Values not mactched.");
	}

	@Then("user search for driving directions {string} from {string} to {string}")
	public void user_search_for_driving_directions_from_to(String vehicleType, String source, String destination) {
		ui.click(_googleMapPage.directionButton);
		switch(vehicleType.toLowerCase())
	    {
	    case "car":{
	    	ui.element(_googleMapPage.sourceInputBox).sendKeys(source);
	    	ui.element(_googleMapPage.destinationInputBox).sendKeys(destination);
	    }
	    break;
	    }
		ui.click(_googleMapPage.searchDirectionButton);
		ui.sleep(5);
	    listedRoutes= ui.elements(_googleMapPage.listedRoutes);
	}

	@Then("user see two or more routes are displayed in the list")
	public void user_see_two_or_more_routes_are_displayed_in_the_list() {
	    Verify.verify(listedRoutes.size()>=2, "Listed routes are less than 2.");
	}

	@Then("print the route title, distance in miles, and the travel time to a file titled {string}")
	public void print_the_route_title_distance_in_miles_and_the_travel_time_to_a_file_titled_routes_txt(String fileNameWithExtension) {
	    listedRoutes.get(0).click();
	    ui.click(_googleMapPage.routeStepsButton);
	    String routeDetails = ui.element(_googleMapPage.selectedRouteText).getText();
	    fHandling.writeToFile(routeDetails, fileNameWithExtension);
	}
}
