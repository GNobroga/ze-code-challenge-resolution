package br.com.zecodechallange.app.partner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import br.com.zecodechallange.app.partner.PartnerRepository;

@Configuration
public class PartnerConfig  {
    
    @Bean
    PartnerDataLoader partnerDataLoader(PartnerRepository partnerRepository, ResourceLoader resourceLoader) {
        return new PartnerDataLoader(resourceLoader, partnerRepository);
    }

}
