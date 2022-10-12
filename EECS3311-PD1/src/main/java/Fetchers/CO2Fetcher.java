package Fetchers;

import org.example.*;

import java.util.*;


public class CO2Fetcher extends AbstractFetcher{
    public CO2Fetcher(String sYear, String eYear, String country){
        super(sYear, eYear, country);
        this.indicatorId = "EN.ATM.CO2E.PC";
    }

}