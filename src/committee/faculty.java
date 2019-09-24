package committee;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class faculty {
	
	private List<enrollee> enrollees;  
	private String name;
	
	public faculty() {
	}
	
	public faculty(String name) {
		enrollees = new LinkedList<enrollee>();	
		
		setName(name);	
	}
	
   	public boolean AddToList(enrollee enrollee) {
   		if(enrollee != null)
   			return enrollees.add(enrollee);
   		else
   			return false;
   	}
   	
   	public boolean RemoveFromList(enrollee enrollee) {
   		if(enrollee != null)
   			return enrollees.remove(enrollee);
   		else
   			return false;
   	}
   	
   	public int Length() {
   		return enrollees.size();
   	}
   	
   	
   	public String[] GetEnrollies() {
   		String[] enrollies = new String[2000];
   		int listSize = 0;
   		
   		if(enrollees != null)
   			listSize = enrollees.size();
   		
   		
   		for (int i = 0; i < listSize; i++) {
			
   			enrollee tempEnrollee = null;
   			tempEnrollee = enrollees.get(i);
   			
   			enrollies[i] = tempEnrollee.getFirstName() + " " +
   							tempEnrollee.getMiddleName() + " " + 
   							tempEnrollee.getLastName() + " " +
   							tempEnrollee.getFacultyName() + " " +
   							tempEnrollee.getAddress();
		}   		
   		
   		
   		return enrollies;
   	}
   	
   	public enrollee GetEnrollee(int id) {
   		enrollee result = null;
   		enrollee tempEnrollee = null;
   		
   		int i = 0;
   		int listLength = enrollees.size();
   		
   		while (i < listLength && result == null) {
   			tempEnrollee = enrollees.get(i); 
   			if( tempEnrollee.getId() == id) {
   				result = tempEnrollee; 
   			}
   			i++;
   		}	
   		return result;
   	}
   	
   	
   	public void SortList() {
   		Collections.sort(this.enrollees);
   	}
   	
   	
   	public void ShowList() {
   		System.out.print("Список абитуриентов " + getName() + ": \n");
   		for (int i = 0; i < enrollees.size(); i++) {
			System.out.print(enrollees.get(i)+ "\n");
		}
   		System.out.print("\n");
   		
   	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
