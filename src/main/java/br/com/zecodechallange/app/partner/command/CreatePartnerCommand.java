package br.com.zecodechallange.app.partner.command;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.zecodechallange.app.partner.PartnerRepository;
import br.com.zecodechallange.app.partner.dto.PartnerRequestDTO;
import br.com.zecodechallange.app.partner.entity.Partner;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class CreatePartnerCommand {

    private final PartnerRepository repository;

    private final ModelMapper modelMapper;
    
    public Partner execute(PartnerRequestDTO record) {
        
        if (repository.existsByDocument(record.getDocument())) {
            throw new IllegalArgumentException("The document is already being used");
        }

        return repository.save(modelMapper.map(record, Partner.class));
    }
}
