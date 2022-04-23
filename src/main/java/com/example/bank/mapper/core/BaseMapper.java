package com.example.bank.mapper.core;

import com.example.bank.model.core.BaseEntity;
import com.example.bank.model.core.RequestDTO;
import com.example.bank.model.core.ResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.stream.Collectors;

public interface BaseMapper<E extends BaseEntity, I extends RequestDTO, O extends ResponseDTO> {

    E toEntity(I i);
    void toEntity(I i, E e);
    default List<E> toEntity(List<I> i) {
        return (List)i.stream().map(this::toEntity).collect(Collectors.toList());
    }

    O toDTO(E e);
    void toDTO(E e, O o);
    default List<O> toDTO(List<E> e) {
        return (List)e.stream().map(this::toDTO).collect(Collectors.toList());
    }

    default Page<O> toDTO(Page<E> e) {
        return e.map(this::toDTO);
    }

    default void setBaseField(O o, E e) {
        o.setId(e.getId());
        o.setCreated(e.getCreated());
        o.setCreatedById(e.getCreatedBy().getId());
        o.setCreatedByName(e.getCreatedBy().getFullName());
        o.setUpdated(e.getUpdated());
        o.setUpdatedById(e.getUpdatedBy().getId());
        o.setUpdatedByName(e.getUpdatedBy().getFullName());
        o.setFullTitle(e.getFullTitle());
        o.setActive(e.getActive());
    }
}
