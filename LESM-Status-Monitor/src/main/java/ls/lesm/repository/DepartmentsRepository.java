package ls.lesm.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import ls.lesm.model.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments, Integer> {

	Departments findByDepart(String depart);

	Object findByDepartId(int departId);

}
