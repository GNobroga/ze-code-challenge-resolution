package br.com.zecodechallange.app.partner.command;

import org.springframework.stereotype.Component;

import br.com.zecodechallange.app.exception.ApplicationException;
import br.com.zecodechallange.app.partner.PartnerRepository;
import br.com.zecodechallange.app.partner.entity.Partner;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class RetrievePartnerCommand {
    
    private final PartnerRepository repository;
    
    public Partner execute(Long id) {
        return repository.findById(id).orElseThrow(() -> new ApplicationException("Partner not found"));
    }
}
