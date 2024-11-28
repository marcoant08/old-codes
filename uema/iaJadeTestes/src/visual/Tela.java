/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package visual;

import java.awt.Color;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author MarcoAntônio
 */
public class Tela extends JFrame {
    public Tela() throws IOException {
        setTitle("TelaTeste");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File("src\\imagens\\mapa.png")))));
        setLocationRelativeTo(null);
        setSize(819, 528);
        setBackground(Color.yellow);
        setVisible(true);
    }
    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        new Tela();
    }
}
