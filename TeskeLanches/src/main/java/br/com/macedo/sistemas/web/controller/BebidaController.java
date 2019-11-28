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

import br.com.macedo.sistemas.dao.BebidaDao;
import br.com.macedo.sistemas.domain.Bebida;

@Controller
@RequestMapping("bebida")
public class BebidaController {
	
	@Autowired
	private BebidaDao dao;
	
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("bebidas", dao.getTodos());
		return new ModelAndView("/beb/lista_bebidas", model);
	}
	
	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("bebida") Bebida bebida, ModelMap model) {
		return "/beb/add_bebida";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("bebida") Bebida bebida, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/beb/add_bebida";
		}
		dao.salvar(bebida);
		attr.addFlashAttribute("message", "Bebida salva");
		return "redirect:/bebida/todos";
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		Bebida bebida = dao.getId(id);
		model.addAttribute("bebida", bebida);
		return new ModelAndView("/beb/add_bebida", model);
	}
	
	
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("bebida") Bebida bebida, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return new ModelAndView("/beb/add_bebida");
		}
		dao.editar(bebida);
		attr.addFlashAttribute("message", "Bebida alterada");
		return new ModelAndView("redirect:/bebida/todos");
	}
	
	@GetMapping("/inativa/{id}")
    public String inativa(@PathVariable("id") Long id, RedirectAttributes attr) {
        dao.inativa(id);
        attr.addFlashAttribute("message", "Bebida inativada com sucesso.");
        return "redirect:/bebida/todos";
    }   
	
}



