package dbs.unicorn.teamone.dbsintuit.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

	@Autowired
	private AppSession appSession;
	
	@GetMapping({"/index", "/loginView", "/index.html"})
	public String defaultView() {
		if (appSession.getCurrentUser() == null) {
			return "redirect:login.html";
		} else {
			return "redirect:index.html";
		}
	}
	
	@GetMapping({"/skillsView", "/skills.html"})
	public String skilsView() {
		if (appSession.getCurrentUser() == null) {
			return "redirect:login.html";
		} else {
			return "redirect:skills.html";
		}
	}
	
	@GetMapping({"/collegesView", "/colleges.html"})
	public String collegesView() {
		if (appSession.getCurrentUser() == null) {
			return "redirect:login.html";
		} else {
			return "redirect:colleges.html";
		}
	}
	
	@GetMapping({"/hobbiesView", "/hobbies.html"})
	public String hobbiesView() {
		if (appSession.getCurrentUser() == null) {
			return "redirect:login.html";
		} else {
			return "redirect:hobbies.html";
		}
	}
	
	@GetMapping({"/jobsView", "/jobs.html"})
	public String jobsView() {
		if (appSession.getCurrentUser() == null) {
			return "redirect:login.html";
		} else {
			return "redirect:jobs.html";
		}
	}
	
	@GetMapping({"/hometownView", "/hometown.html"})
	public String hometownView() {
		if (appSession.getCurrentUser() == null) {
			return "redirect:login.html";
		} else {
			return "redirect:hometown.html";
		}
	}
	
}
