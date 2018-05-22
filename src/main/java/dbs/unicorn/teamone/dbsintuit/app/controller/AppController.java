package dbs.unicorn.teamone.dbsintuit.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import dbs.unicorn.teamone.dbsintuit.app.repo.EmployeeRepo;

@RestController
public class AppController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@PostMapping("/login")
	public boolean isAuthenticated(String emailId, String password) {
		return null != employeeRepo.findByEmailId(emailId) && "secret".equals(password);
	}
	
}
