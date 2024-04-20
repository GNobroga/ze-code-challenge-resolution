package br.com.zecodechallange.app.partner.dto;

import br.com.zecodechallange.app.partner.valueObject.Address;
import br.com.zecodechallange.app.partner.valueObject.CoverageArea;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
public class PartnerRequestDTO {

    @NotBlank(message = "Trading name is mandatory")
    private String tradingName;

    @NotBlank(message = "Owner name is mandatory")
    private String ownerName;

    @NotBlank(message = "Document is mandatory")
    private String document;

    @NotNull(message = "Coverage area is mandatory")
    private CoverageArea coverageArea;

    @NotNull(message = "Address is mandatory")
    private Address address;
}