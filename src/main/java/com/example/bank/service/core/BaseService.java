package com.example.bank.service.core;

import com.example.bank.exception.BankException;
import com.example.bank.mapper.core.BaseMapper;
import com.example.bank.model.core.BaseEntity;
import com.example.bank.model.core.RequestDTO;
import com.example.bank.model.core.ResponseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public abstract class BaseService<E extends BaseEntity, I extends RequestDTO, O extends ResponseDTO> {

     private final BaseMapper<E, I, O> mapper;
    private final JpaRepository<E, Long> jpaRepository;

    protected BaseService(BaseMapper<E, I, O> mapper, JpaRepository<E, Long> jpaRepository) {
        this.mapper = mapper;
        this.jpaRepository = jpaRepository;
    }

    @Transactional
    public Long save(I i) {
        E e = mapper.toEntity(i);
        return jpaRepository.save(e).getId();
    }

    @Transactional
    public void update(Long id, I i) {

        Optional<E> optionalE = jpaRepository.findById(id);
        E e = optionalE.orElseThrow(() -> new BankException("اطلاعاتی جهت به روز رسانی یافت نشد!"));
        mapper.toEntity(i, e);
        jpaRepository.save(e);
    }

    @Transactional
    public Page<O> list(Pageable pageable) {
        Page<E> e = jpaRepository.findAll(pageable);
        return mapper.toDTO(e);
    }

    @Transactional
    public O showRow(Long id) {
        Optional<E> eOpt = jpaRepository.findById(id);
        E e = eOpt.orElseThrow(() -> new BankException("اطلاعاتی با شناسه مورد نظر یافت نشد!"));
        return mapper.toDTO(e);
    }
}
