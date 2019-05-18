package Stepdefination;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import io.appium.java_client.android.AndroidDriver;
import cucumber.api.java.en.Then;

public class Stepdefs {
	AndroidDriver driver;

	@Given("^Open App$")
	public void open_App() throws Exception {
		DesiredCapabilities cap = new DesiredCapabilities();
		// Nền tảng test, Android or Iphone
		cap.setCapability("platformName", "ANDROID");
		// Thiết bị chạy test - Lấy qua lệnh ADB Devices
		cap.setCapability("deviceName", "192.168.2.240:1995");
		// Các thông số của App muốn Test
		// Để lấy được các thông số này cần mở App trên device sau đó chạy các lệnh sau:
		// adb shell
		// dumpsys window windows|grep -E 'mCurrentFocus'
		cap.setCapability("appPackage", "org.topica.vcrx.vn");
		cap.setCapability("appActivity", "org.jitsi.meet.MainActivity");
		// cấp quyền cho ứng dụng
		cap.setCapability("autoGrantPermissions", true);
		// Khởi tạo Android Driver với profile ở trên
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), cap);
		// Implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@When("^Input username and password valid$")
	public void input_username_and_password_valid() throws Exception {
		driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Username\"]").sendKeys("tei_testviet003@topica.edu.vn");
		driver.findElementByXPath("//android.widget.EditText[@content-desc=\"Password.\"]").sendKeys("topica123");
		driver.findElementByXPath("//android.view.ViewGroup[@content-desc=\"Tap to Join.\"]").click();
	}

	@Then("^Login success with notify popup$")
	public void login_success_with_notify_popup() throws Exception {
		String mess = driver.findElementById("android:id/contentPanel").getText();
		Assert.assertEquals("Đăng nhập thành công", mess);
	}

}