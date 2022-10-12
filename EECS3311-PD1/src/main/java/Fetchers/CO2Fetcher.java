package Fetchers;

import org.example.*;

import java.util.*;


public class airPollutionFetcher extends AbstractFetcher{
    public airPollutionFetcher(String sYear, String eYear, String country){
        super(sYear, eYear, country);
        this.indicatorId = "EN.ATM.CO2E.PC";
    }

}