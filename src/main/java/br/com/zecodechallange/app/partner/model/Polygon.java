package br.com.zecodechallange.app.partner.model;

import java.util.ArrayList;
import java.util.List;

import br.com.zecodechallange.app.exception.ApplicationException;

public class Polygon extends ArrayList<List<Point>> {
    
    public void validate() {
        if (isEmpty()) {
            throw new ApplicationException("The polygon cannot be empty");
        }

        for (var i = 0 ; i < size() ; i++) {
            var subList = this.get(i);
            if (subList.isEmpty()) {
                throw new ApplicationException("The polygon must have at least 1 set of points");
            }

            subList.forEach(Point::validate);
        }
    }
}
