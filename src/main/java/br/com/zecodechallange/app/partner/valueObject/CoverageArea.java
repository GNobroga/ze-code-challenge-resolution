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
                       point.validate();
                    }

                }
              
            }
        }
    }