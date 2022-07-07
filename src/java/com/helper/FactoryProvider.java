/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.helper;

import com.entities.Note;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author HP
 */
public class FactoryProvider {
    private static SessionFactory factory;
    
    public static SessionFactory getFactory(){
        if(factory == null){
            factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Note.class).buildSessionFactory();
        }
        return factory;
    }
}
