package dbs.unicorn.teamone.dbsintuit.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dbs.unicorn.teamone.dbsintuit.app.entity.EmployerEntity;

@Repository
public interface EmployerRepo extends JpaRepository<EmployerEntity, Long> {

}
