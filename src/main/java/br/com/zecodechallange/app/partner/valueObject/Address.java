package br.com.zecodechallange.app.partner.valueObject;

import br.com.zecodechallange.app.exception.ApplicationException;
import br.com.zecodechallange.app.partner.model.Point;
import br.com.zecodechallange.app.partner.model.enums.GeoJsonType;;

public record Address(
    String type, 
    Point coordinates) {

    public void validate() {
        validateAddressType();
        validatePointCoordinates();
    }

    private void validateAddressType() {
        if (type == null || !GeoJsonType.POINT.getValue().equals(type)) {
            throw new ApplicationException("Invalid address type. Only 'Point' type is allowed");
        }
    }

    private void validatePointCoordinates() {
        if (coordinates == null) {
            throw new ApplicationException("Coordinates cannot be null");
        }
        coordinates.validate();
    }
}

