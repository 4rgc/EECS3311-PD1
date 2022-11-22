package UI;

import Analyzer.AnalysisResult;
import UI.AnalysisViews.AnalysisView;
import javafx.event.ActionEvent;
import javafx.event.EventType;

public class ChartGrid {

    public Grid grid;
    public String chartType;
    public String analysisType;

    public ChartGrid() {
        grid = new Grid();
    }

    public void addNode(AnalysisView analysisView) throws Exception {
        grid.addNode(analysisView.getNode());
    }

    public String getChartType(BottomMenuView bottomMenu) {
        return bottomMenu.getViewName();
    }
}
