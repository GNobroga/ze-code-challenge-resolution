package br.com.zecodechallange.app.partner.model;

import java.util.ArrayList;

public class Point extends ArrayList<Double> {

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
