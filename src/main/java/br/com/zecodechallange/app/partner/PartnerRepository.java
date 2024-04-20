package br.com.zecodechallange.app.partner;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.zecodechallange.app.partner.entity.Partner;

public interface PartnerRepository extends MongoRepository<Partner, Long> {
    boolean existsByDocument(String document);
}
