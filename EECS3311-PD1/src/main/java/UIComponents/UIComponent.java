package UIComponents;

import javax.swing.*;

public abstract class UIComponent {
    private final JComponent jComponent;
    protected UIComponent(JComponent component) {
        this.jComponent = component;
    }

    public JComponent getJComponent() {
        return jComponent;
    }
}
