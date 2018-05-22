package dbs.unicorn.teamone.dbsintuit.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private AppSession appSession;

	@GetMapping("/")
	public String defaultView() {
		if (appSession.getCurrentUser() == null) {
			return "redirect:login.html";
		} else {
			return "redirect:index.html";
		}
	}
}
