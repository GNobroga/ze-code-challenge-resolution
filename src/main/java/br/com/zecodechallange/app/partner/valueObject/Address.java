package br.com.zecodechallange.app.partner.valueObject;

import br.com.zecodechallange.app.partner.model.Point;
import br.com.zecodechallange.app.partner.model.enums.GeoJsonType;;

public record Address(
    String type, 
    Point coordinates) {

        public void validate() {
            if (type() == null || !GeoJsonType.POINT.getValue().equals(type)) {
                throw new IllegalArgumentException("The type specified for the address is invalid. Only Point type is available");
            }

            if (coordinates == null || coordinates.size() != 2) {
                throw new IllegalArgumentException("The address coordinate must only have two values");
            }

            Double longitude = coordinates.getLongitude();
            Double latitude = coordinates.getLatitude();

            if (longitude < -180D ||  longitude > 180) {
                throw new IllegalArgumentException("Longitude cannot be less than -180 and greater than 180");
            }

            if (latitude < -90D ||  latitude > 90) {
                throw new IllegalArgumentException("Latitude cannot be less than -90 and greater than 90");
            }
        }

}
