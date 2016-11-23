package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class panelTransparente extends JPanel {

    private Image bgImage;

    public panelTransparente() {
        super();
        this.setOpaque(false);
    }

    public void setBackgroundImage(Image bgImage) {
        this.bgImage = bgImage;
    }

    @Override
    public void paint(Graphics g) {

        if (bgImage != null) {
            g.drawImage(bgImage, 0, 0, null);
        }
        super.paint(g);

    }
}
