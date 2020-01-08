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

import br.com.macedo.sistemas.dao.ProdutoDao;
import br.com.macedo.sistemas.domain.Produto;

@Controller
@RequestMapping("produto")
public class ProdutoController {
	
	@Autowired
	private ProdutoDao daoProduto;
	
	@RequestMapping(value = "/todos", method = RequestMethod.GET)
	public ModelAndView listaTodos(ModelMap model) {
		model.addAttribute("produtos", daoProduto.getTodos());
		
		return new ModelAndView("/produto/lista_produto", model);
	}

	
	@GetMapping("/cadastro")
	public String cadastro(@ModelAttribute("produto") Produto produto, ModelMap model) {
		return "/produto/add_produto";
		
		
	}
	
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView save(@Valid @ModelAttribute("produto") Produto produto, BindingResult result,  RedirectAttributes attr) {
		if(result.hasErrors()) {
			return new ModelAndView("/produto/add_produto");
		}
		
		
		daoProduto.salvar(produto);
		
		attr.addFlashAttribute("message", "Produto salvo");
		return new ModelAndView("redirect:/produto/todos");
	}
	
	@GetMapping("/update/{id}")
	public ModelAndView preUpdate(@PathVariable("id") Long id, ModelMap model) {
		
		Produto produto = daoProduto.getId(id);
		
		model.addAttribute("produto", produto);
		
		
		return new ModelAndView("/produto/add_produto", model);
	}
	
	@PostMapping("/update")
	public ModelAndView update(@Valid @ModelAttribute("produto") Produto produto, BindingResult result, RedirectAttributes attr) {
		if(result.hasErrors()) {
			return new ModelAndView("/produto/add_produto");
		}
		
		daoProduto.editar(produto);
		
		attr.addFlashAttribute("message", "Produto alterado");
		return new ModelAndView("redirect:/produto/todos");
	}
	
}
