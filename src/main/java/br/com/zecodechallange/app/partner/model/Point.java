package br.com.zecodechallange.app.partner.model;

import java.util.ArrayList;

public class Point extends ArrayList<Double> {


    public void validate() {
        if (size() != 2) {
            throw new IllegalArgumentException("Longitude and latitude are required at point");
        }

        if (getLatitude() != null && getLongitude() != null) {
            if (getLongitude() < -180D ||  getLongitude() > 180) {
                throw new IllegalArgumentException("Longitude cannot be less than -180 and greater than 180");
            }

            if (getLatitude() < -90D ||  getLatitude() > 90) {
                throw new IllegalArgumentException("Latitude cannot be less than -180 and greater than 180");
            }
        }
    } 

    public Double getLongitude() {
        if (!isEmpty()) {
            return get(0);

        }
        return null;
    }

    public Double getLatitude() {
        if (!isEmpty()) {
            return get(1);
        }
        return null;
    }

}
