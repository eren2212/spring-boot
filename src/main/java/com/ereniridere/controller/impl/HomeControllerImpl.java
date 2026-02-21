package com.ereniridere.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ereniridere.controller.IHomeController;
import com.ereniridere.dto.DtoHome;
import com.ereniridere.services.impl.HomeServiceImpl;

@RestController
@RequestMapping("/rest/api/home")

public class HomeControllerImpl implements IHomeController {

	@Autowired
	private HomeServiceImpl homeService;

	@GetMapping(path = "/list/{id}")
	@Override
	public DtoHome findHomeById(@PathVariable(name = "id") Long id) {
		return homeService.findHomeById(id);
	}

}
