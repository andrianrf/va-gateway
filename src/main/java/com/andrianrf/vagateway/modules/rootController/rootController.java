package com.andrianrf.vagateway.modules.rootController;

import com.andrianrf.vagateway.util.CustomFormater;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@Slf4j
@RestController
@RequestMapping("/")
public class rootController {

    @Autowired
    Environment env;

    @GetMapping("/test")
    public ResponseEntity<?> test(@RequestParam(defaultValue = "") String message, HttpServletRequest request) {

        if (message.equals("")) {
            message = env.getProperty("test.default.message");
        }

        Map<String, Object> map = new HashMap<>();
        map.put("message", message);
        map.put("requestDate", new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(new Date()));
        String clientIp = request.getHeader("X-Real-IP") != null ? "FWD:" + request.getHeader("X-Real-IP") : "RMT:" + request.getRemoteAddr();
        log.info("Client IP : " + clientIp + ", Request : GET /test?message=" + message);
        try {
            Thread.sleep(Integer.valueOf(env.getProperty("test.timeout.second")) * 1000);
        } catch (InterruptedException ie) {
            Thread.currentThread().interrupt();
        }
        log.info("Client IP : " + clientIp + ", Request : GET /test?message=" + message + ", Response : " + map);
        return ResponseEntity.ok().body(map);
    }

    @PostMapping("/webhook")
    public ResponseEntity<?> postWebhook(
            HttpServletRequest httpServletRequest,
            @RequestBody Map<String, Object> requestBody) {

        String clientIp = httpServletRequest.getHeader("X-Real-IP") != null ? "FWD:" + httpServletRequest.getHeader("X-Real-IP") : "RMT:" + httpServletRequest.getRemoteAddr();
        String LogRequest = "[" + clientIp
                + "] [" + httpServletRequest.getMethod() + "] " + httpServletRequest.getRequestURI()
                + ", Request : " + CustomFormater.minifyJson(requestBody);
        log.info(LogRequest);

        return ResponseEntity.ok().body(requestBody);
    }
}
