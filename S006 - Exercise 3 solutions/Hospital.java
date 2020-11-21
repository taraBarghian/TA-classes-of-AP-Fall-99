
class Personnel {
	private String ID;
	private String name;
	protected int workingHours;

	public Personnel(String name) {
		this.name = name;
	}

	public Personnel(String name, int workingHours) {
		this(name);
		this.workingHours = workingHours;
	}

	public void setID(String ID) {
		String perviousID = this.ID;
		this.ID = ID;
		if (!Manager.addPersonnel(this)) {
			System.out.println("duplicate ID");
			this.ID = perviousID;
		}
	}

	public String getID() {
		return this.ID;
	}

	public String getName() {
		return this.name;
	}

	public void setWorkingHours(int workingHours) {
		this.workingHours = workingHours;
	}

	public int getWorkingHours() {
		return this.workingHours;
	}

	public int findSalary() {
		return this.workingHours * 40;
	}

	public String compareSalary(Personnel p) {
		int diff = this.findSalary() - p.findSalary();
		if (diff == 0) {
			return "equal";
		}
		return (diff > 0) ? "more" : "less";
	}
}

class Manager extends Personnel {
	private static Personnel[] personnels = new Personnel[1000];
	private static Personnel[] hiredPersonnels = new Personnel[1000];
	private static int personnelsCount = 0;
	private static int hiredPersonnelsCount = 0;

	public Manager(String name) {
		super(name);
	}

	public Manager(String name, int workingHours) {
		super(name, workingHours);
	}

	@Override
	public int findSalary() {
		return this.workingHours * 50;
	}

	public static boolean addPersonnel(Personnel p) {
		if (personnelExists(p.getID())) {
			return false;
		}
		personnels[personnelsCount++] = p;
		return true;
	}

	public static boolean personnelExists(String ID) {
		return indexOf(ID) != -1;
	}

	public static int indexOf(String ID) {
		for (int i = 0; i < personnels.length; i++) {
			if (personnels[i] == null) {
				break;
			}
			if (personnels[i].getID().equals(ID)) {
				return i;
			}
		}
		return -1;
	}
	
	public static int indexOfHired(String ID) {
		for (int i = 0; i < hiredPersonnels.length; i++) {
			if (hiredPersonnels[i] == null) {
				break;
			}
			if (hiredPersonnels[i].getID().equals(ID)) {
				return i;
			}
		}
		return -1;
	}

	public void hire(Personnel p) {
		hiredPersonnels[hiredPersonnelsCount++] = p;
	}

	public void fire(String ID) {
		int index = indexOf(ID);
		if (index == -1) {
			return;
		}
		for (int i = index; i < hiredPersonnels.length - 1; i++) {
			hiredPersonnels[i] = hiredPersonnels[i + 1];
		}
	}
}

class Doctor extends Personnel {
	public Doctor(String name) {
		super(name);
	}

	public Doctor(String name, int workingHours) {
		super(name, workingHours);
	}

	@Override
	public int findSalary() {
		return this.workingHours * 60;
	}
}

class Nurse extends Personnel {
	public Nurse(String name) {
		super(name);
	}

	public Nurse(String name, int workingHours) {
		super(name, workingHours);
	}

	@Override
	public int findSalary() {
		return this.workingHours * 50;
	}
}

class Worker extends Personnel {
	public Worker(String name) {
		super(name);
	}

	public Worker(String name, int workingHours) {
		super(name, workingHours);
	}

	@Override
	public int findSalary() {
		return this.workingHours * 30;
	}
}

class Surgeon extends Doctor {
	public int countOfSurgeries = 0;

	public Surgeon(String name) {
		super(name);
	}

	public Surgeon(String name, int workingHours) {
		super(name, workingHours);
	}

	@Override
	public int findSalary() {
		return (this.workingHours * 60) + (this.countOfSurgeries * 40);
	}
}

public class Hospital {
	public static void main(String[] args) {
		Manager m = new Manager("Ali Alavi", 200);
		Doctor d1 = new Doctor("Naghi Naghavi");
		d1.setID("1234");
		d1.workingHours = 220;
		System.out.println(d1.findSalary()); // 220 * 60 = 13200
		Doctor d2 = new Doctor("Taghi Taghavi");
		d2.setID("1234"); // duplicate ID
		m.hire(d1);
		m.fire(d1.getID());
		Surgeon s = new Surgeon("Vali Valavi");
		s.workingHours = 200;
		s.countOfSurgeries = 10;
		System.out.println(s.findSalary()); // (200 * 60) + (10 * 40) = 12400
	}
}
