package dbs.unicorn.teamone.dbsintuit.app;

import java.util.List;

import org.springframework.stereotype.Component;

import dbs.unicorn.teamone.dbsintuit.app.entity.JobPostEntity;

@Component
public class JobTransformer {

	private static final String VERTICLE = "{VERTICLE}";
	private static final String DESIGNATION = "{DESIGNATION}";
	private static final String LOCATION = "{LOCATION}";
	
	private static final String DIV_PREFIX = "<div class='row'><div class='col-lg-1'></div>";
	private static final String DIV_SUFFIX = "</div><br />";
	
	private static final String JOB_CARD_HTML = "<div class=\"col-lg-3 card\" style=\"margin-right: 20px\"><img src=\"images/job_logo.jpg\" alt=\"Avatar\" style=\"width: 100%\"><div class=\"container\"><h4 align=\"center\"><br /> <b>{VERTICLE}</b></h4><p align=\"center\">{DESIGNATION}</p><p align=\"center\">{LOCATION}</p></div></div>";
	
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
		return JOB_CARD_HTML
						.replace(VERTICLE, job.getVerticle())
						.replace(DESIGNATION, job.getDesignation())
						.replace(LOCATION, job.getLocation());
	}
	
}
