package exercisethree.driveranddelaydetails;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository for storing/searching for TrainDriverDetails entities.
 */

public interface TrainDriverRepository extends MongoRepository<TrainDriverDetails, String> {

    public TrainDriverDetails findByTrainId(String trainId);
}
