package br.com.zecodechallange.app.partner.listener;

import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.data.mongodb.core.mapping.event.BeforeConvertEvent;
import org.springframework.data.mongodb.core.mapping.event.BeforeSaveEvent;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;

import br.com.zecodechallange.app.partner.entity.DatabaseSequence;
import br.com.zecodechallange.app.partner.entity.Partner;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class PartnerIdIncrementListener extends AbstractMongoEventListener<Partner> {

    private final MongoTemplate mongoTemplate;
    
    @Override
    public void onBeforeConvert(BeforeConvertEvent<Partner> event) {
        final Partner partner = event.getSource();
        if (partner.getId() == null) {
            event.getSource().setId(generateSequence(Partner.SEQUENCE_NAME));
        }
    }

    public long generateSequence(String seqName) {
        Query query = new Query(Criteria.where("_id").is(seqName));
        FindAndModifyOptions options = FindAndModifyOptions.options().returnNew(true).upsert(true);
        Update update = new Update();
        var sequence = mongoTemplate.findAndModify(query, update.inc("seq", 1), options, DatabaseSequence.class);
        return sequence.getSeq();
    }
}
