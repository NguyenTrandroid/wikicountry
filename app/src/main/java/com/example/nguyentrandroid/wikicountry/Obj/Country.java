package com.example.nguyentrandroid.wikicountry.Obj;

public class Country {
    private String name, alpha2Code, capital, region, population, callingCodes, timezones, nativeName, borders, languages, area, currencies;

    public Country(String name, String alpha2Code, String capital, String region, String population, String callingCodes, String timezones, String nativeName, String borders, String languages, String area, String currencies) {
        this.name = name;
        this.alpha2Code = alpha2Code;
        this.capital = capital;
        this.region = region;
        this.population = population;
        this.callingCodes = callingCodes;
        this.timezones = timezones;
        this.nativeName = nativeName;
        this.borders = borders;
        this.languages = languages;
        this.area = area;
        this.currencies = currencies;
    }

    public String getName() {
        return name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public String getCapital() {
        return capital;
    }

    public String getRegion() {
        return region;
    }

    public String getPopulation() {
        return population;
    }

    public String getCallingCodes() {
        return callingCodes;
    }

    public String getTimezones() {
        return timezones;
    }

    public String getNativeName() {
        return nativeName;
    }

    public String getBorders() {
        return borders;
    }

    public String getLanguages() {
        return languages;
    }

    public String getArea() {
        return area;
    }

    public String getCurrencies() {
        return currencies;
    }
}
