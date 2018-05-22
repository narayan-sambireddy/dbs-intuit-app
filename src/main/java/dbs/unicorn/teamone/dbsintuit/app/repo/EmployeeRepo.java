package dbs.unicorn.teamone.dbsintuit.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dbs.unicorn.teamone.dbsintuit.app.entity.EmployeeEntity;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, Long> {

	EmployeeEntity findByEmailId(String email);

}
