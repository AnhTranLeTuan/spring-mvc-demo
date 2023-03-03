package firstPackage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	
	@RequestMapping("/")
	public String firstMethod() {
		return "home";
	}
	
	@RequestMapping("/inputForm")
	public String randomMethod() {
		return "random";
	}

}
