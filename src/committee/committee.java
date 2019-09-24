package committee;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

import committee.enrollee;
import committee.faculty;

public class committee {

	private List<faculty> faculties;  
	private String fileName = "";
	
	public committee() {
   	}
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
   	// Конструктор приёмной комиссии
	public committee(String fileName) {
		faculties = new LinkedList<faculty>();	
		
		faculties.add(new faculty("POIT"));
		faculties.add(new faculty("ITP"));
		
		
		File file = new File(fileName);
		BufferedReader bufferedReader = null;
		String enrollies = "";
		
		
		try {
			if(!file.exists()) {
				file.createNewFile();
				System.out.println("File \"" + fileName  + "\" created.");
			}
			
			setFileName(fileName);
			
			bufferedReader = new BufferedReader(new FileReader(file));
		
			// Чтение абитуриентов из файла и добавление в списки факультетов
			while(bufferedReader.ready()) {
				enrollies = bufferedReader.readLine();
				AddEntollee(enrollies);
			}
			System.out.println("Commission filled.");
			
		}
		catch (IOException e) {
			System.out.println("Exception thrown: " + e);
		}
		finally {
			if(bufferedReader != null)
				try {
					bufferedReader.close();
				} catch (IOException e) {
					System.out.println("Exception thrown: " + e);
				}
		}
   	}
       
	
	public void Save() {
		File file = new File(this.fileName);
		BufferedWriter bufferedWriter = null;
		String[] data = new String[2000];
		
		
		try {
			bufferedWriter = new BufferedWriter(new FileWriter(file));
	   	
			String tempStr = "";
			int i = 0;
			int dataLength = 0;
			
			for (faculty faculty : faculties) {
				data = faculty.GetEnrollies();
				
				dataLength = data.length;
				i = 0;
			
				while(data[i] != null && i < dataLength) {
					tempStr = data[i++];
					bufferedWriter.write(tempStr);
					bufferedWriter.newLine();
				}
				
			}
			if (bufferedWriter != null)
				bufferedWriter.close();
			
		} catch (IOException e) {
		    System.out.println("Exception thrown: " + e);
		}

	}
	
	// Добавить абитуриента в список
   	public boolean AddEnrollee() {
   		BufferedReader r = null;
   		boolean result = false;
   		
		try {
			 r = new BufferedReader(new InputStreamReader(System.in));
		
			String dataString = "";
		
			String[] dataFML;
			String[] dataAddr;
			address addr;
		

			System.out.print("Enter first name, middle name, last name and faculty(POIT or ITP) separated by a \" \" ");
			dataString = r.readLine();	
			dataFML = dataString.split(" ");
		
			System.out.print("Enter a city, street and house separated by a \" \" ");
			dataString = r.readLine();
			dataAddr = dataString.split(" ");
		
		
			addr = new address(dataAddr);
		
			enrollee enrollee = new enrollee(dataFML, addr);		
			
			if(enrollee != null)
   			{
   				for (faculty faculty : faculties) {
   					if(faculty.getName().equals(enrollee.getFacultyName())) {
   						faculty.AddToList(enrollee);
   						System.out.println("Enrollee added.");
   						result = true;
   					}
   				}	
   			}
			return result;
			
		}
		catch (Exception e) { 
            System.out.println("Exception thrown: " + e);
            return result;
		}
		

   	}
   	
	public void AddEntollee(String enrolleeNote) {		
		String[] dataEnrollee;
		String[] dataFML = new String[4];
		String[] dataAddr = new String[3];
		address addr;
		
		dataEnrollee = enrolleeNote.split(" ");
		
		if (dataEnrollee.length != 7)
			throw new IllegalArgumentException("Wrong number of parameters in file.");
		
		
		dataFML[0] = dataEnrollee[0];
		dataFML[1] = dataEnrollee[1];
		dataFML[2] = dataEnrollee[2];
		dataFML[3] = dataEnrollee[3];
		
		dataAddr[0] = dataEnrollee[4]; 
		dataAddr[1] = dataEnrollee[5];
		dataAddr[2] = dataEnrollee[6];
		
		addr = new address(dataAddr);
		
		enrollee enrollee = new enrollee(dataFML, addr);		
		
		if(enrollee != null)
		{
			for (faculty faculty : faculties) {
				if(faculty.getName().equals(enrollee.getFacultyName())) {
					faculty.AddToList(enrollee);
				}
			}	
		}
		
	}
   	
   	// Удалить абитуриента из списка
   	public void RemoveEnrollee(int id) {
   		boolean result = false;
   		enrollee tempEnrollee = null;
   		
   		if(id != 0)
   		{
   			for (faculty faculty : faculties) {
				if((tempEnrollee = faculty.GetEnrollee(id)) != null ) {
					result = faculty.RemoveFromList(tempEnrollee);
					System.out.println("Enrollee removed.");
				}
			}	
   		}

   		if (result == false)
   			System.out.println("No such enrollee.");
   	}
   	
   	public void EditEnrollee(int id) {
   		boolean result = false;
   		enrollee tempEnrollee = null;
   		
   		if(id != 0)
   		{
   			for (faculty faculty : faculties) {
				if((tempEnrollee = faculty.GetEnrollee(id)) != null ) {
					
					System.out.println("Enter new data for: " + tempEnrollee);
					
					if(this.AddEnrollee() == true) {
						result = faculty.RemoveFromList(tempEnrollee);
					}
				}
			}	
   		}

   		if (result == false)
   			System.out.println("No such enrollee.");
   	}
   	
   	
   	public void SortList(String facultyName) {
		boolean result = false;
   		
   		for (faculty faculty : faculties) {
			if(faculty.getName().equals(facultyName) || facultyName.equals("all")) {
				faculty.SortList();
				result = true;
			}
		}	
   		
   		if(result == false)
   		{
   			System.out.println("No such faculty.");
   		}
   		
   	}
   	
   	public boolean ShowList(String facultyName) {
   		boolean result = false;
   		
		for (faculty faculty : faculties) {
			if(faculty.getName().equals(facultyName)) {
				faculty.ShowList();
				result = true;
			}
		}
		
   		if(result == false)
   		{
   			System.out.println("No such faculty.");
   		}
   		return result;
   		
   	}
   	
   	public void ShowAll() {
   		
		for (faculty faculty : faculties) {
				faculty.ShowList();
		}	
   		
   	}



   	
   	
}

/*

*/