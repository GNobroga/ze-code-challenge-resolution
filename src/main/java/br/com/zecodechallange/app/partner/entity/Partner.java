package br.com.zecodechallange.app.partner.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.zecodechallange.app.partner.valueObject.Address;
import br.com.zecodechallange.app.partner.valueObject.CoverageArea;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;  

@Document("partners")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Partner {

    @Transient
    public static final String SEQUENCE_NAME = "partners_sequence";

    @Id
    private Long id;
    private String tradingName;
    private String ownerName;
    private String document;
    private CoverageArea coverageArea;
    private Address address;
}