package br.com.macedo.sistemas.web.conversor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import br.com.macedo.sistemas.domain.Produto;

public class ProdutoConverter implements Converter<String[], List<Produto>>{

	
	public List<Produto> convert(String[] ids) {  
		
        List<Produto> list = new ArrayList<Produto>();  
        
        for (String id : ids) {  
            if (!id.equals("0")) {  
                list.add(new Produto(Long.parseLong(id)));  
                
            }  
        }  
        return list;  
    }  
	
}
