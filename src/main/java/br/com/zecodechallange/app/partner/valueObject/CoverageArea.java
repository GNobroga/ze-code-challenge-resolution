package br.com.zecodechallange.app.partner.valueObject;

import java.util.List;

import br.com.zecodechallange.app.partner.model.MultiPolygon;
import br.com.zecodechallange.app.partner.model.enums.GeoJsonType;

public record CoverageArea(
    String type, 
    MultiPolygon coordinates) {

        public void validate() {
            if (type() == null || !GeoJsonType.MULTIPOLYGON.getValue().equals(type())) {
                throw new IllegalArgumentException("The type specified for the address is invalid. Only MultiPolygon type is available");
            }

            if (coordinates() == null || coordinates().isEmpty()) {
                throw new IllegalArgumentException("The multipolygon must have elements");
            }

            for (var polygon: coordinates()) {
                for (var points: polygon) {
                    for (var point: points) {
                        if (point.size() != 2) {
                            throw new IllegalArgumentException("Longitude and latitude are required at each point of the polygon");
                        } 
                        Double longitude = point.getLongitude();
                        Double latitude = point.getLatitude();
            
                        if (longitude < -180D ||  longitude > 180) {
                            throw new IllegalArgumentException("Longitude cannot be less than -180 and greater than 180");
                        }
            
                        if (latitude < -90D ||  latitude > 90) {
                            throw new IllegalArgumentException("Latitude cannot be less than -90 and greater than 90");
                        }
                    }

                }
              
            }
        }
    }