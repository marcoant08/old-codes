
package visualizacao;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author MarcoAntônio, Well, Italo
 */
public class Carro1 {
    private int x, y, dx, dy;
    private Image imagem;

    public Carro1(){
        ImageIcon img = new ImageIcon("");
    }
    
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Image getImagem() {
        return imagem;
    }
}
