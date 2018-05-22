package dbs.unicorn.teamone.dbsintuit.app;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.util.List;
import java.util.Objects;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import dbs.unicorn.teamone.dbsintuit.app.entity.EmployeeEntity;

@Component
public class EmployeeTransformer {

	private static final String FULL_NAME_1 = "{FULL_NAME_1}";
	private static final String FULL_NAME_2 = "{FULL_NAME_2}";
	private static final String DESIGNATION = "{DESIGNATION}";
	private static final String HOMETOWN = "{HOMETOWN}";
	private static final String SKILLS = "{SKILLS}";
	private static final String HOBBIES = "{HOBBIES}";
	private static final String UGRAD = "{UGRAD}";
	private static final String UGRADY = "{UGRADY}";
	private static final String PGRAD = "{PGRAD}";
	private static final String PGRADY = "{PGRADY}";

	private String employeeCardHTML;

	@PostConstruct
	public void init() throws Exception {
		employeeCardHTML = new String(readAllBytes(get(getClass().getClassLoader(). getResource("employee-card.html").toURI())));
	}

	public String transformAsHTML(List<EmployeeEntity> employees) {
		StringBuilder html = new StringBuilder();
		employees.forEach(employee -> html.append(transformAsHTML(employee)));
		return html.toString();
	}
	
	public String transformAsHTML(EmployeeEntity employee) {
		return employeeCardHTML
			.replace(FULL_NAME_1, employee.getFullName())
			.replace(FULL_NAME_2, employee.getFullName())
			.replace(DESIGNATION, Objects.toString(employee.getDesignation(), "-NA-"))
			.replace(HOMETOWN, employee.getHometown())
			.replace(SKILLS, employee.getSkills())
			.replace(HOBBIES, employee.getHobbies())
			.replace(UGRAD, employee.getUnderGradCollege())
			.replace(UGRADY, employee.getUnderGradPassingYear().toString())
			.replace(PGRAD, employee.getPostGradInstitute())
			.replace(PGRADY, employee.getPostGradPassingYear().toString());
	}
}
