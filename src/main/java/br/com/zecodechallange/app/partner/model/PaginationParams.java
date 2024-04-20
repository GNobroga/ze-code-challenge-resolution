package br.com.zecodechallange.app.partner.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
public class PaginationParams {

    private final static int MAX_SIZE = 1000;
    
    private int size = 100;

    private int page;

    private String sort;

    public int getSize() {
        if (size > MAX_SIZE) {
            return MAX_SIZE;
        }
        return Math.max(1, size);
    }

    public int getPage() {
        return Math.max(0, page);
    }

    public Sort getSort() {
        // -trandingName, DESC
        if (sort == null) {
            return null;
        }

        List<Sort.Order> orders = new ArrayList<>(); 
        var params = sort.split(",");

        for (var field: params) {
            Sort.Order order = field.startsWith("-") ? Sort.Order.desc(field.replace("-", "")) : Sort.Order.asc(field);
            orders.add(order);
        }

        return Sort.by(orders);
    }

    public Pageable getPageable() {
        Sort sort = getSort();
        if (sort == null) {
            return PageRequest.of(getPage(), getSize());
        } else {
            return PageRequest.of(getPage(), getSize(), sort);
        }
    
    }
}
