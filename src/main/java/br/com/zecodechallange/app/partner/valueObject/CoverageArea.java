package br.com.zecodechallange.app.partner.valueObject;

import br.com.zecodechallange.app.exception.ApplicationException;
import br.com.zecodechallange.app.partner.model.MultiPolygon;
import br.com.zecodechallange.app.partner.model.Point;
import br.com.zecodechallange.app.partner.model.Polygon;
import br.com.zecodechallange.app.partner.model.enums.GeoJsonType;

public record CoverageArea(
    String type, 
    MultiPolygon coordinates) {

        public void validate() {
            validateType();
            validateMultipolygonElements();
            validatePoints();
        }

        private void validateType() {
            if (!GeoJsonType.MULTIPOLYGON.getValue().equals(type())) {
                throw new ApplicationException("The type specified for the coverage area is invalid. Only MultiPolygon type is available");
            }
        }

        private void validateMultipolygonElements() {
            if (coordinates() == null || coordinates().isEmpty()) {
                throw new ApplicationException("The coverage area coordinates must have elements");
            }

            coordinates.forEach(Polygon::validate);
        }

        private void validatePoints() {
            coordinates().forEach(polygon -> 
                polygon.forEach(points -> 
                    points.forEach(Point::validate)
                )
            );
        }
    }