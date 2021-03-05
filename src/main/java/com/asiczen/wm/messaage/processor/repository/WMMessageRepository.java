package com.asiczen.wm.messaage.processor.repository;

import com.asiczen.wm.messaage.processor.model.WMMessage;
import java.time.LocalDateTime;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface WMMessageRepository extends MongoRepository<WMMessage,String> {

    List<WMMessage> findByTimeStampBetween(LocalDateTime startDate, LocalDateTime endDate);
}
