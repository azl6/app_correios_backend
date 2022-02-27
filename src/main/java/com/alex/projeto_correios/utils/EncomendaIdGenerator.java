package com.alex.projeto_correios.utils;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class EncomendaIdGenerator implements IdentifierGenerator {

    @Autowired
    private  CodeGenerator codeGenerator;

    @Override
    public Serializable generate(SharedSessionContractImplementor sharedSessionContractImplementor, Object o) throws HibernateException {
        return codeGenerator.newCode();
    }
}
