package br.pos.unipe.unipeJet.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.pos.unipe.unipeJet.model.UserPermission;
import br.pos.unipe.unipeJet.model.Usuario;
import br.pos.unipe.unipeJet.repository.UserPermissions;
import br.pos.unipe.unipeJet.repository.Usuarios;
import br.pos.unipe.unipeJet.service.UsuarioService;

@Controller
@RequestMapping("/usuario")
public class UsuariosController {
		
	@Autowired
	private Usuarios usuarios;
	@Autowired
	private UsuarioService usuarioService;
	@Autowired
	private UserPermissions perm;
	
	@RequestMapping("/novo")
	public ModelAndView novo(Usuario usuario){
		return new ModelAndView("/user/novo");
	}
	
	@RequestMapping(value = "/novo", method = RequestMethod.POST)
	public ModelAndView salvar(Usuario usuario){
		usuarioService.salvar(usuario);
		UserPermission userPerm =  new UserPermission();
		userPerm.setRole("USER");
		userPerm.setUser_id(usuario.getUsername());
		perm.save(userPerm);
		return new ModelAndView("redirect:/usuario/novo");
	}
	@RequestMapping("/perfil/{id}")
	public ModelAndView perfil(@PathVariable("id") Usuario usuario){
		ModelAndView mv = new ModelAndView("/user/perfil");
		mv.addObject("dados", usuarios.findOne(usuario.getUsername()));
		return mv;
		
	}
	@RequestMapping("/perfil/deletar/{id}")
	public ModelAndView deletar(@PathVariable("id") Usuario usuario){
		usuarios.delete(usuario.getUsername());
		ModelAndView mv = new ModelAndView("redirect:/usuario/novo");

		return mv;
	}
	@RequestMapping("perfil/editar/{id}")
	public ModelAndView editar(@PathVariable("id") Usuario usuario){
		ModelAndView mv = new ModelAndView("/user/editar");
		mv.addObject("usuario", usuarios.findOne(usuario.getUsername()));
		
		return mv;
	}
	@RequestMapping(value = "perfil/editar/{id}", method = RequestMethod.POST)
	public ModelAndView atualizar(Usuario usuario){
		usuarios.save(usuario);
		return new ModelAndView("redirect:/usuario/novo");
		
	}
	
}
