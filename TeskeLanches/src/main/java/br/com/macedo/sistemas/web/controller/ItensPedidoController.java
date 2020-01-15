package br.com.macedo.sistemas.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.macedo.sistemas.dao.ItensPedidoDao;
import br.com.macedo.sistemas.domain.ItensPedido;

@Controller
@RequestMapping("itens")
public class ItensPedidoController {
	
	@Autowired
	private ItensPedidoDao daoItens;
	
	
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("itens") ItensPedido itensPedido, BindingResult result, RedirectAttributes attr) {
		
		
		daoItens.salvar(itensPedido);
		
		
		attr.addFlashAttribute("message", "Mesa salva");
		return "redirect:/mesa/todos";
	}

}
