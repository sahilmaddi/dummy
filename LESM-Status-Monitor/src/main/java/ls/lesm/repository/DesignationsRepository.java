package ls.lesm.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ls.lesm.model.Designations;

public interface DesignationsRepository extends JpaRepository<Designations, Integer> {

	Designations findByDesgNames(String desgNames);

	

}
