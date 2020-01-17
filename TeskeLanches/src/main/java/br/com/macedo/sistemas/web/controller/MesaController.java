package br.com.macedo.sistemas.web.controller;

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

import br.com.macedo.sistemas.dao.LancamentoDao;
import br.com.macedo.sistemas.dao.MesaDao;
import br.com.macedo.sistemas.dao.ProdutoDao;
import br.com.macedo.sistemas.dao.QuantidadeDao;
import br.com.macedo.sistemas.domain.Lancamento;
import br.com.macedo.sistemas.domain.LancamentoProduto;
import br.com.macedo.sistemas.domain.Mesa;
import br.com.macedo.sistemas.domain.Produto;
import br.com.macedo.sistemas.domain.Produto.Categoria;
import br.com.macedo.sistemas.domain.Quantidade;

@Controller
@RequestMapping("mesa")
public class MesaController {
	
	@Autowired
	private MesaDao daoMesa;
	
	@Autowired
	private ProdutoDao daoProduto;
	
	@Autowired
	private LancamentoDao daoLancamento;
	
	@Autowired
	private QuantidadeDao daoQuantidade;
	
	private List<Produto> lanches;
	private List<Produto> bebidas;
	private List<Produto> porcaos;
	
	private List<Quantidade> quantidades;
	
	
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
		
		daoMesa.salvar(mesa);

		attr.addFlashAttribute("message", "Mesa salva");
		return "redirect:/mesa/todos";
	}
	
	@RequestMapping(value = "/nova/{id}", method = RequestMethod.GET)
	public ModelAndView preSave(@ModelAttribute("lancamentoProduto") LancamentoProduto lancamentoProduto, @PathVariable("id") Long id) {

		ModelMap map = new ModelMap();
		
		Mesa mesa = daoMesa.getId(id);
		
		Lancamento lancamento = new Lancamento();
		lancamento.setMesa(mesa);
		daoLancamento.salvar(lancamento);
		
		//lancamento = daoLancamento.getByMesa(id);
		
		lanches = daoProduto.getTodos();
		bebidas = daoProduto.getByCategoria(Categoria.BEBIDA);
		porcaos = daoProduto.getByCategoria(Categoria.PORCAO);
		
		quantidades = daoQuantidade.getTodos();
		
		map.addAttribute("mesa", mesa);
		map.addAttribute("lancamento", lancamento);
		map.addAttribute("produto", lanches);
		map.addAttribute("quantidade", quantidades);
		
		return new ModelAndView("/lcto/novo_lcto", map);
	
	}
}
