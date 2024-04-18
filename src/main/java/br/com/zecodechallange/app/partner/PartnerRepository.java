package br.com.zecodechallange.app.partner;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.zecodechallange.app.partner.entity.Partner;


// db.partners.aggregate([
//   {
//     $geoNear: {
//       near: {
//         type: "Point",
//         coordinates: [-43.297337,-23.013538] 
//       },
//       distanceField: "distance",
//       maxDistance: 100000, 
//       spherical: true,
//       query: {
//         "coverageArea": {
//           $geoIntersects: {
//             $geometry: {
//               type: "Point",
//               coordinates: [-43.297337,-23.013538] 
//             }
//           }
//         }
//       }
//     }
//   },
//   { $sort: { distance: 1 } },
//   { $limit: 1 }
// ])


public interface PartnerRepository extends MongoRepository<Partner, String> {
    boolean existsByDocument(String document);
}
