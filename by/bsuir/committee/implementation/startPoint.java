package by.bsuir.committee.implementation;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

import by.bsuir.committee.controller.Controller;
import by.bsuir.committee.entity.committee;


public class startPoint {
	
	public static void main(String[] args)
	{
		
		Controller controller = new Controller();
		String request = null;
		
		committee committee = null;
		
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter fileName for load committee: ");
        try {
        	request = r.readLine();
        	committee = new committee(request);
        	System.out.println(controller.executeTask("load " + request, committee));
        	
        	
        	while(!request.equals("exit"))
        	{
        		System.out.print("Enter command: ");
				
				request = r.readLine();
	
				System.out.println(controller.executeTask(request, committee));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		/*
		try {
		while(true)
		{
			System.out.print("Enter command: ");
			command = r.readLine();			
			parsedCommand = command.split(" ");
				
				
			// parsedCommand[0] - command
			if (parsedCommand.length > 0) {
				switch(parsedCommand[0]) {
					
				// for "load" parsedCommand[1] - fileName
				// command format: load 751004
				case "load":
					committee = new committee(parsedCommand[1] + ".txt");
					break;
				case "save":
					if(committee != null) {
						committee.Save();
						needSave = false;
					}
					else {
						System.out.println("To get started, upload or create a file with the load function.");
					}
					break;
				case "add":
					if(committee != null) {
						committee.AddEnrollee();
						needSave = true;
					}
					else {
						System.out.println("To get started, upload or create a file with the load function.");
					}
					break;
				case "remove":
					if(committee != null) {
						if(committee != null && parsedCommand.length > 1) {
							committee.RemoveEnrollee(Integer.parseInt(parsedCommand[1]));
							needSave = true;
						}
						else
							System.out.println("Remove command format: remove enrolleeID");
					}
					else {
						System.out.println("To get started, upload or create a file with the load function.");
					}
					break;
				case "edit":
					if(committee != null) {
						if(committee != null && parsedCommand.length > 1) {
							committee.EditEnrollee(Integer.parseInt(parsedCommand[1]));
							needSave = true;
						}
						else
							System.out.println("Edit command format: edit enrolleeID");
					}
					else {
						System.out.println("To get started, upload or create a file with the load function.");
					}
					break;
					
				// for "show" parsedCommand[1] - all | POIT | ITP
				// command format: show all | POIT | ITP
				case "show":
					if(committee != null) {
						if(committee != null && parsedCommand.length > 1) {
							if(parsedCommand[1].equals("all")) {
								committee.ShowAll();
							} 
							else {
								committee.ShowList(parsedCommand[1]);
							}
						}
						else
							System.out.println("Show command format: show (all | POIT | ITP)");
					}
					else {
						System.out.println("To get started, upload or create a file with the load function.");
					}
					break;
				case "sort":
					if(committee != null) {
						if(committee != null && parsedCommand.length > 1) {
								committee.SortList(parsedCommand[1]);
								needSave = true;
						}
						else {
							System.out.println("Sort command format: sort (all | POIT | ITP)");
						}
					}
					else {
						System.out.println("To get started, upload or create a file with the load function.");
					}
					break;
				case "exit":
					if(needSave)
					{
						String dataString = "";
						while (!dataString.equals("y") & !dataString.equals("n")) {
							System.out.print("Save changes? Enter y | n: ");
							r = new BufferedReader(new InputStreamReader(System.in));
						
							dataString = r.readLine();
						
							if(dataString.equals("y")) {
								committee.Save();
							}				
						}
					}
					return;	
				default :
					System.out.println(command + " is not command, executable program.");
					break;
				}
			}

		} 
		} catch (IOException e) {

		}	
*/
	}
	
}
