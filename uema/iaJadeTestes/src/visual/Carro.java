/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Image;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;

/**
 *
 * @author MarcoAntônio
 */
public class Carro {
    private int x, y;
    private int dx, dy;
    private Image img;

    public Carro(){
        ImageIcon referencia = new ImageIcon("src\\imagens\\carro_horizontal.jpg");
        img = referencia.getImage();
        this.x = 100;
        this.y = 100;
    }
    
    public void andar(){
        x += dx;
        y += dy;
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImg() {
        return img;
    }
    
    public void keyPressed(KeyEvent tecla){
        int cod = tecla.getKeyCode();
        if(cod == KeyEvent.VK_LEFT){
            dx = -1;
        }
        if(cod == KeyEvent.VK_RIGHT){
            dx = 1;
        }
    }
    
    public void keyReleased(KeyEvent tecla){
        int cod = tecla.getKeyCode();
        if(cod == KeyEvent.VK_LEFT){
            dx = -1;
        }
        if(cod == KeyEvent.VK_RIGHT){
            dx = 1;
        }
    }
}
