package UI;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Main extends Application {

    /*
        To use ReportViewController:

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/ReportView.fxml"));
        Parent pane = loader.load();
        this.reportViewController = loader.getController();
        AbstractAnalyzer analyzer = new Co2VsEnergyUseVsAirPollution(
                "2015", "2021", "CAN"
        );
        AnalysisResult result = analyzer.recalculate(analyzer.getStartYear(), analyzer.getEndYear(), analyzer.getCountry());
        this.reportViewController.setResult(result);
        String r = this.reportViewController.generateReport(2015, 2021, analyzer.getClass().getSimpleName());
        this.reportViewController.showReport(r);

     */
    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
