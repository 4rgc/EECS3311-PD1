package UIComponents;

import javax.swing.*;

public abstract class UIComponent {
    protected JComponent jComponent;
    protected UIComponent(JComponent component) {
        this.jComponent = component;
    }

    public JComponent getJComponent() {
        return jComponent;
    }
}
