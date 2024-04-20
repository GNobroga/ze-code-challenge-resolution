package br.com.zecodechallange.app.partner;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.zecodechallange.app.partner.dto.PartnerRequestDTO;
import br.com.zecodechallange.app.partner.entity.Partner;
import br.com.zecodechallange.app.partner.facade.PartnerFacade;
import br.com.zecodechallange.app.partner.model.CoordinatesParam;
import br.com.zecodechallange.app.partner.model.PaginationParams;
import br.com.zecodechallange.app.partner.model.ResponseResult;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/partners")
@RequiredArgsConstructor
public class PartnerController {
    
    private final PartnerFacade partnerFacade;

    
    @GetMapping
    public ResponseEntity<ResponseResult<List<Partner>>> get(final PaginationParams paginationParams) {
        final var page = partnerFacade.retrieve(paginationParams.getPageable());
        final var response = ResponseResult.<List<Partner>>builder()
        .page(page.getTotalPages())
        .size(page.getSize())
        .totalElements(page.getNumberOfElements())
        .result(page.getContent())
        .build();
        return ResponseEntity.ok(response);
    }

    @GetMapping("/nearest")
    public ResponseEntity<ResponseResult<List<Partner>>> get(@RequestParam final Map<String, String> params)  {
        System.out.println(params.size());
        final var result = partnerFacade.findNearest(new CoordinatesParam(params));
        final var response = ResponseResult.<List<Partner>>builder()
        .result(result)
        .build();
        return ResponseEntity.ok(response);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseResult<Partner>> get(@PathVariable("id") final Long id) {
        final var response = ResponseResult.<Partner>builder()
            .result(partnerFacade.retrieve(id))
            .build();
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ResponseResult<Partner>> post(@RequestBody @Valid final PartnerRequestDTO record) {
        final var partner = partnerFacade.create(record);
        final var uriComponents = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(partner.getId());
        final var response = ResponseResult.<Partner>builder()
            .result(partner)
            .build();
        return ResponseEntity.created(uriComponents.toUri()).body(response);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") final Long id) {
        partnerFacade.delete(id);
        return ResponseEntity.noContent().build();
    }
}
