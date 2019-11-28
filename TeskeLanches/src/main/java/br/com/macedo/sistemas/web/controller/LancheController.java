package br.com.macedo.sistemas.web.controller;

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

import br.com.macedo.sistemas.dao.LancheDao;
import br.com.macedo.sistemas.domain.Lanche;


@Controller
@RequestMapping("lanche")
public class LancheController {
	
	@Autowired
	private LancheDao dao;

	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("lanches", dao.getTodos());
		return new ModelAndView("/lan/lista_lanche", model);
	}
	
	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("lanche") Lanche lanche, ModelMap model) {
		return "/lan/add_lanche";
	}
	
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("lanche") Lanche lanche, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/lan/add_lanche";
		}
		dao.salvar(lanche);
		attr.addFlashAttribute("message", "Lanche salvo");
		return "redirect:/lanche/todos";
	}
	
	
	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		Lanche lanche = dao.getId(id);
		model.addAttribute("lanche", lanche);
		return new ModelAndView("/lan/add_lanche", model);
	}
	
	
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("lanche") Lanche lanche, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return new ModelAndView("/lan/add_lanche");
		}
		dao.editar(lanche);
		attr.addFlashAttribute("message", "Lanche alterado");
		return new ModelAndView("redirect:/lanche/todos");
	}
	
	@GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
        dao.excluir(id);
        attr.addFlashAttribute("message", "Lanche excluído com sucesso.");
        return "redirect:/lanche/todos";
    }   
		
	
}
