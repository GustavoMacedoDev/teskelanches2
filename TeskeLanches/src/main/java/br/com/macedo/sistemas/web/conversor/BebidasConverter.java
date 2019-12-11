package br.com.macedo.sistemas.web.conversor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.core.convert.converter.Converter;

import br.com.macedo.sistemas.domain.Bebida;

public class BebidasConverter implements Converter<String[], List<Bebida>>{

	@Override
	public List<Bebida> convert(String[] ids) {
		 List<Bebida> list = new ArrayList<Bebida>();  
	        for (String id : ids) {  
	            if (!id.equals("0")) {  
	                list.add(new Bebida(Long.parseLong(id)));  
	            }  
	        }  
	        return list;  
	
	}

}
