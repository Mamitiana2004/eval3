/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.project.database.object;

import com.project.database.util.Generic;
import java.util.ArrayList;

/**
 *
 * @author mamit
 */
public class View extends Entity{
    
    public ArrayList getAll() throws Exception{
        Generic dao=new Generic();
        return dao.get(this);
    }
    
    public ArrayList get(String... columnNames) throws Exception{
        Generic dao=new Generic();
        return dao.get(this,columnNames);
    }
    
    public ArrayList get(String columnNames,int operation) throws Exception{
        Generic dao=new Generic();
        return dao.get(this,columnNames,operation);
    }
    
    
}
