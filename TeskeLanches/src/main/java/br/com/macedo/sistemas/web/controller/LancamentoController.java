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

import br.com.macedo.sistemas.dao.LancamentoDao;
import br.com.macedo.sistemas.domain.Lancamento;
import br.com.macedo.sistemas.domain.LancamentoProduto;

@Controller
@RequestMapping("lancamento")
public class LancamentoController {
	
	@Autowired
	private LancamentoDao daoLancamento;
	
	LancamentoProduto lancamentoProduto = new LancamentoProduto();
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("lancamento") @Validated Lancamento lancamento, BindingResult result,
			RedirectAttributes attr) {
		
		
		lancamentoProduto.setQuantidade(lancamento.getQuantidade());
		
		System.out.println(lancamentoProduto.getQuantidade());
		
		
		daoLancamento.salvar(lancamento);
		
		attr.addFlashAttribute("message", "Pedido salvo");
		return new ModelAndView("redirect:/mesa/todos");
	}
	

}
