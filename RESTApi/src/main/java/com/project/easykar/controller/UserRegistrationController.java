/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.easykar.controller;

import com.google.gson.JsonObject;
import com.project.easykar.model.registration.EmptyJsonResponse;
import com.project.easykar.model.registration.FailLoginResponse;
import com.project.easykar.model.registration.FailRegistrationResponse;
import com.project.easykar.model.registration.LoginResponse;
import com.project.easykar.model.registration.RegistrationResponse;
import com.project.easykar.model.registration.UserLogin;
import com.project.easykar.model.registration.Users;
import com.project.easykar.service.UserService;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author manoj
 */
@RestController
@RequestMapping("/users")
public class UserRegistrationController {
   
	@Autowired
	UserService userService;

	@RequestMapping(value = "/registeration", method = RequestMethod.POST, produces={"application/json","application/xml"}, consumes={"application/json","application/xml"})
	public ResponseEntity<?> addEmployee(@RequestBody Users employee) {
//		HttpHeaders headers = new HttpHeaders();
//                headers.add("Content-Type", "application/json");   
                RegistrationResponse regRes = new RegistrationResponse();
                FailRegistrationResponse failregRes = new FailRegistrationResponse();
                Users getEmployee = userService.findByEmail(employee.getEmail());
                if(getEmployee == null)
                {
                    boolean isSave = userService.save(employee);
                    if(isSave)
                    {
                        regRes.setResponse_code("1");
                        regRes.setResponse_msg("User has been created successfully");
                        regRes.setRegistration_result(employee);
                        return new ResponseEntity<RegistrationResponse>(regRes, HttpStatus.CREATED);
                    }
                    else
                    {
                        failregRes.setResponse_code("2");
                        failregRes.setResponse_msg("User allready exist");
                        failregRes.setRegistration_result(new EmptyJsonResponse());
                        return new ResponseEntity<FailRegistrationResponse>(failregRes, HttpStatus.CREATED);
                    }
                }
                else{
                    failregRes.setResponse_code("2");
                    failregRes.setResponse_msg("User allready exist");
                    failregRes.setRegistration_result(new EmptyJsonResponse());
                    return new ResponseEntity<FailRegistrationResponse>(failregRes, HttpStatus.CREATED);
                }
                
		
	}


	@RequestMapping(method = RequestMethod.PUT)
	public ResponseEntity<Void> updateEmployee(@RequestBody Users employee) {
		Users existingEmp = userService.getById(employee.getId());
		if (existingEmp == null) {
                    return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
                    userService.save(employee);
                    return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Users> getEmployee(@PathVariable("id") Long id) {
		Users employee = userService.getById(id);
		if (employee == null) {
                    return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Users>(employee, HttpStatus.OK);
	}
        
        @RequestMapping(value = "/login", method = RequestMethod.POST, produces="application/json", consumes="application/json")
	public ResponseEntity<?> getOneEmployee(@RequestBody UserLogin user) {
            FailLoginResponse failLoginRes = new FailLoginResponse();
//            HttpHeaders headers = new HttpHeaders();
//            headers.add("Content-Type", "application/json"); 
            Users employee = userService.findByEmail(user.getEmail());
            LoginResponse loginRes = new LoginResponse();
            if (employee != null) {
                if(employee.getPassword().equals(user.getPassword())){
                    loginRes.setResponse_code("1");
                    loginRes.setResponse_msg("Loged in successfully");
                    loginRes.setLogin_result(employee);
                    return new ResponseEntity<LoginResponse>(loginRes, HttpStatus.OK);
                }else{
                    failLoginRes.setResponse_code("0");
                    failLoginRes.setResponse_msg("Please check username and password");
                    failLoginRes.setLogin_result(new EmptyJsonResponse());
                    return new ResponseEntity<FailLoginResponse>(failLoginRes, HttpStatus.OK);
                }
                
            }
            else{
                failLoginRes.setResponse_code("0");
                failLoginRes.setResponse_msg("Please check username and password");
                failLoginRes.setLogin_result(new EmptyJsonResponse());
                return new ResponseEntity<FailLoginResponse>(failLoginRes, HttpStatus.OK);
            }
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Users>> getAllEmployees() {
		List<Users> employees = userService.getAll();
		if (employees.isEmpty()) {
                    return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(employees, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Long id) {
		Users employee = userService.getById(id);
		if (employee == null) {
	//		logger.debug("Employee with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.delete(id);
	//		logger.debug("Employee with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
