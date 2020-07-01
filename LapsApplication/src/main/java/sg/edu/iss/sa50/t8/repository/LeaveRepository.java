package sg.edu.iss.sa50.t8.repository;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.edu.iss.sa50.t8.model.LeaveStatus;
import sg.edu.iss.sa50.t8.model.Leaves;
import sg.edu.iss.sa50.t8.model.Staff;
@Primary
public interface LeaveRepository extends JpaRepository<Leaves, Integer>{

	@Query(value="SELECT * FROM Leaves",nativeQuery = true)
	List<Leaves> findAll();
	
	@Query(value="SELECT * FROM Leaves WHERE id=:leaveId",nativeQuery = true)
	Leaves findLeaveById(@Param("leaveId") int leaveId);
	
	@Query(value="SELECT Leave_Type FROM Leaves WHERE id=:leaveId",nativeQuery = true)
	String findLeaveTypeById(@Param("leaveId") int leaveId);
	
	@Query(value="SELECT l FROM Leaves l WHERE l.staff = :staff "
			+ "and l.status in (sg.edu.iss.sa50.t8.model.LeaveStatus.Applied,"
			 +"sg.edu.iss.sa50.t8.model.LeaveStatus.Updated)") 
	List<Leaves> findPendingleavesByStaff(@Param("staff") Staff Staff);
	
	@Query(value="SELECT l FROM Leaves l WHERE l.staff = :staff") 
	List<Leaves> findAllLeavesByStaff(@Param("staff") Staff Staff);
	
	@Modifying
	@Query(value="UPDATE Leaves SET status=?2 WHERE id=?1",nativeQuery = true)
	public void updateLeaveStatus(int leaveId,LeaveStatus status);
	
	
}
