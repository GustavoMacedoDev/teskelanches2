package br.com.macedo.sistemas.web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.macedo.sistemas.dao.LancheDao;
import br.com.macedo.sistemas.dao.MesaDao;
import br.com.macedo.sistemas.domain.Lancamento;
import br.com.macedo.sistemas.domain.Lanche;
import br.com.macedo.sistemas.domain.Mesa;


@Controller
@RequestMapping("mesa")
public class MesaController {
	
	@Autowired
	private MesaDao daoMesa;
	
	@Autowired
	private LancheDao daoLanche;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("mesa", daoMesa.getTodos());
		return new ModelAndView("/mesa/lista_mesa", model);
	}
	
	
	@RequestMapping(value = "/nova/{id}", method = RequestMethod.GET)
	public ModelAndView preSave(@ModelAttribute("lancamento") @Validated Lancamento lancamento, @PathVariable("id") Long id) {
		ModelAndView view = new ModelAndView("/lcto/novo_lcto");
		Mesa mesa = daoMesa.getId(id);
		List<Lanche> lanches = daoLanche.getTodos();
		
		view.addObject("mesa", mesa);
		view.addObject("lanches", lanches);
		
		return view;
	}
}
