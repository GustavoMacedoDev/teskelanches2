package br.com.macedo.sistemas.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.macedo.sistemas.dao.BebidaDao;
import br.com.macedo.sistemas.dao.LancamentoDao;
import br.com.macedo.sistemas.dao.LancheDao;
import br.com.macedo.sistemas.dao.MesaDao;
import br.com.macedo.sistemas.domain.Bebida;
import br.com.macedo.sistemas.domain.Lancamento;
import br.com.macedo.sistemas.domain.Lanche;


@Controller
@RequestMapping("lancamento")
public class LancamentoController {
	
	@Autowired
	private LancamentoDao daoLancamento;
	
	@Autowired
	private MesaDao daoMesa;
	
	@Autowired
	private LancheDao daoLanche;
	
	@Autowired
	private BebidaDao daoBebida;
	
	List<Lanche> lanchesLancados = new ArrayList<Lanche>();
	List<Bebida> bebidasLancadas = new ArrayList<Bebida>();
	
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("lancamento") Lancamento lancamento, BindingResult result,
			RedirectAttributes attr) {
		
		System.out.println(lancamento.getLanches());
		System.out.println(lancamento.getId());
		System.out.println("mesa" + lancamento.getMesa().getId());
		
		if(result.hasErrors()) {
			return new ModelAndView("/lcto/novo_lcto");
		}
		
		daoLancamento.salvar(lancamento);
		daoMesa.abreMesa(lancamento.getMesa().getId());
		attr.addFlashAttribute("message", "Lançamento salvo");
		return new ModelAndView("redirect:/mesa/todos");
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		Lancamento lancamento = daoLancamento.getId(id);
		
		lanchesLancados = daoLanche.getByLancamento(id);
		bebidasLancadas = daoBebida.getByLancamento(id);
		
		List<Lanche> lanchesNovos = daoLanche.getTodos();
		List<Bebida> bebidasNovas = daoBebida.getTodos();
			
		model.addAttribute("lancamento", lancamento);
		model.addAttribute("lanches", lanchesNovos);
		model.addAttribute("bebidas", bebidasNovas);
		
		
		model.addAttribute("lanchesLancados", lanchesLancados);
		model.addAttribute("bebidasLancados", bebidasLancadas);
		
		return new ModelAndView("/lcto/edita_lcto", model);
	}
	
	
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("lancamento") Lancamento lancamento, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return new ModelAndView("/lcto/edita_lcto");
		}
		
		daoLancamento.editar(lancamento);
		attr.addFlashAttribute("message", "Lanche alterado");
		return new ModelAndView("redirect:/mesa/todos");
	}
}
