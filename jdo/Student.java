
import javax.persistence.Entity;

@Entity 
public class Student {
	
	private String name;
	private int rollNo;
	private int aggregate;
	
	public Student(){
	}
	
	Student(int roll, String name, int agg){
		this.name = name;
		rollNo = roll;
		aggregate = agg;
	}
	
	public int getRollNo(){
		return rollNo;
	}
	
	public int getAggregate(){
		return aggregate;
	}
	
	public String getName(){
		return name;
	}
	
	@Override
    public String toString() {
        return String.format("(Roll no: %d, Name: %s, Aggregate: %d)", this.rollNo, this.name,this.aggregate);
    }
}
