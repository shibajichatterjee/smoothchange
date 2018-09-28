/*package com.rest.framework.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/masterAPI")
public class AbstractController {
	@Autowired

	@RequestMapping(value = "/getChangeType",method=RequestMethod.GET )

	public Map<String, String> getChangeType() {

		Map<String, String> typechange = new HashMap<>();
		typechange.put("SI", "System Implementation");
		typechange.put("OR", "Organizational Restructure");
		typechange.put("PL", "Product launch");
		typechange.put("MR", ", Merger and Restructure");
		return typechange;
	}
}
*/