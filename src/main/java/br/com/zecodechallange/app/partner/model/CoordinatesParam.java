package br.com.zecodechallange.app.partner.model;

import java.util.Map;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CoordinatesParam {
    
    private Double longitude;

    private Double latitude;

    private final static String LONGITUDE_KEY = "long";
    private final static String LATITUDE_KEY = "lat";

    public CoordinatesParam(Map<String, String> params) {
        if (params.size() == 2 && params.containsKey(LONGITUDE_KEY) && params.containsKey(LATITUDE_KEY)) {
            try {
                longitude = Double.parseDouble(params.get(LONGITUDE_KEY));
                latitude = Double.parseDouble(params.get(LATITUDE_KEY));
            } catch (NumberFormatException| NullPointerException exception) {
                throw new IllegalArgumentException("Invalid longitude and latitude values");
            }
        } else {
            throw new IllegalArgumentException("Invalid parameters. Expected longitude and latitude keys.");
        }
    }

}
