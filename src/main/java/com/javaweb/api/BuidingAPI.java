package com.javaweb.api;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.validation.ValidationException;

import com.javaweb.model.BuidingDTO;
import com.javaweb.service.BuidingService;
import com.javaweb.service.imp.BuidingServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuidingAPI {
//       @GetMapping("/test")
//       public String testAPI() {
//             return "success";
//   }
	@Autowired
	private BuidingService buidingService;
//    private BuidingServiceImpl buidingServiceImpl = new BuidingServiceImpl();
	
	@GetMapping(value = "/api/building/")
	public  List<BuidingDTO> getBuilding(@RequestParam(name="name") String name) {
		
		List<BuidingDTO> listBuidingDTO = buidingService.findAll(name);

		return listBuidingDTO;
	}

	public void validate(BuidingDTO buidingDTO) throws ValidationException {
		if (buidingDTO.getName().equals("") || buidingDTO.getName() == null
				|| buidingDTO.getNumberOfBasement() == null) {
			throw new ValidationException("Name of NumberOfBasement is null");
		}
	}
    
	
//	@RequestMapping(value = "/api/building/", method = RequestMethod.POST)
//	public void getBuilding2(@RequestBody BuidingDTO buidingDTO) {
//		System.out.print("OK");
//	}
//
//	@RequestMapping(value = "/api/building/", method = RequestMethod.POST)
//	public BuidingDTO getBuilding3(@RequestBody BuidingDTO buidingDTOs) {
//		return buidingDTOs;
//	}
}

//@controller giúp chuyển 1 java class thông thường qua 1 resful API webservice
