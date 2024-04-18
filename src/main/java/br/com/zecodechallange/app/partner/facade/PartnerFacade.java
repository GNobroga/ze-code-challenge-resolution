package br.com.zecodechallange.app.partner.facade;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zecodechallange.app.partner.command.CreatePartnerCommand;
import br.com.zecodechallange.app.partner.command.RetrievePartnerCommand;
import br.com.zecodechallange.app.partner.command.RetrievePartnersCommand;
import br.com.zecodechallange.app.partner.dto.PartnerRequestDTO;
import br.com.zecodechallange.app.partner.entity.Partner;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartnerFacade {
    
    private final CreatePartnerCommand createPartnerCommand;
    private final RetrievePartnersCommand retrievePartnersCommand;
    private final RetrievePartnerCommand retrievePartnerCommand;


    public Partner create(PartnerRequestDTO record) {
        return createPartnerCommand.execute(record);
    }

    public Partner retrieve(String id) {
        return retrievePartnerCommand.execute(id);
    }

    public Page<Partner> retrieve(Pageable pageable) {
        return retrievePartnersCommand.execute(pageable);
    }

}
