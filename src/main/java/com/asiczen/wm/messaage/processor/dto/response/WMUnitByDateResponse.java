package com.asiczen.wm.messaage.processor.dto.response;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WMUnitByDateResponse {

    private String customerName;
    private String customerNumber;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private List<WMDetails> wmDetails = new ArrayList<>();
}
