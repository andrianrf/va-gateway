package com.multipolar.vagateway.modules.transferVa.v1;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/1.0/transfer-va")
public class transferVAv1Controller {

    @Value("${callback.notify-payment-intrabank}")
    private String callbackNotifyPaymentIntrabank;

    @SneakyThrows
    @PostMapping("/inquiry")
    public ResponseEntity<?> inquiry(@RequestHeader(value="Authorization", required=false) String authorization,
                                     @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                     @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                     @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                     @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                     @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                     @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                     @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                     @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                     @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                     @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                     @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                     @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

        String respon = "{ \"responseCode\":\"2002400\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"inquiryStatus\":\"00\", \"inquiryReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janeDoe@email.co.id\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"inquiryRequestId\":\"abcdef-123456-abcdef\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"subCompany\":\"12345\", \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"billAmountLabel\":\"Total Tagihan\", \"billAmountValue\":\"Rp. 50.000,-\", \"additionalInfo\":{ } } ], \"freeTexts\":[{ \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ], \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Header : "+header+", Request : POST /1.0/transfer-va/inquiry "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/payment")
    public ResponseEntity<?> payment(@RequestHeader(value="Authorization", required=false) String authorization,
                                     @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                     @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                     @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                     @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                     @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                     @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                     @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                     @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                     @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                     @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                     @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                     @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

        String respon = "{\"responseCode\":\"2002500\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"paymentFlagReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"paymentRequestId\":\"abcdef-123456-abcdef\", \"paidAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"paidBills\":\"95000\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"trxDateTime\":\"20201231T235959Z\", \"referenceNo\":\"123456789012345\", \"journalNum\":\"123456\", \"paymentType\":1, \"flagAdvise\":\"Y\", \"paymentFlagStatus\":\"00\", \"billDetails\":[ { \"billerReferenceId\":\"123456789012345678\", \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\"}, \"additionalInfo\":{ }, \"status\":\"00\", \"reason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ] }, \"additionalInfo\":{ } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Request : POST /1.0/transfer-va/payment, Header: "+header+", requestBody: "+requestBody+", responBody: "+responBody);

        //callback from payment to notify-payment-intrabank
        HttpResponse<JsonNode> jsonResponse
                = Unirest.post(callbackNotifyPaymentIntrabank)
                .header("Content-Type", "application/json")
                .header("Authorization", authorization)
                .header("Authorization-Customer", authorizationCustomer)
                .header("X-TIMESTAMP", xTimestamp)
                .header("X-SIGNATURE", xSignature)
                .header("X-ORIGIN", xOrigin)
                .header("X-PARTNER-ID", xPartnerId)
                .header("X-EXTERNAL-ID", xExternalId)
                .header("X-IP-ADDRESS", xIpAddress)
                .header("X-DEVICE-ID", xDeviceId)
                .header("X-LATITUDE", xLatitude)
                .header("X-LONGITUDE", xLongitude)
                .header("CHANNEL-ID", channelId)
                .body("{\n "+
                        "    \"partnerServiceId\": \""+requestBody.get("partnerServiceId")+"\",\n" +
                                "    \"customerNo\": \""+requestBody.get("customerNo")+"\",\n" +
                                "    \"virtualAccountNo\": \""+requestBody.get("virtualAccountNo")+"\",\n" +
                                "    \"inquiryRequestId\": \"abcdef-123456-abcdef\",\n" +
                                "    \"paymentRequestId\": \""+requestBody.get("paymentRequestId")+"\",\n" +
                                "    \"partnerReferenceNo\": \"abcdef-123456-abcdef\",\n" +
                                "    \"trxDateTime\": \""+requestBody.get("trxDateTime")+"\",\n" +
                                "    \"paymentStatus\": \"Success\",\n" +
                                "    \"paymentFlagReason\": {\n" +
                                "        \"english\": \"Success\",\n" +
                                "        \"indonesia\": \"Sukses\"\n" +
                                "    },\n" +
                                "    \"additionalInfo\": {}\n" +
                                "}")
                .asJson();
        log.info("callback from payment to notify-payment-intrabank => "+jsonResponse.getStatus()+" "+jsonResponse.getBody());

        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/status")
    public ResponseEntity<?> status(@RequestHeader(value="Authorization", required=false) String authorization,
                                    @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                    @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                    @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                    @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                    @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                    @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                    @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                    @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                    @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                    @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                    @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                    @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

        String respon = "{ \"responseCode\":\"2002600\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"paymentFlagReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"inquiryRequestId\":\"abcdef-123456-abcdef\", \"paymentRequestId\":\"abcdef-123456-abcdef\", \"paidAmount\":[ { \"value\":\"12345678.00\", \"currency\":\"IDR\" } ], \"paidBills\":\"95000\", \"totalAmount\":[ { \"value\":\"12345678.00\", \"currency\":\"IDR\" } ], \"trxDateTime\":\"20201231T235959Z\", \"transactionDate\":\"20201230T235959Z\", \"referenceNo\":\"123456789012345\", \"paymentType\":1, \"flagAdvise\":\"Y\", \"paymentFlagStatus\":\"00\", \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ }, \"billReferenceNo\":\"123456789012345\", \"status\":\"00\", \"reason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ] }, \"additionalInfo\":{ } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Header : "+header+", Request : GET /1.0/transfer-va/status "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/create-va")
    public ResponseEntity<?> createVa(@RequestHeader(value="Authorization", required=false) String authorization,
                                      @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                      @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                      @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                      @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                      @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                      @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                      @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                      @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                      @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                      @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                      @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                      @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

        String respon = "{\n" +
                "   \"responseCode\":\"2002700\",\n" +
                "   \"responseMessage\":\"Success\",\n" +
                "   \"virtualAccountData\":{\n" +
                "      \"partnerServiceId\":\"  088899\",\n" +
                "      \"customerNo\":\"12345678901234567890\",\n" +
                "      \"virtualAccountNo\":\"  08889912345678901234567890\",\n" +
                "      \"virtualAccountName\":\"Jokul Doe\",\n" +
                "      \"virtualAccountEmail\":\"jokul@email.com\",\n" +
                "      \"virtualAccountPhone\":\"6281828384858\",\n" +
                "      \"trxId\":\"abcdefgh1234\",\n" +
                "      \"totalAmount\":{\n" +
                "         \"value\":\"12345678.00\",\n" +
                "         \"currency\":\"IDR\"\n" +
                "      },\n" +
                "      \"billDetails\":[\n" +
                "         {\n" +
                "            \"billCode\":\"01\",\n" +
                "            \"billNo\":\"123456789012345678\",\n" +
                "            \"billName\":\"Bill A for Jan\",\n" +
                "            \"billShortName\":\"Bill A\",\n" +
                "            \"billDescription\":{\n" +
                "               \"english\":\"Maintenance\",\n" +
                "               \"indonesia\":\"Pemeliharaan\"\n" +
                "            },\n" +
                "            \"billSubCompany\":\"00001\",\n" +
                "            \"billAmount\":{\n" +
                "               \"value\":\"12345678.00\",\n" +
                "               \"currency\":\"IDR\"\n" +
                "            },\n" +
                "            \"additionalInfo\":{\n" +
                "           \n" +
                "            }\n" +
                "         }\n" +
                "      ],\n" +
                "      \"freeTexts\":[\n" +
                "         {\n" +
                "            \"english\":\"Free text\",\n" +
                "            \"indonesia\":\"Tulisan bebas\"\n" +
                "         }\n" +
                "      ],\n" +
                "      \"virtualAccountTrxType\":\"1\",\n" +
                "      \"feeAmount\":{\n" +
                "         \"value\":\"12345678.00\",\n" +
                "         \"currency\":\"IDR\"\n" +
                "      },\n" +
                "      \"expiredDate\":\"2020-12-31T23:59:59-07:00\",\n" +
                "      \"additionalInfo\":{\n" +
                "         \"deviceId\":\"12345679237\",\n" +
                "         \"channel\":\"mobilephone\"\n" +
                "      }\n" +
                "   }\n" +
                "}";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Header : "+header+", Request : POST /1.0/transfer-va/create-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PutMapping("/update-va")
    public ResponseEntity<?> updateVa(@RequestHeader(value="Authorization", required=false) String authorization,
                                      @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                      @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                      @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                      @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                      @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                      @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                      @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                      @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                      @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                      @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                      @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                      @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

        String respon = "{ \"responseCode\":\"2002800\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{\"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ } } ], \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"expiredDate\":\"2020-12-31T23:59:59-07:00\", \"lastUpdateDate\":\"2020-12-31T23:59:59-07:00\", \"paymentDate\":\"2020-12-31T23:59:59-07:00\", \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Header : "+header+", Request : PUT /1.0/transfer-va/update-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PutMapping("/update-status")
    public ResponseEntity<?> updateStatus(@RequestHeader(value="Authorization", required=false) String authorization,
                                          @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                          @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                          @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                          @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                          @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                          @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                          @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                          @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                          @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                          @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                          @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                          @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

        String respon = "{ \"responseCode\":\"2002900\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"expiredDate\":\"2020-12-31T23:59:59-07:00\", \"lastUpdateDate\":\"2020-12-31T23:59:59-07:00\", \"paymentDate\":\"2020-12-31T23:59:59-07:00\", \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Header : "+header+", Request : PUT /1.0/transfer-va/update-status "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/inquiry-va")
    public ResponseEntity<?> inquiryVa(@RequestHeader(value="Authorization", required=false) String authorization,
                                       @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                       @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                       @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                       @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                       @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                       @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                       @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                       @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                       @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                       @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                       @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                       @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

        String respon = "{ \"responseCode\":2003000, \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"trxId\":\"abcdefgh1234\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"billDetails\":[ {\"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ], \"virtualAccountTrxType\":\"1\", \"feeAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"expiredDate\":\"2020-12-31T23:59:59-07:00\", \"lastUpdateDate\":\"2020-12-31T23:59:59-07:00\", \"paymentDate\":\"2020-12-31T23:59:59-07:00\", \"additionalInfo\":{ \"deviceId\":\"12345679237\", \"channel\":\"mobilephone\" } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Header : "+header+", Request : GET /1.0/transfer-va/inquiry-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @DeleteMapping("/delete-va")
    public ResponseEntity<?> deleteVa(@RequestHeader(value="Authorization", required=false) String authorization,
                                      @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                      @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                      @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                      @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                      @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                      @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                      @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                      @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                      @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                      @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                      @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                      @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

        String respon = "{ \"responseCode\":\"2003100\", \"responseMessage\":\"Success\", \"virtualAccountData\":{ \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"trxId\":\"abcdefgh1234\", \"additionalInfo\":{ } } }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Header : "+header+", Request : DELETE /1.0/transfer-va/delete-va "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/inquiry-intrabank")
    public ResponseEntity<?> inquiryIntrabank(@RequestHeader(value="Authorization", required=false) String authorization,
                                              @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                              @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                              @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                              @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                              @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                              @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                              @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                              @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                              @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                              @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                              @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                              @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

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
        log.info("Client IP : "+request.getRemoteAddr()+", Header : "+header+", Request : GET /1.0/transfer-va/inquiry-intrabank "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/payment-intrabank")
    public ResponseEntity<?> paymentIntrabank(@RequestHeader(value="Authorization", required=false) String authorization,
                                              @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                              @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                              @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                              @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                              @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                              @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                              @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                              @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                              @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                              @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                              @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                              @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

        String respon = "{\n" +
                "   \"responseCode\":\"2003300\",\n" +
                "   \"responseMessage\":\"Success\",\n" +
                "   \"virtualAccountdata\":{\n" +
                "      \"paymentFlagReason\":{\n" +
                "         \"english\":\"Success\",\n" +
                "         \"indonesia\":\"Sukses\"\n" +
                "      },\n" +
                "      \"partnerServiceId\":\"  088899\",\n" +
                "      \"customerNo\":\"12345678901234567890\",\n" +
                "      \"virtualAccountNo\":\"  08889912345678901234567890\",\n" +
                "      \"virtualAccountName\":\"Jokul Doe\",\n" +
                "      \"virtualAccountEmail\":\"jokul@email.com\",\n" +
                "      \"virtualAccountPhone\":\"6281828384858\",\n" +
                "      \"sourceAccountNo\":\"1234567890\",\n" +
                "      \"sourceAccountType\":\"S\",\n" +
                "      \"inquiryRequestId\":\"abcdef-123456-abcdef\",\n" +
                "      \"paymentRequestId\":\"abcdef-123456-abcdef\",\n" +
                "      \"partnerReferenceNo\":\"abcdef-123456-abcdef\",\n" +
                "      \"referenceNo\":\"abcdef-123456-abcdef\",\n" +
                "      \"paidAmount\":{\n" +
                "         \"value\":\"12345678.00\",\n" +
                "         \"currency\":\"IDR\"\n" +
                "      },\n" +
                "      \"paidBills\":\"95000\",\n" +
                "      \"totalAmount\":{\n" +
                "         \"value\":\"12345678.00\",\n" +
                "         \"currency\":\"IDR\"\n" +
                "      },\n" +
                "      \"trxDateTime\":\"2020-10-20T17:56:57\",\n" +
                "      \"referenceNo\":\"123456789012345\",\n" +
                "      \"journalNum\":\"123456\",\n" +
                "      \"paymentType\":1,\n" +
                "      \"flagAdvise\":\"Y\",\n" +
                "      \"billDetails\":[\n" +
                "         {\n" +
                "            \"billCode\":\"01\",\n" +
                "            \"billNo\":\"123456789012345678\",\n" +
                "            \"billName\":\"Bill A for Jan\",\n" +
                "            \"billShortName\":\"Bill A\",\n" +
                "            \"billDescription\":{\n" +
                "               \"english\":\"Maintenance\",\n" +
                "               \"indonesia\":\"Pemeliharaan\"\n" +
                "            },\n" +
                "            \"billSubCompany\":\"00001\",\n" +
                "            \"billAmount\":{\n" +
                "               \"value\":\"12345678.00\",\n" +
                "               \"currency\":\"IDR\"\n" +
                "            },\n" +
                "            \"additionalInfo\":{\n" +
                "           \n" +
                "            },\n" +
                "            \"status\":\"00\",\n" +
                "            \"reason\":{\n" +
                "               \"english\":\"Success\",\n" +
                "               \"indonesia\":\"Sukses\"\n" +
                "            }\n" +
                "         }\n" +
                "      ],\n" +
                "      \"freeTexts\":[\n" +
                "         {\n" +
                "            \"english\":\"Free text\",\n" +
                "            \"indonesia\":\"Tulisan bebas\"\n" +
                "         }\n" +
                "      ],\n" +
                "      \"feeAmount\":{\n" +
                "         \"value\":\"12345678.00\",\n" +
                "         \"currency\":\"IDR\"\n" +
                "      },\n" +
                "      \"productName\":\"Pendidikan\"\n" +
                "   },\n" +
                "   \"additionalInfo\":{\n" +
                "  \n" +
                "   }\n" +
                "}";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Header : "+header+", Request : POST /1.0/transfer-va/payment-intrabank "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/notify-payment-intrabank")
    public ResponseEntity<?> notifyPaymentIntrabank(@RequestHeader(value="Authorization", required=false) String authorization,
                                                    @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                                    @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                                    @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                                    @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                                    @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                                    @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                                    @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                                    @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                                    @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                                    @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                                    @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                                    @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

        String respon = "{\n" +
                "   \"responseCode\":2003400,\n" +
                "   \"responseMessage\":\"Success\",\n" +
                "   \"virtualAccountdata\":{\n" +
                "      \"paymentFlagReason\":{\n" +
                "         \"english\":\"Success\",\n" +
                "         \"indonesia\":\"Sukses\"\n" +
                "      },\n" +
                "      \"partnerServiceId\":\"  088899\",\n" +
                "      \"customerNo\":12345678901234567890,\n" +
                "      \"virtualAccountNo\":\"  08889912345678901234567890\",\n" +
                "      \"inquiryRequestId\":\"abcdef-123456-abcdef\",\n" +
                "      \"paymentRequestId\":\"abcdef-123456-abcdef\",\n" +
                "      \"partnerReferenceNo\":\"abcdef-123456-abcdef\",\n" +
                "      \"trxDateTime\":\"2020-12-21T14:56:11+07:00\",\n" +
                "      \"paymentStatus\":\"In Progress\",\n" +
                "      \"additionalInfo\":{\n" +
                "     \n" +
                "      }\n" +
                "   }\n" +
                "}";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Header : "+header+", Request : POST /1.0/transfer-va/notify-payment-intrabank "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }

    @SneakyThrows
    @PostMapping("/report")
    public ResponseEntity<?> report(@RequestHeader(value="Authorization", required=false) String authorization,
                                    @RequestHeader(value="Authorization-Customer", required=false) String authorizationCustomer,
                                    @RequestHeader(value="X-TIMESTAMP", required=false) String xTimestamp,
                                    @RequestHeader(value="X-SIGNATURE", required=false) String xSignature,
                                    @RequestHeader(value="X-ORIGIN", required=false) String xOrigin,
                                    @RequestHeader(value="X-PARTNER-ID", required=false) String xPartnerId,
                                    @RequestHeader(value="X-EXTERNAL-ID", required=false) String xExternalId,
                                    @RequestHeader(value="X-IP-ADDRESS", required=false) String xIpAddress,
                                    @RequestHeader(value="X-DEVICE-ID", required=false) String xDeviceId,
                                    @RequestHeader(value="X-LATITUDE", required=false) String xLatitude,
                                    @RequestHeader(value="X-LONGITUDE", required=false) String xLongitude,
                                    @RequestHeader(value="CHANNEL-ID", required=false) String channelId,
                                    @RequestBody Map<String, Object> requestBody, HttpServletRequest request) {
        String header = "Header= Authorization: "+authorization
                +", Authorization-Customer: "+authorizationCustomer
                +", X-TIMESTAMP: "+xTimestamp
                +", X-SIGNATURE: "+xSignature
                +", X-ORIGIN: "+xOrigin
                +", X-PARTNER-ID: "+xPartnerId
                +", X-EXTERNAL-ID: "+xExternalId
                +", X-IP-ADDRESS: "+xIpAddress
                +", X-DEVICE-ID: "+xDeviceId
                +", X-LATITUDE: "+xLatitude
                +", X-LONGITUDE: "+xLongitude
                +", CHANNEL-ID: "+channelId;

        String respon = "{ \"responseCode\":2003500, \"responseMessage\":\"Success\", \"virtualAccountdata\":[ { \"paymentFlagReason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" }, \"partnerServiceId\":\" 088899\", \"customerNo\":\"12345678901234567890\", \"virtualAccountNo\":\" 08889912345678901234567890\", \"virtualAccountName\":\"Jane Doe\", \"virtualAccountEmail\":\"janedoe@email.com\", \"virtualAccountPhone\":\"62818xxxxxxxxx\", \"sourceAccountNo\":\"1234567890\", \"sourceAccountType\":\"S\", \"trxId\":\"abcdefgh1234\", \"inquiryRequestId\":\"abcdef-123456-abcdef\", \"paymentRequestId\":\"abcdef-123456-abcdef\", \"paidAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"paidBills\":\"95000\", \"totalAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"trxDateTime\":\"20201231T235959Z\", \"referenceNo\":\"123456789012345\", \"journalNum\":\"123456\", \"paymentType\":1, \"flagAdvise\":\"Y\", \"billDetails\":[ { \"billCode\":\"01\", \"billNo\":\"123456789012345678\", \"billName\":\"Bill A for Jan\", \"billShortName\":\"Bill A\", \"billDescription\":{ \"english\":\"Maintenance\", \"indonesia\":\"Pemeliharaan\" }, \"billSubCompany\":\"00001\", \"billAmount\":{ \"value\":\"12345678.00\", \"currency\":\"IDR\" }, \"additionalInfo\":{ }, \"status\":\"00\", \"reason\":{ \"english\":\"Success\", \"indonesia\":\"Sukses\" } } ], \"freeTexts\":[ { \"english\":\"Free text\", \"indonesia\":\"Tulisan bebas\" } ], \"additionalInfo\":{ } } ] }";
        ObjectMapper objectMapper =
                new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        objectMapper.registerModule(new JavaTimeModule());
        Map<String, Object> responBody = objectMapper.readValue(respon, Map.class);
        log.info("Client IP : "+request.getRemoteAddr()+", Header : "+header+", Request : GET /1.0/transfer-va/report "+requestBody+", Response : "+responBody);
        return ResponseEntity.ok().body(responBody);
    }
    
}
