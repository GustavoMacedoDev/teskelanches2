package br.com.macedo.sistemas.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.macedo.sistemas.dao.LancamentoProdutoDao;
import br.com.macedo.sistemas.domain.LancamentoProduto;


@Controller
@RequestMapping("lancamentoProduto")
public class LancamentoProdutoController {
	
	@Autowired
	private LancamentoProdutoDao daoLancamento;
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("lancamentoProduto") @Validated LancamentoProduto lancamentoProduto, BindingResult result,
			RedirectAttributes attr) {
		
		
		daoLancamento.salvar(lancamentoProduto);
		
		
		attr.addFlashAttribute("message", "Pedido salvo");
		return new ModelAndView("redirect:/mesa/todos");
	}
	
	

}
