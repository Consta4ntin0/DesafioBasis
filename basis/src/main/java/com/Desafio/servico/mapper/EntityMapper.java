package com.Desafio.servico.mapper;

import java.util.List;

public interface EntityMapper<D, E> {

    E toEntity(D dto);

    D toDto(E entity);

    List <E> toEntity(List<D> dtolist);

    List <D> toDto(List<E> entitylist);

}