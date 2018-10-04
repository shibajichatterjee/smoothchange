package com.rest.framework.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rest.framework.dao.DAO;
import com.rest.framework.mapper.AbstractMapper;
import com.rest.framework.service.Service;


@SuppressWarnings({ "rawtypes", "hiding" })
public abstract class AbstractService<IDAO extends DAO, 
									  DTO extends Object, 
									  MAP extends AbstractMapper,
									  BO extends Object> implements Service<DTO>{
    
    @Autowired
    protected IDAO dao;
   
    @Autowired
    protected MAP mapper;
   
    @Override
    @SuppressWarnings("unchecked")

	public Serializable create(DTO dto) {
    	try{
	    return dao.create(mapper.mapDtoToEntity(dto));
    }catch(Exception e)
    {
    	e.printStackTrace();
    }
    	return null;
}
    
    @Override
    public void createOrUpdate(DTO dto){
    	dao.createOrUpdate(mapper.mapDtoToEntity(dto));
    }
    
	@SuppressWarnings("unchecked")
	public DTO getById(Serializable id) {
		return (DTO) mapper.mapEntityToDto(dao.getById(id));
	}
	
	@SuppressWarnings("unchecked")
	public DTO load(Serializable id) {
		return (DTO) mapper.mapEntityToDto(dao.load(id));
	}
	
	@SuppressWarnings("unchecked")
	public List<DTO> getAll() {
		List<BO> boList = dao.getAll();
		List<DTO> dtoList = new ArrayList<DTO>();
		for(BO bo:boList) {
			dtoList.add((DTO) mapper.mapEntityToDto(bo));
		}
		return dtoList;
	}
	
	@SuppressWarnings("unchecked")

	public Serializable update(DTO dto) {
	   return (dao.update(mapper.mapDtoToEntity(dto)));

    }
	
	@SuppressWarnings("unchecked")
	public void delete(DTO dto) {
	    dao.delete(mapper.mapDtoToEntity(dto));
    }
	
	public void deleteById(Serializable id) {
		
		dao.deleteById(id);
		
	}
	
	public void deleteAll() {
		dao.deleteAll();	}
	
	
	public Long count() {
		return dao.count();
	}
	
	public boolean exists(Serializable id) {
		return dao.exists(id);
	}
	
	
}
