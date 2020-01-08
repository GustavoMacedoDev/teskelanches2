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

import br.com.macedo.sistemas.dao.MesaDao;
import br.com.macedo.sistemas.domain.Mesa;
import br.com.macedo.sistemas.domain.Pedido;
import br.com.macedo.sistemas.domain.Produto;

@Controller
@RequestMapping("mesa")
public class MesaController {
	
	@Autowired
	private MesaDao daoMesa;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("mesas", daoMesa.getTodos());
		return new ModelAndView("/mesa/lista_mesa", model);
	}

	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("mesa") Mesa mesa, ModelMap model) {
		return "/mesa/add_mesa";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("mesa") Mesa mesa, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/mesa/add_mesa";
		}
		
		System.out.print(mesa);
		daoMesa.salvar(mesa);

		attr.addFlashAttribute("message", "Mesa salva");
		return "redirect:/mesa/todos";
	}
	
	@RequestMapping(value = "/nova/{id}", method = RequestMethod.GET)
	public ModelAndView preSave(@ModelAttribute("pedido") Pedido pedido, @PathVariable("id") Long id) {
		
		ModelAndView view = new ModelAndView("/lcto/novo_lcto");
		
		int consultaStatusMesa = daoMesa.getStatus(id);
		Mesa mesaNova = daoMesa.getId(id);
		List<Produto> lanches = new ArrayList<Produto>();
		
		
		if(consultaStatusMesa == 0) {
			
			view.addObject("mesa", mesaNova);
			view.addObject("lanches", lanches);
			
			
		} else {
			/*view = new ModelAndView("/lcto/edita_mesa");
			lancamentos = daoLancamento.getByMesa(mesaNova.getId());
			
			for(Lancamento lan : lancamentos ) {
				lanches = lan.getLanches();
				bebidas = lan.getBebidas();
			}*/
			
			view.addObject("lanches", lanches);
			view.addObject("mesa", mesaNova.getNumero());
			
		}
		
		return view;
	}
	
}
