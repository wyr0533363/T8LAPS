package sg.edu.iss.sa50.t8.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
@DiscriminatorValue("Staff")
public class Staff extends Employee{
<<<<<<< HEAD

	//Check & Edit by Bianca: add validation and mapping setting

	//managerid is the FK need to build mapping 
=======
	
>>>>>>> branch 'master' of https://github.com/Martindreamz/T8LAPS.git
	@ManyToOne  @JoinColumn(name="manager_id")
	private Manager manager;

	@OneToMany(mappedBy="staff") 
	private List<Leaves> leaves;

	public Staff() {}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}

	public Staff(String name, String email) {
		super(name,email);
	}
	//New constructors
	public Staff(String name, String email,Manager manager, Long annualLeaveDays, Long medicalLeaveDays) {
		super(name,email,annualLeaveDays,medicalLeaveDays);
		this.manager = manager;
	}


}
