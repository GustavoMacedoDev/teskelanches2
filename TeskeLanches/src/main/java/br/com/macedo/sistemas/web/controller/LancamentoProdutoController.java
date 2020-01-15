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

import br.com.macedo.sistemas.dao.LancamentoProdutoDao;
import br.com.macedo.sistemas.domain.LancamentoProduto;

@Controller
@RequestMapping("lancamentoproduto")
public class LancamentoProdutoController {
	
	@Autowired
	private LancamentoProdutoDao daoLancamentoProduto;
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("lancamentoproduto") LancamentoProduto lancamentoProduto, BindingResult result,
			RedirectAttributes attr) {
		
		System.out.print(lancamentoProduto.getProduto());
		
		daoLancamentoProduto.salvar(lancamentoProduto);
		
		attr.addFlashAttribute("message", "Pedido salvo");
		return new ModelAndView("redirect:/mesa/todos");
	}
	

}
