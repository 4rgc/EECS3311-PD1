package GUI_SwingImplementation;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingPanel {
    public static void main(String[] args) {
        JFrame f=new JFrame();//creating instance of JFrame

        JMenuBar bar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem i1 = new JMenuItem("item1");
        JMenuItem i2 = new JMenuItem("item2");

        i2.addActionListener(new OnClick());
        menu.add(i1);
        menu.add(i2);
        bar.add(menu);

        f.setJMenuBar(bar);

        f.setSize(400,500);//400 width and 500 height
        f.setLayout(null);//using no layout managers
        f.setVisible(true);//making the frame visible
    }
}