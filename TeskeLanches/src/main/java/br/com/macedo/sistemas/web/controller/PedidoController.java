package br.com.macedo.sistemas.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.macedo.sistemas.dao.PedidoDao;
import br.com.macedo.sistemas.domain.Pedido;

@Controller
@RequestMapping("pedido")
public class PedidoController {
	
	@Autowired
	private PedidoDao daoPedido;
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("pedido") Pedido pedido, BindingResult result,
			RedirectAttributes attr) {
		
		
		daoPedido.salvar(pedido);
		attr.addFlashAttribute("message", "Pedido salvo");
		return new ModelAndView("redirect:/mesa/todos");
	}
	

}
