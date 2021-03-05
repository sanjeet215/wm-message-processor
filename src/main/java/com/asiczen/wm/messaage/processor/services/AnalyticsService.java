package com.asiczen.wm.messaage.processor.services;

import com.asiczen.wm.messaage.processor.dto.request.WMUnitsByDateRequest;
import com.asiczen.wm.messaage.processor.dto.response.WMUnitByDateResponse;
import org.springframework.stereotype.Service;

@Service
public interface AnalyticsService {

    WMUnitByDateResponse getUnitsConsumedByDateRange(WMUnitsByDateRequest request);
}
