package com.asiczen.wm.messaage.processor.model;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "wm-messages")
public class WMMessage implements Comparable<WMMessage> {

    private String deviceName;
    private String deviceEUI;
    private long messageCounter;
    private String deviceAddress;
    private LocalDateTime timeStamp;
    private int meterReading;
    private boolean cableStatus;
    private float batteryPercentage;

    @Override
    public int compareTo(WMMessage wmMessage) {
        if (wmMessage.getTimeStamp().isAfter(this.getTimeStamp())) {
            return 1;
        } else if (wmMessage.getTimeStamp().isAfter(this.getTimeStamp())) {
            return -1;
        } else {
            return 0;
        }
    }
}
