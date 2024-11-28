/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import model.Animal;

/**
 *
 * @author MarcoAntônio
 */
@ManagedBean
@RequestScoped
public class ControllerProj implements Serializable{

    private Animal ani;
    
    public ControllerProj() {
        ani = new Animal();
    }

    public Animal getAni() {
        return ani;
    }

    public void setAni(Animal ani) {
        this.ani = ani;
    }
    
}
