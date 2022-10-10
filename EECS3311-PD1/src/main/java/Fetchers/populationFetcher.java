package Fetchers;

import org.example.*;

import java.util.*;


public class populationFetcher extends AbstractFetcher{
    public populationFetcher(String sYear, String eYear, String country){
        super(sYear, eYear, country);
        this.indicatorId = "SP.POP.TOTL";
    }

}
