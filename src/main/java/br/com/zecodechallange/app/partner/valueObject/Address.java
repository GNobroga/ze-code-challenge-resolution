package br.com.zecodechallange.app.partner.valueObject;

import br.com.zecodechallange.app.partner.model.Polygon;

public record Address(String type, Polygon coordinates) {}
