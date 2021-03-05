package com.asiczen.wm.messaage.processor.controller;

import com.asiczen.wm.messaage.processor.dto.request.WMUnitsByDateRequest;
import com.asiczen.wm.messaage.processor.dto.response.WMUnitByDateResponse;
import javax.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/waterMeter")
public class AnalyticsController {

    @GetMapping(value = "/unitsByDate")
    @ResponseStatus(HttpStatus.OK)
    public WMUnitByDateResponse getUnitsConsumedByDateRange(@Valid @RequestBody WMUnitsByDateRequest request) {
        return null;

    }
}
