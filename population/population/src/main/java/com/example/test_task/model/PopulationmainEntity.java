package com.example.test_task.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "populationmain", schema = "public", catalog = "population")
public class PopulationmainEntity {
    private String city;
    private String cityAscii;
    private String lat;
    private String lng;
    private String country;
    private String iso2;
    private String iso3;
    private String adminName;
    private String capital;
    private String popNumber;
    private String ownId;
    private int id;

    @Basic
    @Column(name = "city", nullable = true, length = 255)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Basic
    @Column(name = "city_ascii", nullable = true, length = 255)
    public String getCityAscii() {
        return cityAscii;
    }

    public void setCityAscii(String cityAscii) {
        this.cityAscii = cityAscii;
    }

    @Basic
    @Column(name = "lat", nullable = true, length = 255)
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    @Basic
    @Column(name = "lng", nullable = true, length = 255)
    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    @Basic
    @Column(name = "country", nullable = true, length = 255)
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name = "iso2", nullable = true, length = 255)
    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }

    @Basic
    @Column(name = "iso3", nullable = true, length = 255)
    public String getIso3() {
        return iso3;
    }

    public void setIso3(String iso3) {
        this.iso3 = iso3;
    }

    @Basic
    @Column(name = "admin_name", nullable = true, length = 255)
    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    @Basic
    @Column(name = "capital", nullable = true, length = 255)
    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    @Basic
    @Column(name = "pop_number", nullable = true, length = 255)
    public String getPopNumber() {
        return popNumber;
    }

    public void setPopNumber(String popNumber) {
        this.popNumber = popNumber;
    }

    @Basic
    @Column(name = "own_id", nullable = true, length = 100)
    public String getOwnId() {
        return ownId;
    }

    public void setOwnId(String ownId) {
        this.ownId = ownId;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PopulationmainEntity that = (PopulationmainEntity) o;
        return id == that.id &&
                Objects.equals(city, that.city) &&
                Objects.equals(cityAscii, that.cityAscii) &&
                Objects.equals(lat, that.lat) &&
                Objects.equals(lng, that.lng) &&
                Objects.equals(country, that.country) &&
                Objects.equals(iso2, that.iso2) &&
                Objects.equals(iso3, that.iso3) &&
                Objects.equals(adminName, that.adminName) &&
                Objects.equals(capital, that.capital) &&
                Objects.equals(popNumber, that.popNumber) &&
                Objects.equals(ownId, that.ownId);
    }

    @Override
    public int hashCode() {

        return Objects.hash(city, cityAscii, lat, lng, country, iso2, iso3, adminName, capital, popNumber, ownId, id);
    }
}
