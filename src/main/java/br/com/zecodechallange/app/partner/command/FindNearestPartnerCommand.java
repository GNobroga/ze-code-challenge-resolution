package br.com.zecodechallange.app.partner.command;

import java.util.List;

import org.springframework.data.geo.Point;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.aggregation.GeoNearOperation;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeospatialIndex;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.NearQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;

import br.com.zecodechallange.app.partner.entity.Partner;
import br.com.zecodechallange.app.partner.model.CoordinatesParam;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@AllArgsConstructor
@Slf4j
public class FindNearestPartnerCommand {
    
    private final MongoTemplate mongoTemplate;

    private final static String COLLECTION_KEY = "partners";
    
    public List<Partner> execute(CoordinatesParam coordinatesParam) {
        log.info("Entered FindNearestPartnerCommand with long %f and lat %f".formatted(coordinatesParam.getLongitude(), coordinatesParam.getLatitude()));
        Query query = new Query(Criteria.where("coverageArea").intersects(new GeoJsonPoint(coordinatesParam.getLongitude(), coordinatesParam.getLatitude())));
        NearQuery nearQuery = NearQuery.near(
            new Point(coordinatesParam.getLongitude(), coordinatesParam.getLatitude()))
            .spherical(true)
            .query(query);

        GeoNearOperation geoNearOperation = Aggregation.geoNear(nearQuery,"distance");
        Aggregation aggregation = Aggregation.newAggregation(geoNearOperation);

        mongoTemplate.indexOps(Partner.class).ensureIndex(new GeospatialIndex("address").typed(GeoSpatialIndexType.GEO_2DSPHERE));

        AggregationResults<Partner> results = mongoTemplate.aggregate(aggregation, COLLECTION_KEY, Partner.class);
        return results.getMappedResults();
    }
}
