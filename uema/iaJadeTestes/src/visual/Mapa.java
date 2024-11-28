/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import jade.core.Timer;
import jade.core.TimerListener;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author MarcoAntônio
 */
public class Mapa extends JPanel implements ActionListener{
    private Image fundo;
    private Carro carro;
    private Timer timer;
    
    public Mapa(){
        ImageIcon referencia = new ImageIcon("src\\imagens\\carro_horizontal.jpg");
        fundo = referencia.getImage();
        carro = new Carro();
        timer = new Timer(5, (TimerListener) this);
    }
    
    @Override
    public void actionPerformed(ActionEvent arg0){
        carro.andar();
        repaint();
    }
}
