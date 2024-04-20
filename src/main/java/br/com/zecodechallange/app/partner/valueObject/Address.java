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

            coordinates.validate();
        }

}
