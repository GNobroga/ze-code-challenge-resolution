package br.com.zecodechallange.app.partner.model;

import java.util.ArrayList;

import br.com.zecodechallange.app.exception.ApplicationException;

public class Point extends ArrayList<Double> {

    public void validate() {
        if (size() != 2) {
            throw new ApplicationException("Longitude and latitude are required at point");
        }

        if (getLatitude() != null && getLongitude() != null) {
            if (getLongitude() < -180D ||  getLongitude() > 180) {
                throw new ApplicationException("Longitude cannot be less than -180 and greater than 180");
            }

            if (getLatitude() < -90D ||  getLatitude() > 90) {
                throw new ApplicationException("Latitude cannot be less than -90 and greater than 90");
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
