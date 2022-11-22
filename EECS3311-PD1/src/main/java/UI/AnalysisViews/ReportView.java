package UI.AnalysisViews;

import Analyzer.AnalysisResult;

public class ReportView extends AnalysisView {

    public ReportView(AnalysisResult data) {
        super("Report", data);

        this.node = new Report(data);

        // TODO: use analysis type name
        ((Report)this.node).generateReport("Analysis Result");
    }

    @Override
    public void setData(AnalysisResult data) {
        super.setData(data);
        Report report = (Report) node;
        report.setResult(data);
    }

    @Override
    public void rerender() {
        Report report = (Report) node;
        // TODO: use analysis type name
        ((Report) node).generateReport("Analysis Result");
    }
}
