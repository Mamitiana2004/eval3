/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.model;

import java.math.BigDecimal;

import com.project.database.annotation.Column;
import com.project.database.annotation.Table;
import com.project.database.object.Entity;

/**
 *
 * @author mamit
 */
@Table("type_acte")
public class TypeActe extends Entity{
    
    @Column(pk=true,autoComplete = true)
    Integer id;
    
    @Column
    String type;
    
    @Column
    BigDecimal budget;

    @Column
    String code;
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
    
    

    public TypeActe() {
    }

    public TypeActe(Integer id) {
        this.id = id;
    }

    public TypeActe(Integer id, String type, BigDecimal budget, String code) {
        this.id = id;
        this.type = type;
        this.budget = budget;
        this.code = code;
    }

    public TypeActe(String type, BigDecimal budget, String code) {
        this.type = type;
        this.budget = budget;
        this.code = code;
    }

    
}
