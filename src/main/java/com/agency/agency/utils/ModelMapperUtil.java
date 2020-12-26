package com.agency.agency.utils;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : agency
 * @author : Nazim Uddin Asif
 * @since : 12/25/2020, Fri
 **/
@Component
public class ModelMapperUtil {
    private ModelMapper modelMapper = new ModelMapper();

    public <S,D> D getRequestedDto(S s, Class<D> d ){
        return modelMapper.map(s, d);
    }

    public <D, T> List<D> getRequestedDtoList(final Collection<T> entityList, Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> map(entity, outCLass))
                .collect(Collectors.toList());
    }
    public  <D, T> D map(final T entity, Class<D> outClass) {
        return modelMapper.map(entity, outClass);
    }

}
