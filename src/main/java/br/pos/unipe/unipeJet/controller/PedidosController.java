package br.pos.unipe.unipeJet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.pos.unipe.unipeJet.model.Pedido;
import br.pos.unipe.unipeJet.repository.Pedidos;

@Controller
@RequestMapping("/pedido")
public class PedidosController {
	
	@Autowired
	private Pedidos pedidos;

	@RequestMapping(value = "/realizarCompra", method = RequestMethod.POST)
	public ModelAndView realizarPedido(Pedido pedido){
		pedido.setTotalMilhas(10);
		pedidos.save(pedido);
		SecurityContextHolder.getContext().getAuthentication().getName();
		ModelAndView mv = new ModelAndView("redirect:/voos/listaVoo");
		return mv;
	}
	public ModelAndView minhasCompras(){
		return null;
	}
}
