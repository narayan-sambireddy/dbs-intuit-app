package dbs.unicorn.teamone.dbsintuit.app;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

import dbs.unicorn.teamone.dbsintuit.app.entity.EmployeeEntity;

@Component
@SessionScope
public class AppSession {

	private EmployeeEntity currentUser;

	public EmployeeEntity getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(EmployeeEntity currentUser) {
		this.currentUser = currentUser;
	}

}
