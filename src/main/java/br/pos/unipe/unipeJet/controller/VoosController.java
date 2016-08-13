package br.pos.unipe.unipeJet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.pos.unipe.unipeJet.model.Voo;
import br.pos.unipe.unipeJet.repository.Aeronaves;
import br.pos.unipe.unipeJet.repository.Voos;

@Controller
@RequestMapping("/voos")
public class VoosController {
	
	@Autowired
	private Voos voos;
	
	@Autowired
	private Aeronaves aeronaves;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Voo voo){
		ModelAndView mv = new ModelAndView("/voo/novo");
		mv.addObject("avioes", aeronaves.findAll());
		return mv;
	}
}
