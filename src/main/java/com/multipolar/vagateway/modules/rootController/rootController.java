package com.multipolar.vagateway.modules.rootController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/")
public class rootController {

    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam(defaultValue = "ok") String message, HttpServletRequest request) {
        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("requestDate", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        log.info("Client IP : "+request.getRemoteAddr()+", Request : GET /test?message="+message+", Response : "+map);
        return ResponseEntity.ok().body(map);
    }
}
