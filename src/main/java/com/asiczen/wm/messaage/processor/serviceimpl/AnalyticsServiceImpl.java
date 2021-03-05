package com.asiczen.wm.messaage.processor.serviceimpl;

import com.asiczen.wm.messaage.processor.dto.request.WMUnitsByDateRequest;
import com.asiczen.wm.messaage.processor.dto.response.WMDetails;
import com.asiczen.wm.messaage.processor.dto.response.WMUnitByDateResponse;
import com.asiczen.wm.messaage.processor.model.WMMessage;
import com.asiczen.wm.messaage.processor.repository.WMMessageRepository;
import com.asiczen.wm.messaage.processor.services.AnalyticsService;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AnalyticsServiceImpl implements AnalyticsService {

    @Autowired
    WMMessageRepository wmMessageRepository;

    @Override
    public WMUnitByDateResponse getUnitsConsumedByDateRange(WMUnitsByDateRequest request) {

        // Step 1 : get message for beginDate -- minimum
        LocalDateTime startDate = request.getStartDate().toLocalDate().atStartOfDay();
        LocalDateTime endDate = request.getStartDate().plusDays(1l).toLocalDate().atStartOfDay();
        List<WMMessage> wmMessagesFirstDate = wmMessageRepository.findByTimeStampBetween(startDate, endDate);
        Collections.sort(wmMessagesFirstDate);
        WMMessage wmMessageFirstMessage = wmMessagesFirstDate.stream().findFirst().orElse(new WMMessage());

        // Step 2: get message for endDate -- maximum
        startDate = request.getEndDate().toLocalDate().atStartOfDay();
        endDate = request.getEndDate().plusDays(1l).toLocalDate().atStartOfDay();

        List<WMMessage> wmMessagesForLastDate = wmMessageRepository.findByTimeStampBetween(startDate, endDate);
        Collections.sort(wmMessagesForLastDate);
        Collections.reverse(wmMessagesForLastDate);
        WMMessage wmMessageLastMessage = wmMessagesForLastDate.stream().findFirst().orElse(new WMMessage());

        int numberOfUnits = wmMessageLastMessage.getMeterReading() - wmMessageFirstMessage.getMeterReading();
        long waterConsumed = numberOfUnits * 10;

        WMDetails wmDetails = WMDetails.builder();

    }
}
