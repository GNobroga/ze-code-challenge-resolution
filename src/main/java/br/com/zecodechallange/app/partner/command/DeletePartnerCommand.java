package br.com.zecodechallange.app.partner.command;

import java.util.Objects;

import org.springframework.stereotype.Component;

import br.com.zecodechallange.app.partner.PartnerRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DeletePartnerCommand {

    private final PartnerRepository repository;

    public void execute(Long id) {
        repository.deleteById(Objects.requireNonNull(id));
    }
}
