package br.com.zecodechallange.app.partner.facade;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.zecodechallange.app.partner.command.CreatePartnerCommand;
import br.com.zecodechallange.app.partner.command.FindNearestPartnerCommand;
import br.com.zecodechallange.app.partner.command.RetrievePartnerCommand;
import br.com.zecodechallange.app.partner.command.RetrievePartnersCommand;
import br.com.zecodechallange.app.partner.command.DeletePartnerCommand;
import br.com.zecodechallange.app.partner.dto.PartnerRequestDTO;
import br.com.zecodechallange.app.partner.entity.Partner;
import br.com.zecodechallange.app.partner.model.CoordinatesParam;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PartnerFacade {
    
    private final CreatePartnerCommand createPartnerCommand;
    private final RetrievePartnersCommand retrievePartnersCommand;
    private final RetrievePartnerCommand retrievePartnerCommand;
    private final DeletePartnerCommand deletePartnerCommand;
    private final FindNearestPartnerCommand findNearestPartnerCommand;


    public Partner create(PartnerRequestDTO record) {
        return createPartnerCommand.execute(record);
    }

    public Partner retrieve(Long id) {
        return retrievePartnerCommand.execute(id);
    }

    public void delete(Long id) {
        deletePartnerCommand.execute(id);
    }

    public Page<Partner> retrieve(Pageable pageable) {
        return retrievePartnersCommand.execute(pageable);
    }

    public List<Partner> findNearest(CoordinatesParam coordinatesParam) {
        return findNearestPartnerCommand.execute(coordinatesParam);
    }

}
