package firstPackage;

import java.util.LinkedHashMap;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import CustomValidator.StringPrefix;

// This class will include annotation based validation rules for checking form data  
public class Student {
	
	/* In the case of firstName and lastName field (the default value of String will be null), because its 
	 type of input is text, the default value if the user doesn't provide data will be the empty string, not 
	 null. However, because this program utilize @InitBinder for removing whitespaces, the empty String will 
	 be trimmed to null, hence we can use @NotNull in this situation. */
	@NotNull(message="Required")
	@Size(min=1, max=20, message="Must be at least 1 Characters")
	private String firstName;
	@NotNull(message="Required")
	@Size(min=1, max=20, message="Must be at least 1 Characters")
	private String lastName;
	/* Note that @NotNull can only be use with the reference type of integer, not primitive type 
	 because beside the dafault value of the primitive type is 0, it will never be null */
	@NotNull(message="Required")
	@Min(value=0, message="Must be between 0 and 100")
	@Max(value=100, message="Must be between 0 and 100")
	private Integer point;
	private String country;
	// Using regular expression for obtain the zip zode in the right format
	@NotNull(message="Required")
	@Pattern(regexp="^[a-zA-Z0-9]{5}", message="Should be 5	characters/digits")
	private String postalCode;
	/* Because the default value of String is null, and its type of input is radio button that if
	 the user don't choose any option, the default value will still remain null, so we can use @NotNull. */
	@NotNull(message="Required")
	private String major; 
	private String[] hobbies;
	/* This custom annotation actually have the default values that matching with the arguments passing in, 
	 but I still pass it to better follow the program */
	@StringPrefix(value="VOUCHER", message="\"VOUCHER\" Must be at the Beginning")
	private String bookVoucher;
	
	private LinkedHashMap<String, String> countryOptions;
	private LinkedHashMap<String, String> majorOptions;
	
	/* Generate a list of countries and hobbies to simulate a database or file system in a real-life case for 
	practicing retrieving data from it*/
	public Student() {
		countryOptions = new LinkedHashMap<String, String>();
		countryOptions.put("US", "United States");
		countryOptions.put("GB", "Great Britain");
		countryOptions.put("VN", "VietNam");
		
		majorOptions = new LinkedHashMap<String, String>();
		majorOptions.put("Computer Science", "Computer Science");
		majorOptions.put("Psychology", "Psychology");
		majorOptions.put("Biology", "Biology");
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	
	public String[] getHobbies() {
		return hobbies;
	}

	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	
	public String getBookVoucher() {
		return bookVoucher;
	}

	public void setBookVoucher(String bookVoucher) {
		this.bookVoucher = bookVoucher;
	}

	public LinkedHashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

	public void setCountryOptions(LinkedHashMap<String, String> countryOptions) {
		this.countryOptions = countryOptions;
	}
	
	public LinkedHashMap<String, String> getMajorOptions() {
		return majorOptions;
	}

	public void setMajorOptions(LinkedHashMap<String, String> majorOptions) {
		this.majorOptions = majorOptions;
	}

}
