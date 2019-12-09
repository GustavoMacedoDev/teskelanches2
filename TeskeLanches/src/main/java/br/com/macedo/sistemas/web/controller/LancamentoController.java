package br.com.macedo.sistemas.web.controller;

import javax.validation.Valid;

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


@Controller
@RequestMapping("lancamento")
public class LancamentoController {
	
	@Autowired
	private LancamentoDao dao;
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("lancamento") Lancamento lancamento, BindingResult result,
			RedirectAttributes attr) {
		
		System.out.println(lancamento.getLanches());
		System.out.println(lancamento.getId());
		System.out.println(lancamento.getMesa());
		
		if(result.hasErrors()) {
			return new ModelAndView("/lcto/novo_lcto");
		}
		
		dao.salvar(lancamento);
		attr.addFlashAttribute("message", "Lançamento salvo");
		return new ModelAndView("redirect:/mesa/todos");
	}
	
		
}
