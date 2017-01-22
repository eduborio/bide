package br.com.bide.controllers;

import javax.inject.Inject;

import br.com.bide.domain.attributetypes.AttributeType;
import br.com.caelum.vraptor.Controller;
import br.com.caelum.vraptor.Result;

@Controller
public class EntitiesController {
	
	@Inject
	private Result result;

	public void entity(){
		result.include("attributeTypes", AttributeType.values());
	}
	
}
