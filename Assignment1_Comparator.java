package com.wiley.employee;
import java.util.*;

class work{
	int id;
	String city;
	int salary;
	work(int id,String city,int salary){
		this.id=id;
		this.city=city;
		this.salary=salary;
	}
}
public class Employee {
	
	public static void main(String[] args) {
		ArrayList<work> emp=new ArrayList<>();
                emp.add(new work(101,"Pune",1000));
                emp.add(new work(104,"Chennai",2000));
                emp.add(new work(103,"Delhi",1500));
                emp.add(new work(102,"Kolkatta",2500));
                
                
		
			Collections.sort(emp,new Sorted());
			for(Object m:emp) {
				work k=(work)m;
				System.out.println(k.id);
			}
			
	}

}
class Sorted implements Comparator{

	@Override
	public int compare(Object o1, Object o2) {
		work emp1=(work) o1;
		work emp2=(work) o2;
		int id1=emp1.id;
		int id2=emp2.id;
		if(id2>id1)
			return -1;
		else if(id2<id1)
			return 1;
		else {
			String name2 = emp2.city;
			String name1 = emp1.city;

			return name2.compareTo(name1);
		}
		
	}
	
}
