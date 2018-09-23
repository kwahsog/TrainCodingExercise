package exercisethree.driveranddelaydetails;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

/**
 * Repository for storing/searching for TrainDelayDetails entities.
 */
public interface TrainDelayRepository extends MongoRepository<TrainDelayDetails, String> {

    public List<TrainDelayDetails> findByTrainId(String trainId);
}
