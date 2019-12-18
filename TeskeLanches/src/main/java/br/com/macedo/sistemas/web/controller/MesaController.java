package br.com.macedo.sistemas.web.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.macedo.sistemas.dao.BebidaDao;
import br.com.macedo.sistemas.dao.LancamentoDao;
import br.com.macedo.sistemas.dao.LancheDao;
import br.com.macedo.sistemas.dao.MesaDao;
import br.com.macedo.sistemas.domain.Bebida;
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
	
	@Autowired
	private BebidaDao daoBebida;
	
	@Autowired
	private LancamentoDao daoLancamento;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("mesa", daoMesa.getTodos());
		return new ModelAndView("/mesa/lista_mesa", model);
	}
	
	
	@RequestMapping(value = "/nova/{id}", method = RequestMethod.GET)
	public ModelAndView preSave(@ModelAttribute("lancamento") Lancamento lancamento, @PathVariable("id") Long id) {
		
		ModelAndView view = new ModelAndView("/lcto/novo_lcto");
		
		int consultaStatusMesa = daoMesa.getStatus(id);
		Mesa mesaNova = daoMesa.getId(id);
		List<Lanche> lanches = new ArrayList<Lanche>();
		List<Bebida> bebidas = new ArrayList<Bebida>();
		List<Lancamento> lancamentos  = new ArrayList<Lancamento>();
		
		if(consultaStatusMesa == 0) {
			
			
			lanches = daoLanche.getTodos();
			bebidas = daoBebida.getTodos();
			System.out.print(lanches);
			view.addObject("bebidas", bebidas);
			view.addObject("mesa", mesaNova);
			view.addObject("lanches", lanches);
			
			
		} else {
			view = new ModelAndView("/lcto/lista_mesa");
			lancamentos = daoLancamento.getByMesa(mesaNova.getId());
			
			for(Lancamento lan : lancamentos ) {
				lanches = lan.getLanches();
				bebidas = lan.getBebidas();
				
				view.addObject("lancamento", lan);
				
			}
			
			view.addObject("lanches", lanches);
			view.addObject("mesa", mesaNova.getNumero());
			view.addObject("bebidas", bebidas);
			
			
		}
		
		return view;
	}
}
