package UIComponents;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import javax.swing.*;

public class UIComponentTest {
    final private JComponent mockJComponent = new JComponent() {
        @Override
        public String getUIClassID() {
            return "fake";
        }
    };

    private class SpecificComponent extends UIComponent {
        public SpecificComponent() {
            this.jComponent = mockJComponent;
        }
    }


    @Test
    public void ReturnsComponentTest() {
        SpecificComponent component = new SpecificComponent();

        assertEquals(mockJComponent, component.getJComponent());
        assertEquals("fake", component.getJComponent().getUIClassID());
    }
}
