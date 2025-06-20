package com.andrianrf.vagateway.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Slf4j
public class CustomFormater {

    public static String minifyJson(Map<String, Object> jsonMap) {
        // Menggunakan TreeMap agar urutan key tetap konsisten
        TreeMap<String, Object> sortedJson = new TreeMap<>(jsonMap);

        String returnString = "";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            returnString = objectMapper.writeValueAsString(sortedJson);
        } catch (JsonProcessingException e) {
            log.info(e.getMessage());
        }

        return returnString;
    }

    public static String formatInstantWib(Instant instant) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss 'WIB'")
                .withZone(ZoneId.of("Asia/Jakarta"));
        return formatter.format(instant);
    }

    public static String formatRp(BigDecimal dob) {
        Locale indonesia = Locale.forLanguageTag("id-ID");
        NumberFormat rupiahFormat = NumberFormat.getCurrencyInstance(indonesia);
        return rupiahFormat.format(dob);
    }

    public static String formatException(String e, String replace) {
        String formatedMessage = e;

        // Gunakan regex untuk ambil bagian yang diinginkan
        Pattern pattern = Pattern.compile("(\\[\\d+\\s+[^]]+\\] during \\[[A-Z]+\\] to \\[[^]]+\\])");
        Matcher matcher = pattern.matcher(e);
        if (matcher.find()) {
            formatedMessage = matcher.group(1);
        }
        return formatedMessage.replaceAll(replace.replaceAll("https://", ""), "");
    }
}
