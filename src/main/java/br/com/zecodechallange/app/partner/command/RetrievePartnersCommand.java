package br.com.zecodechallange.app.partner.command;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import br.com.zecodechallange.app.partner.PartnerRepository;
import br.com.zecodechallange.app.partner.entity.Partner;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RetrievePartnersCommand {
    
    private final PartnerRepository repository;
    
    public Page<Partner> execute(Pageable pageable) {
        return repository.findAll(pageable);
    }
}
