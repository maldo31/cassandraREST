package com.cassandra.api.model;


import java.time.LocalDate;
import java.util.Date;
import java.util.UUID;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;
import org.springframework.format.annotation.DateTimeFormat;
@Table("or_historical_wildfires")
public class Wildfire {
    @PrimaryKey
    private Integer id;
    @Column
    private String county;
    @Column
    private String district;
    @Column
    private String fire_name;
    @Column
    private Integer fire_year;
    @Column
    private String fuel_descr;
    @Column
    private String fuel_model;
    @Column
    private String general_cause;
    @Column
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate report_date;
    @Column
    private double total_acres;
    @Column
    private String unit;

    public Wildfire() {
    }

    public Wildfire(Integer id, String county, String district, String fire_name, Integer fire_year, String fuel_descr,
                    String fuel_model, String general_cause, LocalDate report_date, double total_acres, String unit) {
        this.id = id;
        this.county = county;
        this.district = district;
        this.fire_name = fire_name;
        this.fire_year = fire_year;
        this.fuel_descr = fuel_descr;
        this.fuel_model = fuel_model;
        this.general_cause = general_cause;
        this.report_date = report_date;
        this.total_acres = total_acres;
        this.unit = unit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCounty() {
        return county;
    }

    public void setCounty(String county) {
        this.county = county;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getFire_name() {
        return fire_name;
    }

    public void setFire_name(String fire_name) {
        this.fire_name = fire_name;
    }

    public Integer getFire_year() {
        return fire_year;
    }

    public void setFire_year(Integer fire_year) {
        this.fire_year = fire_year;
    }

    public String getFuel_descr() {
        return fuel_descr;
    }

    public void setFuel_descr(String fuel_descr) {
        this.fuel_descr = fuel_descr;
    }

    public String getFuel_model() {
        return fuel_model;
    }

    public void setFuel_model(String fuel_model) {
        this.fuel_model = fuel_model;
    }

    public String getGeneral_cause() {
        return general_cause;
    }

    public void setGeneral_cause(String general_cause) {
        this.general_cause = general_cause;
    }

    public LocalDate getReport_date() {
        return report_date;
    }

    public void setReport_date(LocalDate report_date) {
        this.report_date = report_date;
    }

    public double getTotal_acres() {
        return total_acres;
    }

    public void setTotal_acres(double total_acres) {
        this.total_acres = total_acres;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "wildfire{" +
                "id=" + id +
                ", county='" + county + '\'' +
                ", district='" + district + '\'' +
                ", fire_name='" + fire_name + '\'' +
                ", fire_year=" + fire_year +
                ", fuel_descr='" + fuel_descr + '\'' +
                ", fuel_model='" + fuel_model + '\'' +
                ", general_cause='" + general_cause + '\'' +
                ", report_date=" + report_date +
                ", total_acres=" + total_acres +
                ", unit='" + unit + '\'' +
                '}';
    }
}
