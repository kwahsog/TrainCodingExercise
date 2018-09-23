package exercisethree.driveranddelaydetails;

import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository for storing/searching for TrainDelayDetails entities.
 */
public interface TrainDelayRepository extends MongoRepository<TrainDelayDetails, String> {

    public TrainDelayDetails findByTrainId(String trainId);
}
