package com.jeff4uraree;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PersonaController {

	@RequestMapping(value = "/persona", method = RequestMethod.GET)
	public ModelAndView persona() {
		return new ModelAndView("persona", "command", new Persona());
	}
	
	@RequestMapping(value = "/addPersona", method = RequestMethod.POST)
	public String addPersona (@ModelAttribute("PersonaWeb")Persona persona, 
			   ModelMap model) {
	      //model.addAttribute("persona1", persona.getPersona1());
	      //model.addAttribute("persona2", persona.getPersona2());
	      //model.addAttribute("persona3", persona.getPersona3());
	      
	      ApplicationContext context = 
					new ClassPathXmlApplicationContext("Beans.xml");
	      
	      DBInit dbinit = (DBInit) context.getBean("dbInit");
	      OutputPersona outputPersona1 = dbinit.findPersonaByName(persona.getPersona1());
	      OutputPersona outputPersona2 = dbinit.findPersonaByName(persona.getPersona2());
	      OutputPersona outcomePersona = dbinit.findPersonaFusionTwoWay(outputPersona1.getPersonaName(), outputPersona2.getPersonaName());
	      //OutputArcana outputArcana = dbinit.findOutputArcana(outputPersona1.getArcanaType(), outputPersona2.getArcanaType());
	      
	      
	      //model.addAttribute("outputPersonaName", outputPersona1.getPersonaName());
	      //model.addAttribute("outputPersonaArcana", outputArcana.getArcana());
	      //model.addAttribute("outputPersonaLevel", outputPersona1.getLevel());
	      
	      model.addAttribute("outputPersonaName", outcomePersona.getPersonaName());
	      model.addAttribute("outputPersonaArcana", outcomePersona.getArcanaType());
	      model.addAttribute("outputPersonaLevel", outcomePersona.getLevel());
	      
	      return "result";
	}

	
}
