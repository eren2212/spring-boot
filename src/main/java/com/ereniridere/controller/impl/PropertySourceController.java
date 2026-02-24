package com.ereniridere.controller.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ereniridere.configruation.DataSource;
import com.ereniridere.configruation.GlobalProperties;
import com.ereniridere.configruation.Server;

@RestController
@RequestMapping("/rest/api/proprty")
public class PropertySourceController {

	@Autowired
	private GlobalProperties globalProperties;

	@GetMapping(path = "/datasource")
	public DataSource getDataSource() {

		return null;
	}

	@GetMapping(path = "/servers")
	public List<Server> getServers() {
		return globalProperties.getServers();
	}

}
