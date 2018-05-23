package dbs.unicorn.teamone.dbsintuit.app.repo;

import java.util.Collection;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dbs.unicorn.teamone.dbsintuit.app.entity.JobPostEntity;

@Repository
public interface JobPostRepo extends JpaRepository<JobPostEntity, Long> {

	List<JobPostEntity> findByRankIn(Collection<Integer> rank);
}
