package UIComponents;

import javax.swing.*;
import java.awt.event.ActionListener;

public class Button extends UIComponent {
    public Button() {
        super(new JButton());
    }

    public Button(String text) {
        super(new JButton(text));
    }

    public Button(String text, ActionListener listener) {
        this(text);
        this.addActionListener(listener);
    }

    public void setText(String text) {
        ((JButton) this.jComponent).setText(text);
    }

    public String getText() {
        return ((JButton) this.jComponent).getText();
    }

    public void addActionListener(ActionListener listener) {
        ((JButton) this.jComponent).addActionListener(listener);
    }

    public void removeActionListener(ActionListener listener) {
        ((JButton) this.jComponent).removeActionListener(listener);
    }
}
