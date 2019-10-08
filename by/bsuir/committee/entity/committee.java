package by.bsuir.committee.entity;

import java.util.LinkedList;
import java.util.List;

import by.bsuir.committee.entity.enrollee;
import by.bsuir.committee.entity.faculty;
import by.bsuir.committee.parser.ParserFactory;
import by.bsuir.committee.parser.UserFileParser;

public class committee {

	private List<faculty> faculties;  

	public committee() {
   	}
	
	public committee(String fileName) {
		faculties = new LinkedList<faculty>();	
		
		faculties.add(new faculty("POIT"));
		faculties.add(new faculty("ITP"));
		
		ParserFactory parserFactory = ParserFactory.getInstance();
		UserFileParser fileParser = (UserFileParser)parserFactory.getUserParser();
		
		List<enrollee> enrolleeList = fileParser.getData(fileName);
		
		for (faculty faculty : faculties) {
			for(enrollee enrollee : enrolleeList) {
				if(faculty.getName().equals(enrollee.getFacultyName())) {
					faculty.AddToList(enrollee);
				}
			}
		}	
		
   	}
	
	public boolean AddEntollee(enrollee enrollee) {		

		boolean result = false;
		if(enrollee != null)
		{
			for (faculty faculty : faculties) {
				if(faculty.getName().equals(enrollee.getFacultyName())) {
					result = faculty.AddToList(enrollee);
				}
			}	
		}
		
		return result;
	}
   	
   	public boolean RemoveEnrollee(int id) {
   		enrollee tempEnrollee = null;
   		boolean result = false;
   	
   		if(id != 0)
   		{
   			for (faculty faculty : faculties) {
				if((tempEnrollee = faculty.GetEnrollee(id)) != null ) {
					result = faculty.RemoveFromList(tempEnrollee);
				}
			}	
   		}
   		
   		return result;
   	}
   	
   	
   	public boolean SortList(String facultyName) {
   		boolean result = false;
   		
   		for (faculty faculty : faculties) {
			if(faculty.getName().equals(facultyName) || facultyName.equals("all")) {
				faculty.SortList();
				result = true;
			}
		}
   		return result;
   	}
   	
   	public boolean ShowList(String facultyName) {
   		boolean result = false;
   		
		for (faculty faculty : faculties) {
			if(faculty.getName().equals(facultyName) || facultyName.equals("all")){
				faculty.ShowList();
				result = true;
			}
		}
   		return result;
   		
   	}
   	
   	public enrollee getEnrollee(int id) {
   		enrollee tempEnrollee = null;
   		enrollee result = null;
   		
   		if(id != 0)
   		{
   			for (faculty faculty : faculties) {
				if((tempEnrollee = faculty.GetEnrollee(id)) != null ) {
					result = tempEnrollee;
				}
			}	
   		}
   		
   		return result;
   	}
   	
   	public List<enrollee> getList() {
   		
   		List<enrollee> enrolleeList = new LinkedList<enrollee>();
   		
   		for (faculty faculty : faculties ) {
   			enrolleeList.addAll(faculty.getList());
   		}
   		
   		return enrolleeList;
   	}

   	
   	
}
