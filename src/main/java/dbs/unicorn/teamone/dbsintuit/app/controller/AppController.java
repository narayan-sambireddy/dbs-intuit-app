package dbs.unicorn.teamone.dbsintuit.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import dbs.unicorn.teamone.dbsintuit.app.AppSession;
import dbs.unicorn.teamone.dbsintuit.app.entity.EmployeeEntity;
import dbs.unicorn.teamone.dbsintuit.app.repo.EmployeeRepo;

@RestController
public class AppController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private AppSession appSession;

	@PostMapping("/login")
	public boolean isAuthenticated(String emailId, String password) {
		EmployeeEntity currentUser = employeeRepo.findByEmailId(emailId);
		appSession.setCurrentUser(currentUser);
		return null != currentUser && "secret".equals(password);
	}

	public List<EmployeeEntity> employeesBySkill(String skills) {
		return employeeRepo.findBySkills(skills);
	}
}
