package dbs.unicorn.teamone.dbsintuit.app.controller;

import static java.util.stream.Collectors.toList;
import static org.springframework.util.StringUtils.hasText;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dbs.unicorn.teamone.dbsintuit.app.AppSession;
import dbs.unicorn.teamone.dbsintuit.app.EmployeeTransformer;
import dbs.unicorn.teamone.dbsintuit.app.entity.EmployeeEntity;
import dbs.unicorn.teamone.dbsintuit.app.repo.EmployeeRepo;

@RestController
public class AppController {

	@Autowired
	private EmployeeRepo employeeRepo;

	@Autowired
	private AppSession appSession;

	@Autowired
	private EmployeeTransformer transformer;

	@PostMapping("/login")
	public boolean isAuthenticated(String emailId, String password) {
		EmployeeEntity currentUser = employeeRepo.findByEmailId(emailId);
		appSession.setCurrentUser(currentUser);
		return null != currentUser && "secret".equals(password);
	}

	@GetMapping("/skills")
	public String employeesBySkill(@RequestParam(required = false) String skills) {
		EmployeeEntity user = appSession.getCurrentUser();
		return processFurther(employeeRepo.findBySkills(hasText(skills) ? skills : user.getSkills()), user);
	}

	@GetMapping("/hobbies")
	public String employeesByHobbies(@RequestParam(required = false) String hobbies) {
		EmployeeEntity user = appSession.getCurrentUser();
		return processFurther(employeeRepo.findByHobbies(hasText(hobbies) ? hobbies : user.getHobbies()), user);
	}
	
	@GetMapping("/colleges")
	public String employeesByCollege(@RequestParam(required = false) String college) {
		EmployeeEntity user = appSession.getCurrentUser();
		return processFurther(employeeRepo.findByPostGradInstituteOrUnderGradCollege(user.getPostGradInstitute(), user.getUnderGradCollege()), user);
	}

	@GetMapping("/hometown")
	public String employeesByHometown(@RequestParam(required = false) String hometown) {
		EmployeeEntity user = appSession.getCurrentUser();
		return processFurther(employeeRepo.findByHometown(hasText(hometown) ? hometown : user.getHometown()), user);
	}
	
	private String processFurther(List<EmployeeEntity> employees, EmployeeEntity user) {
		employees = employees.stream().filter(e -> user.getId() != e.getId()).collect(toList());
		System.out.println(employees);
		if(employees.isEmpty()) {
			return "<h3 style='margin-left:40%; margin-top: 10%'> No matches Found</h3>";
		}
		return transformer.transformAsHTML(employees);
	}

}
