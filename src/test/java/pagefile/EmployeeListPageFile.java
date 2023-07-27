package pagefile;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EmployeeListPageFile {

	@FindBy(xpath = "//div[contains(@class,'oxd-padding-cell')][3]")
	List<WebElement> firstmidnamelist;

	@FindBy(xpath = "//div[contains(@class,'oxd-padding-cell')][4]")
	List<WebElement> lastnamelist;

	public void getFirstMidNames() {
		for (int i = 0; i < firstmidnamelist.size(); i++) {
			System.out.println(firstmidnamelist.get(i));
		}
	}

}
