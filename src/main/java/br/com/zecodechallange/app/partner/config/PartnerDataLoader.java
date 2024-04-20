package br.com.zecodechallange.app.partner.config;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.io.ResourceLoader;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.zecodechallange.app.partner.PartnerRepository;
import br.com.zecodechallange.app.partner.entity.Partner;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@ConfigurationProperties(prefix = "data.loader", ignoreInvalidFields = true, ignoreUnknownFields = true)
@RequiredArgsConstructor
@Getter
@Setter
public class PartnerDataLoader implements CommandLineRunner {

    private Boolean enable;

    private String fileName;

    private final ResourceLoader resourceLoader;

    private final PartnerRepository repository;

    @Override
    public void run(String... args) throws IOException {
        if (!enable) {
            return;
        }
        
        ObjectMapper objectMapper = new ObjectMapper();

        File file = resourceLoader.getResource("classpath:%s".formatted(fileName)).getFile();

        JsonNode root = objectMapper.readTree(file);
        
        Iterator<JsonNode> elements = root.get("pdvs").elements();

        LinkedList<Partner> partners = new LinkedList<>();

        while (elements.hasNext()) {
            var element = elements.next();
            var partner = objectMapper.readValue(element.toPrettyString(), Partner.class);
            partners.add(partner);
        }

        partners.forEach(repository::save);
    }
    
}
