package com.multipolar.vagateway.modules.transferVa.v1;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/1.0/transfer-va")
public class transferVAv1Controller {

    @SneakyThrows
    @PostMapping("/inquiry")
    public ResponseEntity<?> inquiry(@RequestHeader(value="Authorization", required=false) String authorization,
                                     @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                     @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                     @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                     @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                     @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                     @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                     @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                     @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                     @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                     @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                     @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                     @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{ \"responseCode\":\"2002400\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"inquiryStatus\":\"00\", \"inquiryReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janeDoe@email.co.id\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"inquiryRequestId\":\"abcdef-123456-abcdef\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"subCompany\":\"12345\", \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"billAmountLabel\":\"Total Tagihan\", \"billAmountValue\":\"Rp. 50.000,-\", \"additionalInfo\":{ } } ], \"freeTexts\":[{ \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ], \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : POST /1.0/transfer-va/inquiry "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/payment")
    public ResponseEntity<?> payment(@RequestHeader(value="Authorization", required=false) String authorization,
                                     @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                     @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                     @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                     @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                     @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                     @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                     @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                     @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                     @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                     @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                     @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                     @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{\"responseCode\":\"2002500\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"paymentFlagReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"paymentRequestId\":\"abcdef-123456-abcdef\", \"paidAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"paidBills\":\"95000\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"trxDateTime\":\"20201231T235959Z\", \"referenceNo\":\"123456789012345\", \"journalNum\":\"123456\", \"paymentType\":1, \"flagAdvise\":\"Y\", \"paymentFlagStatus\":\"00\", \"billDetails\":[ { \"billerReferenceId\":\"123456789012345678\", \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\"}, \"additionalInfo\":{ }, \"status\":\"00\", \"reason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ] }, \"additionalInfo\":{ } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : POST /1.0/transfer-va/payment "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @GetMapping("/status")
    public ResponseEntity<?> status(@RequestHeader(value="Authorization", required=false) String authorization,
                                    @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                    @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                    @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                    @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                    @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                    @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                    @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                    @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                    @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                    @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                    @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                    @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{ \"responseCode\":\"2002600\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"paymentFlagReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"inquiryRequestId\":\"abcdef-123456-abcdef\", \"paymentRequestId\":\"abcdef-123456-abcdef\", \"paidAmount\":[ { \"value\":\"12345678.00\", \"currency\":\"IDR\" } ], \"paidBills\":\"95000\", \"totalAmount\":[ { \"value\":\"12345678.00\", \"currency\":\"IDR\" } ], \"trxDateTime\":\"20201231T235959Z\", \"transactionDate\":\"20201230T235959Z\", \"referenceNo\":\"123456789012345\", \"paymentType\":1, \"flagAdvise\":\"Y\", \"paymentFlagStatus\":\"00\", \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ }, \"billReferenceNo\":\"123456789012345\", \"status\":\"00\", \"reason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ] }, \"additionalInfo\":{ } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : GET /1.0/transfer-va/status "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/create-va")
    public ResponseEntity<?> createVa(@RequestHeader(value="Authorization", required=false) String authorization,
                                      @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                      @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                      @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                      @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                      @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                      @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                      @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                      @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                      @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                      @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                      @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                      @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{\n" +
                " \"responseCode\":\"2002700\",\n" +
                " \"responseMessage\":\"Success\",\n" +
                " \"virtualAccountData\":{\n" +
                " \"partnerServiceId\":\" 088899\",\n" +
                " \"customerNo\":\"12345678901234567890\",\n" +
                " \"virtualAccountNo\":\" 08889912345678901234567890\",\n" +
                " \"virtualAccountName\":\"Jane Doe\",\n" +
                " \"virtualAccountEmail\":\"janedoe@email.com\",\n" +
                " \"virtualAccountPhone\":\"62818xxxxxxxxx\",\n" +
                " \"trxId\":\"abcdefgh1234\",\n" +
                " \"totalAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"billDetails\":[\n" +
                " {\n" +
                " \"billCode\":\"01\",\n" +
                " \"billNo\":\"123456789012345678\",\"billName\":\"Bill A for Jan\",\n" +
                " \"billShortName\":\"Bill A\",\n" +
                " \"billDescription\":{\n" +
                " \"english\":\"Maintenance\",\n" +
                " \"indonesia\":\"Pemeliharaan\"\n" +
                " },\n" +
                " \"billSubCompany\":\"00001\",\n" +
                " \"billAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"additionalInfo\":{\n" +
                " }\n" +
                " }\n" +
                " ],\n" +
                " \"freeTexts\":[\n" +
                " {\n" +
                " \"english\":\"Free text\",\n" +
                " \"indonesia\":\"Tulisan bebas\"\n" +
                " }\n" +
                " ],\n" +
                " \"virtualAccountTrxType\":\"1\",\n" +
                " \"feeAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"expiredDate\":\"2020-12-31T23:59:59-07:00\",\n" +
                " \"additionalInfo\":{\n" +
                " \"deviceId\":\"12345679237\",\n" +
                " \"channel\":\"mobilephone\"\n" +
                " }\n" +
                " }\n" +
                "}";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : POST /1.0/transfer-va/create-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PutMapping("/update-va")
    public ResponseEntity<?> updateVa(@RequestHeader(value="Authorization", required=false) String authorization,
                                      @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                      @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                      @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                      @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                      @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                      @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                      @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                      @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                      @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                      @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                      @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                      @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{ \"responseCode\":\"2002800\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{\"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ } } ], \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"expiredDate\":\"2020-12-31T23:59:59-07:00\", \"lastUpdateDate\":\"2020-12-31T23:59:59-07:00\", \"paymentDate\":\"2020-12-31T23:59:59-07:00\", \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : PUT /1.0/transfer-va/update-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PutMapping("/update-status")
    public ResponseEntity<?> updateStatus(@RequestHeader(value="Authorization", required=false) String authorization,
                                          @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                          @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                          @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                          @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                          @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                          @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                          @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                          @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                          @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                          @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                          @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                          @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{ \"responseCode\":\"2002900\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"expiredDate\":\"2020-12-31T23:59:59-07:00\", \"lastUpdateDate\":\"2020-12-31T23:59:59-07:00\", \"paymentDate\":\"2020-12-31T23:59:59-07:00\", \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : PUT /1.0/transfer-va/update-status "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @GetMapping("/inquiry-va")
    public ResponseEntity<?> inquiryVa(@RequestHeader(value="Authorization", required=false) String authorization,
                                       @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                       @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                       @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                       @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                       @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                       @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                       @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                       @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                       @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                       @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                       @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                       @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{ \"responseCode\":2003000, \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"billDetails\":[ {\"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ], \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"expiredDate\":\"2020-12-31T23:59:59-07:00\", \"lastUpdateDate\":\"2020-12-31T23:59:59-07:00\", \"paymentDate\":\"2020-12-31T23:59:59-07:00\", \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : GET /1.0/transfer-va/inquiry-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @DeleteMapping("/delete-va")
    public ResponseEntity<?> deleteVa(@RequestHeader(value="Authorization", required=false) String authorization,
                                      @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                      @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                      @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                      @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                      @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                      @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                      @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                      @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                      @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                      @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                      @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                      @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{ \"responseCode\":\"2003100\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"trxId\":\"abcdefgh1234\", \"additionalInfo\":{ } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : DELETE /1.0/transfer-va/delete-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @GetMapping("/inquiry-intrabank")
    public ResponseEntity<?> inquiryIntrabank(@RequestHeader(value="Authorization", required=false) String authorization,
                                              @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                              @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                              @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                              @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                              @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                              @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                              @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                              @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                              @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                              @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                              @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                              @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{\n" +
                " \"responseCode\":2003200,\n" +
                " \"responseMessage\":\"Success\",\n" +
                " \"virtualAccountdata\":{\n" +
                " \"inquiryStatus\":\"00\",\"inquiryReason\":{\n" +
                " \"english\":\"Success\",\n" +
                " \"indonesia\":\"Sukses\"\n" +
                " },\n" +
                " \"partnerServiceId\":\" 088899\",\n" +
                " \"partnerReferenceNo\":\"abcdef-123456-abcdef\",\n" +
                " \"customerNo\":\"12345678901234567890\",\n" +
                " \"virtualAccountNo\":\" 08889912345678901234567890\",\n" +
                " \"virtualAccountName\":\"Jane Doe\",\n" +
                " \"virtualAccountEmail\":\"janeDoe@email.co.id\",\n" +
                " \"virtualAccountPhone\":\"62818xxxxxxxxx\",\n" +
                " \"sourceAccountNo\":\"1234567890\",\n" +
                " \"sourceAccountType\":\"S\",\n" +
                " \"inquiryRequestId\":\"abcdef-123456-abcdef\",\n" +
                " \"totalAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"billDetails\":[\n" +
                " {\n" +
                " \"billCode\":\"01\",\n" +
                " \"billNo\":\"123456789012345678\",\n" +
                " \"billName\":\"Bill A for Jan\",\n" +
                " \"billShortName\":\"Bill A\",\n" +
                " \"billDescription\":{\n" +
                " \"english\":\"Maintenance\",\n" +
                " \"indonesia\":\"Pemeliharaan\"\n" +
                " },\n" +
                " \"billSubCompany\":\"00001\",\n" +
                " \"billAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"billAmountLabel\":\"Total Tagihan\",\n" +
                " \"billAmountValue\":\"Rp. 50.000,-\",\n" +
                " \"additionalInfo\":{\n" +
                " }\n" +
                " }\n" +
                " ],\n" +
                " \"freeTexts\":[\n" +
                " {\n" +
                " \"english\":\"Free text\",\n" +
                " \"indonesia\":\"Tulisan bebas\"\n" +
                " }],\n" +
                " \"virtualAccountTrxType\":\"1\",\n" +
                " \"feeAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"productName\":\"Pendidikan\",\n" +
                " \"additionalInfo\":{\n" +
                " \"deviceId\":\"12345679237\",\n" +
                " \"channel\":\"mobilephone\"\n" +
                " }\n" +
                " }\n" +
                "}";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : GET /1.0/transfer-va/inquiry-intrabank "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/payment-intrabank")
    public ResponseEntity<?> paymentIntrabank(@RequestHeader(value="Authorization", required=false) String authorization,
                                              @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                              @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                              @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                              @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                              @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                              @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                              @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                              @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                              @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                              @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                              @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                              @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{\n" +
                " \"responseCode\":2003200,\n" +
                " \"responseMessage\":\"Success\",\n" +
                " \"virtualAccountdata\":{\n" +
                " \"inquiryStatus\":\"00\",\"inquiryReason\":{\n" +
                " \"english\":\"Success\",\n" +
                " \"indonesia\":\"Sukses\"\n" +
                " },\n" +
                " \"partnerServiceId\":\" 088899\",\n" +
                " \"partnerReferenceNo\":\"abcdef-123456-abcdef\",\n" +
                " \"customerNo\":\"12345678901234567890\",\n" +
                " \"virtualAccountNo\":\" 08889912345678901234567890\",\n" +
                " \"virtualAccountName\":\"Jane Doe\",\n" +
                " \"virtualAccountEmail\":\"janeDoe@email.co.id\",\n" +
                " \"virtualAccountPhone\":\"62818xxxxxxxxx\",\n" +
                " \"sourceAccountNo\":\"1234567890\",\n" +
                " \"sourceAccountType\":\"S\",\n" +
                " \"inquiryRequestId\":\"abcdef-123456-abcdef\",\n" +
                " \"totalAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"billDetails\":[\n" +
                " {\n" +
                " \"billCode\":\"01\",\n" +
                " \"billNo\":\"123456789012345678\",\n" +
                " \"billName\":\"Bill A for Jan\",\n" +
                " \"billShortName\":\"Bill A\",\n" +
                " \"billDescription\":{\n" +
                " \"english\":\"Maintenance\",\n" +
                " \"indonesia\":\"Pemeliharaan\"\n" +
                " },\n" +
                " \"billSubCompany\":\"00001\",\n" +
                " \"billAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"billAmountLabel\":\"Total Tagihan\",\n" +
                " \"billAmountValue\":\"Rp. 50.000,-\",\n" +
                " \"additionalInfo\":{\n" +
                " }\n" +
                " }\n" +
                " ],\n" +
                " \"freeTexts\":[\n" +
                " {\n" +
                " \"english\":\"Free text\",\n" +
                " \"indonesia\":\"Tulisan bebas\"\n" +
                " }],\n" +
                " \"virtualAccountTrxType\":\"1\",\n" +
                " \"feeAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"productName\":\"Pendidikan\",\n" +
                " \"additionalInfo\":{\n" +
                " \"deviceId\":\"12345679237\",\n" +
                " \"channel\":\"mobilephone\"\n" +
                " }\n" +
                " }\n" +
                "}";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : POST /1.0/transfer-va/payment-intrabank "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/notify-payment-intrabank")
    public ResponseEntity<?> notifyPaymentIntrabank(@RequestHeader(value="Authorization", required=false) String authorization,
                                                    @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                                    @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                                    @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                                    @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                                    @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                                    @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                                    @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                                    @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                                    @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                                    @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                                    @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                                    @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{\n" +
                " \"responseCode\":2003200,\n" +
                " \"responseMessage\":\"Success\",\n" +
                " \"virtualAccountdata\":{\n" +
                " \"inquiryStatus\":\"00\",\"inquiryReason\":{\n" +
                " \"english\":\"Success\",\n" +
                " \"indonesia\":\"Sukses\"\n" +
                " },\n" +
                " \"partnerServiceId\":\" 088899\",\n" +
                " \"partnerReferenceNo\":\"abcdef-123456-abcdef\",\n" +
                " \"customerNo\":\"12345678901234567890\",\n" +
                " \"virtualAccountNo\":\" 08889912345678901234567890\",\n" +
                " \"virtualAccountName\":\"Jane Doe\",\n" +
                " \"virtualAccountEmail\":\"janeDoe@email.co.id\",\n" +
                " \"virtualAccountPhone\":\"62818xxxxxxxxx\",\n" +
                " \"sourceAccountNo\":\"1234567890\",\n" +
                " \"sourceAccountType\":\"S\",\n" +
                " \"inquiryRequestId\":\"abcdef-123456-abcdef\",\n" +
                " \"totalAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"billDetails\":[\n" +
                " {\n" +
                " \"billCode\":\"01\",\n" +
                " \"billNo\":\"123456789012345678\",\n" +
                " \"billName\":\"Bill A for Jan\",\n" +
                " \"billShortName\":\"Bill A\",\n" +
                " \"billDescription\":{\n" +
                " \"english\":\"Maintenance\",\n" +
                " \"indonesia\":\"Pemeliharaan\"\n" +
                " },\n" +
                " \"billSubCompany\":\"00001\",\n" +
                " \"billAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"billAmountLabel\":\"Total Tagihan\",\n" +
                " \"billAmountValue\":\"Rp. 50.000,-\",\n" +
                " \"additionalInfo\":{\n" +
                " }\n" +
                " }\n" +
                " ],\n" +
                " \"freeTexts\":[\n" +
                " {\n" +
                " \"english\":\"Free text\",\n" +
                " \"indonesia\":\"Tulisan bebas\"\n" +
                " }],\n" +
                " \"virtualAccountTrxType\":\"1\",\n" +
                " \"feeAmount\":{\n" +
                " \"value\":\"12345678.00\",\n" +
                " \"currency\":\"IDR\"\n" +
                " },\n" +
                " \"productName\":\"Pendidikan\",\n" +
                " \"additionalInfo\":{\n" +
                " \"deviceId\":\"12345679237\",\n" +
                " \"channel\":\"mobilephone\"\n" +
                " }\n" +
                " }\n" +
                "}";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : POST /1.0/transfer-va/notify-payment-intrabank "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @GetMapping("/report")
    public ResponseEntity<?> report(@RequestHeader(value="Authorization", required=false) String authorization,
                                    @RequestHeader(value="Authorization-Customer", required=false) String authorizationcustomer,
                                    @RequestHeader(value="X-TIMESTAMP", required=false) String timestamp,
                                    @RequestHeader(value="X-SIGNATURE", required=false) String signature,
                                    @RequestHeader(value="X-ORIGIN", required=false) String origin,
                                    @RequestHeader(value="X-PARTNER-ID", required=false) String partner,
                                    @RequestHeader(value="X-EXTERNAL-ID", required=false) String external,
                                    @RequestHeader(value="X-IP-ADDRESS", required=false) String address,
                                    @RequestHeader(value="X-DEVICE-ID", required=false) String device,
                                    @RequestHeader(value="X-LATITUDE", required=false) String latitude,
                                    @RequestHeader(value="X-LONGITUDE", required=false) String longitude,
                                    @RequestHeader(value="CHANNEL-ID", required=false) String channel,
                                    @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String respon = "{ \"responseCode\":2003500, \"responseMessage\":\"Success\", \"virtualAccountdata\":[ { \"paymentFlagReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"sourceAccountNo\":\"1234567890\", \"sourceAccountType\":\"S\", \"trxId\":\"abcdefgh1234\", \"inquiryRequestId\":\"abcdef-123456-abcdef\", \"paymentRequestId\":\"abcdef-123456-abcdef\", \"paidAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"paidBills\":\"95000\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"trxDateTime\":\"20201231T235959Z\", \"referenceNo\":\"123456789012345\", \"journalNum\":\"123456\", \"paymentType\":1, \"flagAdvise\":\"Y\", \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ }, \"status\":\"00\", \"reason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ], \"additionalInfo\":{ } } ] }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : GET /1.0/transfer-va/report "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }
    
}
