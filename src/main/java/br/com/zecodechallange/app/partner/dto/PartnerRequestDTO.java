package br.com.zecodechallange.app.partner.dto;

import br.com.zecodechallange.app.partner.valueObject.Address;
import br.com.zecodechallange.app.partner.valueObject.CoverageArea;
import lombok.NoArgsConstructor;
import lombok.Setter;

import lombok.Getter;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
public class PartnerRequestDTO {

    private String tradingName;
    private String ownerName;
    private String document;
    private CoverageArea coverageArea;
    private Address address;
}