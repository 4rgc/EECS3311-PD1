package Fetchers;

import org.example.WbApiModel;

import java.util.Map;
import java.util.Scanner;

public class FetchersCLI {
    public static void main(String argsp[]) throws WbApiModel.WbApiModelException {
        String country;
        String startYear;
        String endYear;
        int fetcherValue;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please select a country from it's corresponding country code:");
        System.out.println("Argentina\t\t\t\t\tARG");
        System.out.println("Brazil\t\t\t\t\t\tBRA");
        System.out.println("Canada\t\t\t\t\t\tCAN");
        System.out.println("China\t\t\t\t\t\tCHN");
        System.out.println("France\t\t\t\t\t\tFRA");
        System.out.println("India\t\t\t\t\t\tIND");
        System.out.println("Italy\t\t\t\t\t\tITA");
        System.out.println("Japan\t\t\t\t\t\tJPN");
        System.out.println("Mexico\t\t\t\t\t\tMEX");
        System.out.println("Portugal\t\t\t\t\tPRT");
        System.out.println("USA\t\t\t\t\t\t\tUSA");
        country = scanner.nextLine();

        System.out.println("Please specify a start year:");
        startYear = scanner.nextLine();

        System.out.println("Please specify an end year:");
        endYear = scanner.nextLine();

        System.out.println("Please select a fetcher from it's corresponding number:");
        System.out.println("Air Pollution Fetcher\t\t\t\t\t\t1");
        System.out.println("CO2 Fetcher\t\t\t\t\t\t\t\t\t2");
        System.out.println("Education Expenditure Fetcher\t\t\t\t3");
        System.out.println("Energy Use Fetcher\t\t\t\t\t\t\t4");
        System.out.println("Forest Area Fetcher\t\t\t\t\t\t\t5");
        System.out.println("GDP Fetcher\t\t\t\t\t\t\t\t\t6");
        System.out.println("Health Expenditure Fetcher\t\t\t\t\t7");
        System.out.println("Hospital Beds Fetcher\t\t\t\t\t\t8");
        System.out.println("Mortality Rate Fetcher\t\t\t\t\t\t9");
        System.out.println("Population Fetcher\t\t\t\t\t\t\t10");
        System.out.println("ProblemsIAHC Fetcher\t\t\t\t\t\t11");
        fetcherValue = scanner.nextInt();

        if(fetcherValue == 1){
            AirPollutionFetcher airPollution = new AirPollutionFetcher(startYear, endYear, country);
            dataToConsole(airPollution.getData(), startYear, endYear);
        }
        else if(fetcherValue == 2){
            CO2Fetcher c02 = new CO2Fetcher(startYear, endYear, country);
            dataToConsole(c02.getData(), startYear, endYear);
        }
        else if(fetcherValue == 3){
            EducationExpenditureFetcher educationExpenditure = new EducationExpenditureFetcher(startYear, endYear, country);
            dataToConsole(educationExpenditure.getData(), startYear, endYear);
        }
        else if(fetcherValue == 4){
            EnergyUseFetcher energyUseFetcher = new EnergyUseFetcher(startYear, endYear, country);
            dataToConsole(energyUseFetcher.getData(), startYear, endYear);
        }
        else if(fetcherValue == 5){
            ForestAreaFetcher forestAreaFetcher = new ForestAreaFetcher(startYear, endYear, country);
            dataToConsole(forestAreaFetcher.getData(), startYear, endYear);
        }
        else if(fetcherValue == 6){
            GDPFetcher gdp = new GDPFetcher(startYear, endYear, country);
            dataToConsole(gdp.getData(), startYear, endYear);
        }
        else if(fetcherValue == 7){
            HealthExpenditureFetcher healthExpenditure = new HealthExpenditureFetcher(startYear, endYear, country);
            dataToConsole(healthExpenditure.getData(), startYear, endYear);
        }
        else if(fetcherValue == 8){
            HospitalBedsFetcher hospitalBeds = new HospitalBedsFetcher(startYear, endYear, country);
            dataToConsole(hospitalBeds.getData(), startYear, endYear);
        }
        else if(fetcherValue == 9){
            MortalityRateFetcher mortalityRate = new MortalityRateFetcher(startYear, endYear, country);
            dataToConsole(mortalityRate.getData(), startYear, endYear);
        }
        else if(fetcherValue == 10){
            PopulationFetcher population = new PopulationFetcher(startYear, endYear, country);
            dataToConsole(population.getData(), startYear, endYear);
        }
        else if(fetcherValue == 11){
            ProblemsIAHCFetcher problemsIAHC = new ProblemsIAHCFetcher(startYear, endYear, country);
            dataToConsole(problemsIAHC.getData(), startYear, endYear);
        }
    }

    private static void dataToConsole(Map<String, Double> data, String startYear, String endYear) {
        int i = 0;
        int year = Integer.parseInt(startYear);
        while(i < data.size()){
            System.out.println("Year: " + (year + i) + ", Value: " + data.get(Integer.toString(year+i)));
            i++;
        }
    }
}