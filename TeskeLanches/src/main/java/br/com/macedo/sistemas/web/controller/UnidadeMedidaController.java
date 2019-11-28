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

import br.com.macedo.sistemas.dao.UnidadeMedidaDao;
import br.com.macedo.sistemas.domain.UnidadeMedida;

@Controller
@RequestMapping("unidademedida")
public class UnidadeMedidaController {
	
	@Autowired
	private UnidadeMedidaDao dao;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("unidades", dao.getTodos());
		return new ModelAndView("/uni/lista_unidade", model);
	}

	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("unidade") UnidadeMedida medida, ModelMap model) {
		return "/uni/add_unidade";
	}
	
	@PostMapping("/save")
	public String save(@Valid @ModelAttribute("unidade") UnidadeMedida medida, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return "/uni/add_unidade";
		}
		dao.salvar(medida);
		attr.addFlashAttribute("message", "Unidade de Medida Salvo");
		return "redirect:/unidademedida/todos";
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		UnidadeMedida medida = dao.getId(id);
		model.addAttribute("unidade", medida);
		return new ModelAndView("/uni/add_unidade", model);
	}
	
	
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("unidade") UnidadeMedida medida, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return new ModelAndView("/uni/add_unidade");
		}
		dao.editar(medida);
		attr.addFlashAttribute("message", "Unidade alterada");
		return new ModelAndView("redirect:/unidademedida/todos");
	}
	
	@GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id, RedirectAttributes attr) {
        dao.excluir(id);
        attr.addFlashAttribute("message", "Unidade excluída com sucesso.");
        return "redirect:/unidademedida/todos";
    }   
}
