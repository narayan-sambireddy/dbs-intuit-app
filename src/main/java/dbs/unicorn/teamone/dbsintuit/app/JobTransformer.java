package dbs.unicorn.teamone.dbsintuit.app;

import static java.nio.file.Files.readAllBytes;
import static java.nio.file.Paths.get;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;

import dbs.unicorn.teamone.dbsintuit.app.entity.JobPostEntity;

@Component
public class JobTransformer {

	private static final String VERTICLE = "{VERTICLE}";
	private static final String DESIGNATION = "{DESIGNATION}";
	private static final String LOCATION = "{LOCATION}";
	
	private static final String DIV_PREFIX = "<div class='row'><div class='col-lg-1'></div>";
	private static final String DIV_SUFFIX = "</div><br />";
	
	private String jobCardHTML;
	
	@PostConstruct
	public void init() throws Exception {
		jobCardHTML = new String(readAllBytes(get(getClass().getClassLoader(). getResource("job-card.html").toURI())));
	}
	
	public String transformAsHTML(List<JobPostEntity> jobs) {
		StringBuilder html = new StringBuilder();
		
		for (int i = 0; i < jobs.size(); i++) {
			if(i == 0) {
				html.append(DIV_PREFIX);
			}else if( i > 0 && i % 3 == 0) {
				html.append(DIV_SUFFIX);
				html.append(DIV_PREFIX);
			}
			html.append(transformAsHTML(jobs.get(i)));
		}
		
		if(jobs.size() / 3 != 0) {
			html.append(DIV_SUFFIX);
		}
		
		return html.toString();
	}
	
	public String transformAsHTML(JobPostEntity job) {
		return jobCardHTML
						.replace(VERTICLE, job.getVerticle())
						.replace(DESIGNATION, job.getDesignation())
						.replace(LOCATION, job.getLocation());
	}
	
}
