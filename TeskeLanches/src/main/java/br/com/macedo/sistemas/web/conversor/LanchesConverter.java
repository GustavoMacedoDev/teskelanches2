package br.com.macedo.sistemas.web.conversor;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;

import br.com.macedo.sistemas.dao.LancheDao;
import br.com.macedo.sistemas.domain.Lanche;

public class LanchesConverter implements Converter<String[], List<Lanche>> {
    
	@Autowired
    private LancheDao dao;
    
	public List<Lanche> convert(String[] ids) {  
        List<Lanche> list = new ArrayList<Lanche>();  
        for (String id : ids) {  
            if (!id.equals("0")) {  
                list.add(new Lanche(Long.parseLong(id)));  
            }  
        }  
        return list;  
    }  
 
} 