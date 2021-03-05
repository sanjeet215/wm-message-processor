package com.asiczen.wm.messaage.processor.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WMDetails {

    private String deviceName;
    private String deviceEUI;
    private double lng;
    private double lat;
    private int initialReading;
    private int endReading;
    private long waterConsumed;
}

