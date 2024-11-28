/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visualizacao;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 *
 * @author MarcoAntônio
 */
public class Carro2 implements ActionListener{
    private int x, y, dx, dy;
    public ImageIcon carro2;
    private javax.swing.JLabel lb;
    public int cont = 0;

    public Carro2(){
        carro2 = new ImageIcon("src\\imagens\\carro2.png");
        
        Random rd = new Random();
        
        if(rd.nextInt(1) == 0){
            this.y = 270;
        }else{
            this.y = 310;
        }
        this.x = 850;
        
        Timer time = new Timer(10, this);
    }

    public JLabel getLb() {
        return lb;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.lb  = new javax.swing.JLabel();
        this.lb.setBounds(getX(), getY(), 55, 25);
        this.lb.setIcon(carro2);
        this.lb.setLocation(getX()-cont, getY());
        this.cont++;
    }
    
}
