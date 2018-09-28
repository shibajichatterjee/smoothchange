package com.rest.framework.mapper;

public abstract class AbstractMapper<DTO extends Object, BO extends Object> {

    public abstract BO mapDtoToEntity(DTO dto);
    public abstract DTO mapEntityToDto(BO bo);
}