package br.pos.unipe.unipeJet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.pos.unipe.unipeJet.model.Aeronave;
import br.pos.unipe.unipeJet.repository.Aeronaves;

@Controller
@RequestMapping("/aeronaves")
public class AeronavesController {

	@Autowired
	private Aeronaves aeronaves;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Aeronave aeronave){
		ModelAndView mv = new ModelAndView("/aeronaves/novo");
		
		return mv;
	}
	
	@RequestMapping(value="/novo", method = RequestMethod.POST)
	public ModelAndView salvar(Aeronave aeronave){
		
		aeronaves.save(aeronave);
		
		return new ModelAndView("redirect:/aeronaves/novo");
	}
}
