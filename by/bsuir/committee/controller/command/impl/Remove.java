package by.bsuir.committee.controller.command.impl;

import by.bsuir.committee.controller.command.Command;
import by.bsuir.committee.entity.committee;
import by.bsuir.committee.service.ServiceFactory;
import by.bsuir.committee.service.userService;

public class Remove implements Command {

	@Override
	public String execute(String request, committee committee) {
		String response;
		
		ServiceFactory serviceFactory = ServiceFactory.getInstance();
		userService userService = (userService) serviceFactory.getUserService();
		
		String[] data = new String[3];
		
		data = request.split(" ");
		
		if(data.length == 2) {
			int id = Integer.parseInt(data[1]);
			if (userService.remove(id, committee)) {
				response = "Enrollee with ID" + id + " removed.";
			}
			else {
				response = "Enrollee with ID" +id + " not founded." ;
			}
			
		}
		else {
			response  = "Incorrect number of parameters.";
		}
		
		return response;
	}

}