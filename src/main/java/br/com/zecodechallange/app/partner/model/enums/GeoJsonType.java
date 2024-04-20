package br.com.zecodechallange.app.partner.model.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum GeoJsonType {
    MULTIPOLYGON("MultiPolygon"),
    POINT("Point");

    private final String value;
}
