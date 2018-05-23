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

	private static final String EMP_CARD_HTML = "<div class=\"col-xs-12 col-sm-6 col-md-4\"><div class=\"image-flip\" ontouchstart=\"this.classList.toggle('hover');\"><div class=\"mainflip\"><div class=\"frontside\"><div class=\"card\"><div class=\"card-body text-center\"><p><img class=\" img-fluid\" src=\"images/mprofile.png\" alt=\"card image\"></p><h4 class=\"card-title\">{FULL_NAME_1}</h4><p class=\"card-text\">{DESIGNATION}</p></div></div></div><div class=\"backside\"><div class=\"card\"><div class=\"card-body text-center mt-4\"><h4 class=\"card-title\">{FULL_NAME_2}</h4><div class=\"card-text\"><table><tr><td>Designation</td><td>:</td><td>{DESIGNATION}</td>	</tr><tr><td>Skills</td><td>:</td><td>{SKILLS}</td>	</tr><tr><td>Hobbies</td><td>:</td><td>{HOBBIES}</td>	</tr><tr><td>UG</td><td>:</td><td>{UGRAD} ({UGRADY})</td></tr><tr><td>PG</td><td>:</td><td>{PGRAD} ({PGRADY})</td></tr><tr><td>Hometown</td><td>:</td><td>{HOMETOWN}</td>	</tr></table></div></div></div></div></div></div></div>";

	public String transformAsHTML(List<EmployeeEntity> employees) {
		StringBuilder html = new StringBuilder();
		employees.forEach(employee -> html.append(transformAsHTML(employee)));
		return html.toString();
	}
	
	public String transformAsHTML(EmployeeEntity employee) {
		return EMP_CARD_HTML
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
