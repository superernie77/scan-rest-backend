package com.se77.scan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.se77.scan.domain.ScanMessage;
import com.se77.scan.repo.ScanMessageRepository;

/**
 * Spring MVC-Controller class for the login and registration screen.
 */
@Controller
public class FrontendController {

	@Autowired
	private ScanMessageRepository repo;
	
    @RequestMapping(value="/", method = RequestMethod.GET)
    public ModelAndView init(){
        ModelAndView modelAndView = new ModelAndView();

        List<ScanMessage> messages = repo.findAll();

        modelAndView.addObject("scans", messages);

        modelAndView.setViewName("scanlist");

        return modelAndView;
    }

  
}