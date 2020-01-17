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
import br.com.macedo.sistemas.dao.MesaDao;
import br.com.macedo.sistemas.domain.Lancamento;

@Controller
@RequestMapping("lancamento")
public class LancamentoController {
	
	@Autowired
	private LancamentoDao daoLancamento;
	
	@Autowired
	private MesaDao daoMesa;
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("lancamento") @Validated Lancamento lancamento, BindingResult result,
			RedirectAttributes attr) {
		
		
		daoLancamento.salvar(lancamento);
		daoMesa.abreMesa(lancamento.getMesa().getId());
		
		attr.addFlashAttribute("message", "Pedido salvo");
		return new ModelAndView("redirect:/mesa/todos");
	}
	

}
