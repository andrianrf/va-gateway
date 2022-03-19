package com.multipolar.vagateway.modules.rootController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/")
public class rootController {

    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam(defaultValue = "ok") String message) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("requestDate", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        log.info("Request : GET /test?message="+message+", Response : "+map);
        return ResponseEntity.ok().body(map);
    }
}
