package br.com.zecodechallange.app.partner.dto;

import br.com.zecodechallange.app.partner.valueObject.Address;
import br.com.zecodechallange.app.partner.valueObject.CoverageArea;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter 
@Setter
public class PartnerRequestDTO {

    @NotBlank(message = "is mandatory")
    @Size(min = 3, max = 255, message = "must be between 3 and 255 characters")
    private String tradingName;

    @NotBlank(message = "is mandatory")
    @Size(min = 3, max = 255, message = "must be between 3 and 255 characters")
    private String ownerName;

    @NotBlank(message = "partner.document is mandatory")
    @Pattern(regexp = "\\d{13}/\\d{4}", message = "Invalid format")
    private String document;

    @NotNull(message = "is mandatory")
    private CoverageArea coverageArea;

    @NotNull(message = "is mandatory")
    private Address address;
}