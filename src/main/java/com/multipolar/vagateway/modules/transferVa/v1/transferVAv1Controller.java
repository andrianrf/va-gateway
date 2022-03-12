package com.multipolar.vagateway.modules.transferVa.v1;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/1.0/transfer-va")
public class transferVAv1Controller {

    @SneakyThrows
    @PostMapping("/inquiry")
    public ResponseEntity<?> inquiry(@RequestHeader("Authorization") String authorizationH,
                                     @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                     @RequestHeader("X-TIMESTAMP") String timestampH,
                                     @RequestHeader("X-SIGNATURE") String signatureH,
                                     @RequestHeader("X-ORIGIN") String originH,
                                     @RequestHeader("X-PARTNER-ID") String partnerH,
                                     @RequestHeader("X-EXTERNAL-ID") String externalH,
                                     @RequestHeader("X-IP-ADDRESS") String addressH,
                                     @RequestHeader("X-DEVICE-ID") String deviceH,
                                     @RequestHeader("X-LATITUDE") String latitudeH,
                                     @RequestHeader("X-LONGITUDE") String longitudeH,
                                     @RequestHeader("CHANNEL-ID") String channelH,
                                     @RequestBody Map<String, Object> requestBody) {
        String respon = "{ \"responseCode\":\"2002400\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"inquiryStatus\":\"00\", \"inquiryReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janeDoe@email.co.id\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"inquiryRequestId\":\"abcdef-123456-abcdef\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"subCompany\":\"12345\", \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"billAmountLabel\":\"Total Tagihan\", \"billAmountValue\":\"Rp. 50.000,-\", \"additionalInfo\":{ } } ], \"freeTexts\":[{ \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ], \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : POST /1.0/transfer-va/inquiry "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/payment")
    public ResponseEntity<?> payment(@RequestHeader("Authorization") String authorizationH,
                                     @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                     @RequestHeader("X-TIMESTAMP") String timestampH,
                                     @RequestHeader("X-SIGNATURE") String signatureH,
                                     @RequestHeader("X-ORIGIN") String originH,
                                     @RequestHeader("X-PARTNER-ID") String partnerH,
                                     @RequestHeader("X-EXTERNAL-ID") String externalH,
                                     @RequestHeader("X-IP-ADDRESS") String addressH,
                                     @RequestHeader("X-DEVICE-ID") String deviceH,
                                     @RequestHeader("X-LATITUDE") String latitudeH,
                                     @RequestHeader("X-LONGITUDE") String longitudeH,
                                     @RequestHeader("CHANNEL-ID") String channelH,
                                     @RequestBody Map<String, Object> requestBody) {
        String respon = "{\"responseCode\":\"2002500\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"paymentFlagReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"paymentRequestId\":\"abcdef-123456-abcdef\", \"paidAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"paidBills\":\"95000\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"trxDateTime\":\"20201231T235959Z\", \"referenceNo\":\"123456789012345\", \"journalNum\":\"123456\", \"paymentType\":1, \"flagAdvise\":\"Y\", \"paymentFlagStatus\":\"00\", \"billDetails\":[ { \"billerReferenceId\":\"123456789012345678\", \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\"}, \"additionalInfo\":{ }, \"status\":\"00\", \"reason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ] }, \"additionalInfo\":{ } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : POST /1.0/transfer-va/payment "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @GetMapping("/status")
    public ResponseEntity<?> status(@RequestHeader("Authorization") String authorizationH,
                                    @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                    @RequestHeader("X-TIMESTAMP") String timestampH,
                                    @RequestHeader("X-SIGNATURE") String signatureH,
                                    @RequestHeader("X-ORIGIN") String originH,
                                    @RequestHeader("X-PARTNER-ID") String partnerH,
                                    @RequestHeader("X-EXTERNAL-ID") String externalH,
                                    @RequestHeader("X-IP-ADDRESS") String addressH,
                                    @RequestHeader("X-DEVICE-ID") String deviceH,
                                    @RequestHeader("X-LATITUDE") String latitudeH,
                                    @RequestHeader("X-LONGITUDE") String longitudeH,
                                    @RequestHeader("CHANNEL-ID") String channelH,
                                    @RequestBody Map<String, Object> requestBody) {
        String respon = "{ \"responseCode\":\"2002600\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"paymentFlagReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"inquiryRequestId\":\"abcdef-123456-abcdef\", \"paymentRequestId\":\"abcdef-123456-abcdef\", \"paidAmount\":[ { \"value\":\"12345678.00\", \"currency\":\"IDR\" } ], \"paidBills\":\"95000\", \"totalAmount\":[ { \"value\":\"12345678.00\", \"currency\":\"IDR\" } ], \"trxDateTime\":\"20201231T235959Z\", \"transactionDate\":\"20201230T235959Z\", \"referenceNo\":\"123456789012345\", \"paymentType\":1, \"flagAdvise\":\"Y\", \"paymentFlagStatus\":\"00\", \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ }, \"billReferenceNo\":\"123456789012345\", \"status\":\"00\", \"reason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ] }, \"additionalInfo\":{ } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : GET /1.0/transfer-va/status "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/create-va")
    public ResponseEntity<?> createVa(@RequestHeader("Authorization") String authorizationH,
                                      @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                      @RequestHeader("X-TIMESTAMP") String timestampH,
                                      @RequestHeader("X-SIGNATURE") String signatureH,
                                      @RequestHeader("X-ORIGIN") String originH,
                                      @RequestHeader("X-PARTNER-ID") String partnerH,
                                      @RequestHeader("X-EXTERNAL-ID") String externalH,
                                      @RequestHeader("X-IP-ADDRESS") String addressH,
                                      @RequestHeader("X-DEVICE-ID") String deviceH,
                                      @RequestHeader("X-LATITUDE") String latitudeH,
                                      @RequestHeader("X-LONGITUDE") String longitudeH,
                                      @RequestHeader("CHANNEL-ID") String channelH,
                                      @RequestBody Map<String, Object> requestBody) {
        String respon = "";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : POST /1.0/transfer-va/create-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PutMapping("/update-va")
    public ResponseEntity<?> updateVa(@RequestHeader("Authorization") String authorizationH,
                                      @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                      @RequestHeader("X-TIMESTAMP") String timestampH,
                                      @RequestHeader("X-SIGNATURE") String signatureH,
                                      @RequestHeader("X-ORIGIN") String originH,
                                      @RequestHeader("X-PARTNER-ID") String partnerH,
                                      @RequestHeader("X-EXTERNAL-ID") String externalH,
                                      @RequestHeader("X-IP-ADDRESS") String addressH,
                                      @RequestHeader("X-DEVICE-ID") String deviceH,
                                      @RequestHeader("X-LATITUDE") String latitudeH,
                                      @RequestHeader("X-LONGITUDE") String longitudeH,
                                      @RequestHeader("CHANNEL-ID") String channelH,
                                      @RequestBody Map<String, Object> requestBody) {
        String respon = "{ \"responseCode\":\"2002800\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{\"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ } } ], \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"expiredDate\":\"2020-12-31T23:59:59-07:00\", \"lastUpdateDate\":\"2020-12-31T23:59:59-07:00\", \"paymentDate\":\"2020-12-31T23:59:59-07:00\", \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : PUT /1.0/transfer-va/update-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PutMapping("/update-status")
    public ResponseEntity<?> updateStatus(@RequestHeader("Authorization") String authorizationH,
                                          @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                          @RequestHeader("X-TIMESTAMP") String timestampH,
                                          @RequestHeader("X-SIGNATURE") String signatureH,
                                          @RequestHeader("X-ORIGIN") String originH,
                                          @RequestHeader("X-PARTNER-ID") String partnerH,
                                          @RequestHeader("X-EXTERNAL-ID") String externalH,
                                          @RequestHeader("X-IP-ADDRESS") String addressH,
                                          @RequestHeader("X-DEVICE-ID") String deviceH,
                                          @RequestHeader("X-LATITUDE") String latitudeH,
                                          @RequestHeader("X-LONGITUDE") String longitudeH,
                                          @RequestHeader("CHANNEL-ID") String channelH,
                                          @RequestBody Map<String, Object> requestBody) {
        String respon = "{ \"responseCode\":\"2002900\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"expiredDate\":\"2020-12-31T23:59:59-07:00\", \"lastUpdateDate\":\"2020-12-31T23:59:59-07:00\", \"paymentDate\":\"2020-12-31T23:59:59-07:00\", \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : PUT /1.0/transfer-va/update-status "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @GetMapping("/inquiry-va")
    public ResponseEntity<?> inquiryVa(@RequestHeader("Authorization") String authorizationH,
                                       @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                       @RequestHeader("X-TIMESTAMP") String timestampH,
                                       @RequestHeader("X-SIGNATURE") String signatureH,
                                       @RequestHeader("X-ORIGIN") String originH,
                                       @RequestHeader("X-PARTNER-ID") String partnerH,
                                       @RequestHeader("X-EXTERNAL-ID") String externalH,
                                       @RequestHeader("X-IP-ADDRESS") String addressH,
                                       @RequestHeader("X-DEVICE-ID") String deviceH,
                                       @RequestHeader("X-LATITUDE") String latitudeH,
                                       @RequestHeader("X-LONGITUDE") String longitudeH,
                                       @RequestHeader("CHANNEL-ID") String channelH,
                                       @RequestBody Map<String, Object> requestBody) {
        String respon = "{ \"responseCode\":2003000, \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"billDetails\":[ {\"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ], \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"expiredDate\":\"2020-12-31T23:59:59-07:00\", \"lastUpdateDate\":\"2020-12-31T23:59:59-07:00\", \"paymentDate\":\"2020-12-31T23:59:59-07:00\", \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : GET /1.0/transfer-va/inquiry-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @DeleteMapping("/delete-va")
    public ResponseEntity<?> deleteVa(@RequestHeader("Authorization") String authorizationH,
                                      @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                      @RequestHeader("X-TIMESTAMP") String timestampH,
                                      @RequestHeader("X-SIGNATURE") String signatureH,
                                      @RequestHeader("X-ORIGIN") String originH,
                                      @RequestHeader("X-PARTNER-ID") String partnerH,
                                      @RequestHeader("X-EXTERNAL-ID") String externalH,
                                      @RequestHeader("X-IP-ADDRESS") String addressH,
                                      @RequestHeader("X-DEVICE-ID") String deviceH,
                                      @RequestHeader("X-LATITUDE") String latitudeH,
                                      @RequestHeader("X-LONGITUDE") String longitudeH,
                                      @RequestHeader("CHANNEL-ID") String channelH,
                                      @RequestBody Map<String, Object> requestBody) {
        String respon = "{ \"responseCode\":\"2003100\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"trxId\":\"abcdefgh1234\", \"additionalInfo\":{ } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : DELETE /1.0/transfer-va/delete-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @GetMapping("/inquiry-intrabank")
    public ResponseEntity<?> inquiryIntrabank(@RequestHeader("Authorization") String authorizationH,
                                              @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                              @RequestHeader("X-TIMESTAMP") String timestampH,
                                              @RequestHeader("X-SIGNATURE") String signatureH,
                                              @RequestHeader("X-ORIGIN") String originH,
                                              @RequestHeader("X-PARTNER-ID") String partnerH,
                                              @RequestHeader("X-EXTERNAL-ID") String externalH,
                                              @RequestHeader("X-IP-ADDRESS") String addressH,
                                              @RequestHeader("X-DEVICE-ID") String deviceH,
                                              @RequestHeader("X-LATITUDE") String latitudeH,
                                              @RequestHeader("X-LONGITUDE") String longitudeH,
                                              @RequestHeader("CHANNEL-ID") String channelH,
                                              @RequestBody Map<String, Object> requestBody) {
        String respon = "{ \"responseCode\":2003200, \"responseMessage\":\"Success\", \"virtualAccountdata\":{ \"inquiryStatus\":\"00\", \"inquiryReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"partnerReferenceNo\":\"abcdef-123456-abcdef\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janeDoe@email.co.id\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"sourceAccountNo\":\"1234567890\", \"sourceAccountType\":\"S\", \"inquiryRequestId\":\"abcdef-123456-abcdef\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"billAmountLabel\":\"Total Tagihan\", \"billAmountValue\":\"Rp. 50.000,-\", \"additionalInfo\":{ } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"productName\":\"Pendidikan\", \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : GET /1.0/transfer-va/inquiry-intrabank "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/payment-intrabank")
    public ResponseEntity<?> paymentIntrabank(@RequestHeader("Authorization") String authorizationH,
                                              @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                              @RequestHeader("X-TIMESTAMP") String timestampH,
                                              @RequestHeader("X-SIGNATURE") String signatureH,
                                              @RequestHeader("X-ORIGIN") String originH,
                                              @RequestHeader("X-PARTNER-ID") String partnerH,
                                              @RequestHeader("X-EXTERNAL-ID") String externalH,
                                              @RequestHeader("X-IP-ADDRESS") String addressH,
                                              @RequestHeader("X-DEVICE-ID") String deviceH,
                                              @RequestHeader("X-LATITUDE") String latitudeH,
                                              @RequestHeader("X-LONGITUDE") String longitudeH,
                                              @RequestHeader("CHANNEL-ID") String channelH,
                                              @RequestBody Map<String, Object> requestBody) {
        String respon = "";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : POST /1.0/transfer-va/payment-intrabank "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/notify-payment-intrabank")
    public ResponseEntity<?> notifyPaymentIntrabank(@RequestHeader("Authorization") String authorizationH,
                                                    @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                                    @RequestHeader("X-TIMESTAMP") String timestampH,
                                                    @RequestHeader("X-SIGNATURE") String signatureH,
                                                    @RequestHeader("X-ORIGIN") String originH,
                                                    @RequestHeader("X-PARTNER-ID") String partnerH,
                                                    @RequestHeader("X-EXTERNAL-ID") String externalH,
                                                    @RequestHeader("X-IP-ADDRESS") String addressH,
                                                    @RequestHeader("X-DEVICE-ID") String deviceH,
                                                    @RequestHeader("X-LATITUDE") String latitudeH,
                                                    @RequestHeader("X-LONGITUDE") String longitudeH,
                                                    @RequestHeader("CHANNEL-ID") String channelH,
                                                    @RequestBody Map<String, Object> requestBody) {
        String respon = "";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : POST /1.0/transfer-va/notify-payment-intrabank "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @GetMapping("/report")
    public ResponseEntity<?> report(@RequestHeader("Authorization") String authorizationH,
                                    @RequestHeader("Authorization-Customer") String authorizationcustomerH,
                                    @RequestHeader("X-TIMESTAMP") String timestampH,
                                    @RequestHeader("X-SIGNATURE") String signatureH,
                                    @RequestHeader("X-ORIGIN") String originH,
                                    @RequestHeader("X-PARTNER-ID") String partnerH,
                                    @RequestHeader("X-EXTERNAL-ID") String externalH,
                                    @RequestHeader("X-IP-ADDRESS") String addressH,
                                    @RequestHeader("X-DEVICE-ID") String deviceH,
                                    @RequestHeader("X-LATITUDE") String latitudeH,
                                    @RequestHeader("X-LONGITUDE") String longitudeH,
                                    @RequestHeader("CHANNEL-ID") String channelH,
                                    @RequestBody Map<String, Object> requestBody) {
        String respon = "{ \"responseCode\":2003500, \"responseMessage\":\"Success\", \"virtualAccountdata\":[ { \"paymentFlagReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"sourceAccountNo\":\"1234567890\", \"sourceAccountType\":\"S\", \"trxId\":\"abcdefgh1234\", \"inquiryRequestId\":\"abcdef-123456-abcdef\", \"paymentRequestId\":\"abcdef-123456-abcdef\", \"paidAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"paidBills\":\"95000\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"trxDateTime\":\"20201231T235959Z\", \"referenceNo\":\"123456789012345\", \"journalNum\":\"123456\", \"paymentType\":1, \"flagAdvise\":\"Y\", \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ }, \"status\":\"00\", \"reason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ], \"additionalInfo\":{ } } ] }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Request : GET /1.0/transfer-va/report "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }
    
}
