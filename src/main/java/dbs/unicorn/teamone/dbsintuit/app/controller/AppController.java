package dbs.unicorn.teamone.dbsintuit.app.controller;

import static java.util.stream.Collectors.toList;
import static org.springframework.util.StringUtils.hasText;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import dbs.unicorn.teamone.dbsintuit.app.AppSession;
import dbs.unicorn.teamone.dbsintuit.app.EmployeeTransformer;
import dbs.unicorn.teamone.dbsintuit.app.JobTransformer;
import dbs.unicorn.teamone.dbsintuit.app.entity.EmployeeEntity;
import dbs.unicorn.teamone.dbsintuit.app.entity.JobPostEntity;
import dbs.unicorn.teamone.dbsintuit.app.repo.EmployeeRepo;
import dbs.unicorn.teamone.dbsintuit.app.repo.JobPostRepo;

@RestController
public class AppController {

	@Autowired
	private EmployeeRepo employeeRepo;
	
	@Autowired
	private JobPostRepo jobPostRepo;

	@Autowired
	private AppSession appSession;

	@Autowired
	private EmployeeTransformer employeeTransformer;
	
	@Autowired
	private JobTransformer jobTransformer;

	private Map<String, Integer> ranks = new HashMap<>();
	
	@PostConstruct
	public void init() {
		ranks.put("Officer", 1);
		ranks.put("Senior Officer", 2);
		ranks.put("Analyst", 3);
		ranks.put("Associate", 4);
		ranks.put("Senior Associate", 5);	
	}
	
	@PostMapping("/login")
	public boolean isAuthenticated(String emailId, String password) {
		EmployeeEntity currentUser = employeeRepo.findByEmailId(emailId);
		appSession.setCurrentUser(currentUser);
		return null != currentUser && "secret".equals(password);
	}

	@GetMapping("/skills")
	public String employeesBySkill(@RequestParam(required = false) String skills) {
		EmployeeEntity user = appSession.getCurrentUser();
		return processEmpResults(employeeRepo.findBySkills(hasText(skills) ? skills : user.getSkills()), user);
	}

	@GetMapping("/hobbies")
	public String employeesByHobbies(@RequestParam(required = false) String hobbies) {
		EmployeeEntity user = appSession.getCurrentUser();
		return processEmpResults(employeeRepo.findByHobbies(hasText(hobbies) ? hobbies : user.getHobbies()), user);
	}
	
	@GetMapping("/colleges")
	public String employeesByCollege(@RequestParam(required = false) String college) {
		EmployeeEntity user = appSession.getCurrentUser();
		return processEmpResults(employeeRepo.findByPostGradInstituteOrUnderGradCollege(user.getPostGradInstitute(), user.getUnderGradCollege()), user);
	}

	@GetMapping("/hometown")
	public String employeesByHometown(@RequestParam(required = false) String hometown) {
		EmployeeEntity user = appSession.getCurrentUser();
		return processEmpResults(employeeRepo.findByHometown(hasText(hometown) ? hometown : user.getHometown()), user);
	}
	
	@GetMapping("/jobs")
	public String jobsByEmployee() {
		EmployeeEntity user = appSession.getCurrentUser();
		Integer rank =  ranks.get(user.getDesignation());
		List<JobPostEntity> jobs = jobPostRepo.findByRankIn( Arrays.asList(rank, rank + 1));
		return processJobResults(jobs);
	}
	
	private String processEmpResults(List<EmployeeEntity> employees, EmployeeEntity user) {
		employees = employees.stream().filter(e -> user.getId() != e.getId()).collect(toList());
		System.out.println(employees);
		if(employees.isEmpty()) {
			return "<h3 style='margin-left:40%; margin-top: 10%'> No matches Found</h3>";
		}
		return employeeTransformer.transformAsHTML(employees);
	}
	
	private String processJobResults(List<JobPostEntity> jobs) {
		System.out.println(jobs);
		if(jobs.isEmpty()) {
			return "<h3 style='margin-left:40%; margin-top: 10%'> No matches Found</h3>";
		}
		return jobTransformer.transformAsHTML(jobs);
	}

}
