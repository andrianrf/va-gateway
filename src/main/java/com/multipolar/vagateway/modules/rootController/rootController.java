package com.multipolar.vagateway.modules.rootController;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
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

    @Autowired
    Environment env;

    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam(defaultValue = "") String message, HttpServletRequest request) {

        if(message.equals("")){
            message = env.getProperty("test.default.message");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("requestDate", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        log.info("Client IP : "+request.getRemoteAddr()+", Request : GET /test?message="+message);
        try {
        Thread.sleep(Integer.valueOf(env.getProperty("test.timeout.second")) * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        log.info("Client IP : "+request.getRemoteAddr()+", Request : GET /test?message="+message+", Response : "+map);
        return ResponseEntity.ok().body(map);
    }
}
