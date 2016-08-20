package br.pos.unipe.unipeJet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.pos.unipe.unipeJet.model.Pedido;
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
	
	@RequestMapping(value ="/novo",method = RequestMethod.POST)
	public ModelAndView salvar(Voo voo){
		voos.save(voo);
		
		return new ModelAndView("redirect:/voos/novo");
	}
	
	@RequestMapping("/listaVoo")
	public ModelAndView listarVoo(Pedido pedido){
		ModelAndView mv = new ModelAndView("/voo/lista");
		mv.addObject("voos", voos.findAll());
		mv.addObject("avioes", aeronaves.findAll());
		return mv;
	}
}
