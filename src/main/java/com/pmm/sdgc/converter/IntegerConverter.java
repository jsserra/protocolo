/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pmm.sdgc.converter;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 *
 * @author acg
 */
@Converter(autoApply = false)
public class IntegerConverter implements AttributeConverter<Integer, String> {

    @Override
    public String convertToDatabaseColumn(Integer valor) {
        System.out.println("Integer");
        System.out.println(valor);
        if (valor==null) return null;
        return valor.toString();
    }

    @Override
    public Integer convertToEntityAttribute(String valor) {
        if (valor==null) return null;
        if (valor.isEmpty()) return null;
        System.out.println("String");
        System.out.println(valor);
        try {
            return Integer.parseInt(valor);
        } catch (NumberFormatException numberFormatException) {
            return null;
        }
        
    }

}
