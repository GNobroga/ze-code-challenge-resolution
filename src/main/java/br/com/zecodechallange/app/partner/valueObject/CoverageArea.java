package br.com.zecodechallange.app.partner.valueObject;

import br.com.zecodechallange.app.partner.model.MultiPolygon;

public record CoverageArea(String type, MultiPolygon coordinates) {}