package br.com.zecodechallange.app.partner.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.zecodechallange.app.partner.valueObject.Address;
import br.com.zecodechallange.app.partner.valueObject.CoverageArea;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document("partners")
@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
public class Partner {

    @Id
    private String id;
    private String tradingName;
    private String ownerName;
    private String document;
    private CoverageArea coverageArea;
    private Address address;
}