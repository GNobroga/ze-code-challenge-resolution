package br.com.zecodechallange.app.partner.command;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.zecodechallange.app.exception.ApplicationException;
import br.com.zecodechallange.app.partner.PartnerRepository;
import br.com.zecodechallange.app.partner.dto.PartnerRequestDTO;
import br.com.zecodechallange.app.partner.entity.Partner;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class UpdatePartnerCommand {

    private final PartnerRepository repository;

    private final ModelMapper modelMapper;

    
    public void execute(final Long id, final PartnerRequestDTO record) {
        record.getAddress().validate();
        record.getCoverageArea().validate();

        final Partner partner = repository.findById(id).orElseThrow(() -> new ApplicationException("Partner with id %d not found".formatted(id)));

        if (!normalize(record.getDocument()).equalsIgnoreCase(normalize(partner.getDocument())) && repository.existsByDocument(record.getDocument())) {
            throw new ApplicationException("The document is already being used");
        } 

        modelMapper.map(record, partner);
        repository.save(partner);
    };

    private String normalize(String document) {
        return document.replaceAll("\\D", "");
    }
}
