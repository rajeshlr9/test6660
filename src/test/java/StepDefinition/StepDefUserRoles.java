package StepDefinition;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pages.UsersPage;
import reusable.UserRolesPage;
import utils.Config;

public class StepDefUserRoles {
	WebDriver driver = Steps.seleniumDriver;
	UserRolesPage userRolesPage = new UserRolesPage();
	UsersPage usersPage= new UsersPage();
	public StepDefUserRoles() throws Throwable { 
		// this.driver =
		// CreateBrowser.CreateBrowserInstance(); this.driver = Steps.seleniumDriver;
	}
	@When("^user log in to the Rooney application")
	public void user_log_in_to_the_Rooney_application() {
		try {
			String env = userRolesPage.environment;
			System.out.println("Environment:--"+env);
			if (env.equalsIgnoreCase("Dev")||env.equalsIgnoreCase("@env")) {
				driver.get(Config.getProperty("Rooney_URL_Dev"));
				Steps.logger.info("Dev Environment");
			} 
			userRolesPage.loginToRooneyApp();

		} catch (Exception e) {
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());
		}
	}
	@Then("^user create a user role With different Role")
	public void user_add_different_Role_to_the_User()
	{
		try {
			userRolesPage.user_create_a_user_role_With_different_role();
			Steps.logger.info("User add a different Role");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}
	}
	@Then("^user create a user role With two different Role")
	public void user_add_two_different_Role_to_the_User()
	{
		try {
			userRolesPage.user_create_a_user_role_With_two_different_role();
			Steps.logger.info("User add a different Role");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}
	}
	@Then("^user create a user role Without Region")
	public void user_add_User_role_Without_Region()
	{
		try {
			userRolesPage.user_create_a_user_role_for_Without_Region();
			Steps.logger.info("User create a user role without region");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}
	}
	@Then("^user create a user role Without BusinessUnit")
	public void user_add_User_role_Without_BusinessUnit()
	{
		try {
			userRolesPage.user_create_a_user_role_for_Without_BusinessUnit();
			Steps.logger.info("User create a user role without businessunit");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}}
	@Then("^user create a user role Without FirstName")
	public void user_add_User_role_Without_FirstName()
	{
		try {
			userRolesPage.user_create_a_user_role_for_Without_FirstName();
			Steps.logger.info("User create a user role without firstname");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}

	}
	@Then("^user create a user role Without UserName")
	public void user_add_User_role_Without_UserName()
	{
		try {
			userRolesPage.user_create_a_user_role_for_Without_UserName();
			Steps.logger.info("User create a user role without Username");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}

	}
	@Then("^user create a user role Updating the new UserName")
	public void user_add_User_role_Update_new_UserName()
	{
		try {
			userRolesPage.user_create_a_user_role_for_With_Updating_UserName();
			Steps.logger.info("User create a user role update new Username");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}

	}
	@Then("^user create a user role with wrong password")
	public void user_add_User_role_With_wrong_password()
	{
		try {
			userRolesPage.user_create_a_user_role_with_wrong_password();
			Steps.logger.info("User create a user role without password");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}

	}
	@Then("^user create a user role with one role without exiting and refreshing trying to add a new role")
	public void user_create_user_role_without_exiting_refreshing_trying_to_add_a_new_role()
	{
		try {
			userRolesPage.user_create_user_role_without_exiting_refreshing_trying_to_add_a_new_role();
			Steps.logger.info("User create a user role with one role and after clicking on submit button user again change the role");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}	
	}
	@Then("^user create a user role with three Role")
	public void user_add_User_role_With_three_Role()
	{
		try {
			userRolesPage.user_create_user_role_with_three_role();
			Steps.logger.info("User create a user role with 3 role");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}		
	}
	@Then("^user create a user role Without LastName")
	public void user_add_User_role_Without_LastName()
	{
		try {
			userRolesPage.user_create_a_user_role_for_Without_LastName();
			Steps.logger.info("User create a user role without lastname");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}

	}
	@Then("^user check business unit is not mapped to the region")
	public void user_check_business_unit_is_not_mapped_to_the_region()
	{
		try {
			userRolesPage.user_access_control_is_not_mapped_to_the_region();
			Steps.logger.info("business unit access control is not mapped to the region");
		}
		catch(Exception e)
		{
			Steps.testRes = "Failed";
			System.out.println(e);
			Assert.assertTrue(false, e.getMessage());	
		}

	}
	
	@Then("^user change the mode and validate the user role")
	public void Validation_of_UserRole_With_One_Role_Manhattan_Application() throws Throwable {
	
		{
			try {
				usersPage.Validation_of_UserRole_With_One_Role_Manhattan_Application();
				Steps.logger.info("User add a mode");
			}
			catch(Exception e)
			{
				Steps.testRes = "Failed";
				System.out.println(e);
				Assert.assertTrue(false, e.getMessage());	
			}
		}
	}
	@Then("^user change the mode and validate the Username and user role")
	public void Validation_of_Username_and_UserRole_In_Manhattan_Application() throws Throwable {
	
		{
			try {
				usersPage.Validation_of_new_Username_and_Role_In_Manhattan_Application();
				Steps.logger.info("User add a mode");
			}
			catch(Exception e)
			{
				Steps.testRes = "Failed";
				System.out.println(e);
				Assert.assertTrue(false, e.getMessage());	
			}
		}
	}
	@Then("^validate the user role with two different Roles")
	public void Validation_of_UserRole_With_two_Role_Manhattan_Application() throws Throwable {
	
		{
			try {
				usersPage.Validation_of_UserRole_With_two_Role_Manhattan_Application();
				Steps.logger.info("User add a mode");
			}
			catch(Exception e)
			{
				Steps.testRes = "Failed";
				System.out.println(e);
				Assert.assertTrue(false, e.getMessage());	
			}
		}
	}
	@Then("^validate the multiple roles for userrole")
	public void Validation_of_UserRole_With_three_Role_Manhattan_Application() throws Throwable {
	
		{
			try {
				usersPage.Validation_of_UserRole_With_three_Role_Manhattan_Application();
				Steps.logger.info("User add a mode");
			}
			catch(Exception e)
			{
				Steps.testRes = "Failed";
				System.out.println(e);
				Assert.assertTrue(false, e.getMessage());	
			}
		}
	}
	@Then("^delete the user role")
	public void delete_the_user_role() throws Throwable {
	
		{
			try {
				usersPage.Delete_the_userRole__in_Manhattan_Application();
				Steps.logger.info("User delete the user role");
			}
			catch(Exception e)
			{
				Steps.testRes = "Failed";
				System.out.println(e);
				Assert.assertTrue(false, e.getMessage());	
			}
		}
	}
}
