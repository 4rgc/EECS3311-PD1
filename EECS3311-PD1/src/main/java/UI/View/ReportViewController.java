package UI.View;

import Analyzer.AbstractAnalyzer;
import Analyzer.AnalysisResult;
import Analyzer.Co2VsEnergyUseVsAirPollution;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import org.example.WbApiModel;

import java.util.ArrayList;
import java.util.Map;

public class ReportViewController {
    public AnalysisResult result;
    public ArrayList<Map<String, Double>> data;
    @FXML
    public TextArea textAreaReport;
    private static final String INDENT = "\t\t";

    public ReportViewController(){}
    public ReportViewController(AnalysisResult result){
        this.result = result;
        this.data = result.getData();
    }
    public String generateReport(int startYear, int endYear, String AnalysisMethod){
        String[] Labels = result.getLabels();
        StringBuilder reportBuilder = new StringBuilder(AnalysisMethod + "\n");
        reportBuilder.append("==========================\n");

        for(int i=endYear; i>=startYear;i--){
            reportBuilder.append("Year " + i + ":\n");
            for(int j=0; j<Labels.length;j++){
                reportBuilder.append(INDENT+Labels[j] + " => " + this.data.get(j).get(Integer.toString(i)) + "\n");
            }
        }
        return reportBuilder.toString();
    }

    public void showReport(String report){
        textAreaReport.appendText(report);
    }

    public static void main(String[] args) throws WbApiModel.WbApiModelException {
        AbstractAnalyzer analyzer = new Co2VsEnergyUseVsAirPollution(
                "2015", "2021", "CAN"
        );
        AnalysisResult result = analyzer.recalculate(analyzer.getStartYear(), analyzer.getEndYear(), analyzer.getCountry());

        ReportViewController rp = new ReportViewController(result);
        String a = rp.generateReport(2015, 2021, analyzer.getClass().getSimpleName());
        System.out.println(a);
    }

    public void setResult(AnalysisResult result){
        this.result = result;
        this.data = result.getData();
    }

}




