package com.Java.BootcampApi.javaApi;

import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import java.time.LocalDate;

public class Airport {
    @Length(min=3, max=25)
    private String name;
    @Length(min=3, max = 25)
    private String icao;
    @NotNull
    private String iata;
    private String city;
    private String state;
    private String country;
    private String elevation;
    private Number lat;
    private Number lon;
    private String tz;
    private LocalDate date = LocalDate.now();

    public Airport(String name, String icao, String iata, String city, String state, String country, String elevation, Number lat, Number lon, String tz, LocalDate date) {
        this.name = name;
        this.icao = icao;
        this.iata = iata;
        this.city = city;
        this.state = state;
        this.country = country;
        this.elevation = elevation;
        this.lat = lat;
        this.lon = lon;
        this.tz = tz;
        this.date = date;
    }

    public Airport() {
    }

}
