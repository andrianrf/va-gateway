package com.multipolar.vagateway.modules.transferVa.v1;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/1.0/transfer-va")
public class transferVAv1Controller {

    @PostMapping("/inquiry")
    public ResponseEntity<?> inquiry(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountData", "");
        responseBody.put("inquiryStatus", "");
        responseBody.put("inquiryReason", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("virtualAccountName", "");
        responseBody.put("virtualAccountEmail", "");
        responseBody.put("virtualAccountPhone", "");
        responseBody.put("inquiryRequestId", "");
        responseBody.put("totalAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("subCompany", "");
        responseBody.put("billDetails", "");
        responseBody.put("billCode", "");
        responseBody.put("billNo", "");
        responseBody.put("billName", "");
        responseBody.put("billShortName", "");
        responseBody.put("billDescription", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("billSubCompany", "");
        responseBody.put("billAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("billAmountLabel", "");
        responseBody.put("billAmountValue", "");
        responseBody.put("additionalInfo", "");
        responseBody.put("freeTexts", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("virtualAccountTrxType", "");
        responseBody.put("feeAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : POST /1.0/transfer-va/inquiry "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }

    @PostMapping("/payment")
    public ResponseEntity<?> payment(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountData", "");
        responseBody.put("paymentFlagReason", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("virtualAccountName", "");
        responseBody.put("virtualAccountEmail", "");
        responseBody.put("virtualAccountPhone", "");
        responseBody.put("trxId", "");
        responseBody.put("paymentRequestId", "");
        responseBody.put("paidAmount", "");
        responseBody.put("Currency", "");
        responseBody.put("paidBills", "");
        responseBody.put("totalAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("trxDateTime", "");
        responseBody.put("referenceNo", "");
        responseBody.put("journalNum", "");
        responseBody.put("paymentType", "");
        responseBody.put("flagAdvise", "");
        responseBody.put("paymentFlagStatus", "");
        responseBody.put("billDetails", "");
        responseBody.put("billerReferenceId", "");
        responseBody.put("billCode", "");
        responseBody.put("billNo", "");
        responseBody.put("billName", "");
        responseBody.put("billShortName", "");
        responseBody.put("billDescription", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("billSubCompany", "");
        responseBody.put("billAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("additionalInfo", "");
        responseBody.put("status", "");
        responseBody.put("reason", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("freeTexts", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : POST /1.0/transfer-va/payment "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("/status")
    public ResponseEntity<?> status(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountData", "");
        responseBody.put("paymentFlagReason", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("inquiryRequestId", "");
        responseBody.put("paymentRequestId", "");
        responseBody.put("paidAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("paidBills", "");
        responseBody.put("totalAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("trxDateTime", "");
        responseBody.put("transactionDate", "");
        responseBody.put("referenceNo", "");
        responseBody.put("paymentType", "");
        responseBody.put("flagAdvise", "");
        responseBody.put("paymentFlagStatus", "");
        responseBody.put("billDetails", "");
        responseBody.put("billCode", "");
        responseBody.put("billNo", "");
        responseBody.put("billName", "");
        responseBody.put("billShortName", "");
        responseBody.put("billDescription", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("billSubCompany", "");
        responseBody.put("billAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("additionalInfo", "");
        responseBody.put("billReferenceNo", "");
        responseBody.put("status", "");
        responseBody.put("reason", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("freeTexts", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : GET /1.0/transfer-va/status "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }

    @PostMapping("/create-va")
    public ResponseEntity<?> createVa(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountData", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("virtualAccountName", "");
        responseBody.put("virtualAccountEmail", "");
        responseBody.put("virtualAccountPhone", "");
        responseBody.put("trxId", "");
        responseBody.put("totalAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("billDetails", "");
        responseBody.put("billCode", "");
        responseBody.put("billNo", "");
        responseBody.put("billName", "");
        responseBody.put("billShortName", "");
        responseBody.put("billDescription", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("billSubCompany", "");
        responseBody.put("billAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("additionalInfo", "");
        responseBody.put("freeTexts", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("virtualAccountTrxType", "");
        responseBody.put("feeAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("expiredDate", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : POST /1.0/transfer-va/create-va "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }

    @PutMapping("/update-va")
    public ResponseEntity<?> updateVa(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountData", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("virtualAccountName", "");
        responseBody.put("virtualAccountEmail", "");
        responseBody.put("virtualAccountPhone", "");
        responseBody.put("trxId", "");
        responseBody.put("totalAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("billDetails", "");
        responseBody.put("billCode", "");
        responseBody.put("billNo", "");
        responseBody.put("billName", "");
        responseBody.put("billShortName", "");
        responseBody.put("billDescription", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("billSubCompany", "");
        responseBody.put("billAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("additionalInfo", "");
        responseBody.put("virtualAccountTrxType", "");
        responseBody.put("feeAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("expiredDate", "");
        responseBody.put("lastUpdateDate", "");
        responseBody.put("paymentDate", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : PUT /1.0/transfer-va/update-va "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }

    @PutMapping("/update-status")
    public ResponseEntity<?> updateStatus(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountData", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("virtualAccountName", "");
        responseBody.put("virtualAccountEmail", "");
        responseBody.put("virtualAccountPhone", "");
        responseBody.put("trxId", "");
        responseBody.put("totalAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("virtualAccountTrxType", "");
        responseBody.put("feeAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("expiredDate", "");
        responseBody.put("lastUpdateDate", "");
        responseBody.put("paymentDate", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : PUT /1.0/transfer-va/update-status "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("/inquiry-va")
    public ResponseEntity<?> inquiryVa(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountData", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("virtualAccountName", "");
        responseBody.put("virtualAccountEmail", "");
        responseBody.put("virtualAccountPhone", "");
        responseBody.put("trxId", "");
        responseBody.put("totalAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("billDetails", "");
        responseBody.put("billCode", "");
        responseBody.put("billNo", "");
        responseBody.put("billName", "");
        responseBody.put("billShortName", "");
        responseBody.put("billDescription", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("billSubCompany", "");
        responseBody.put("billAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("additionalInfo", "");
        responseBody.put("freeTexts", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("virtualAccountTrxType", "");
        responseBody.put("feeAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("expiredDate", "");
        responseBody.put("lastUpdateDate", "");
        responseBody.put("paymentDate", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : GET /1.0/transfer-va/inquiry-va "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }

    @DeleteMapping("/delete-va")
    public ResponseEntity<?> deleteVa(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountData", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("trxId", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : DELETE /1.0/transfer-va/delete-va "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("/inquiry-intrabank")
    public ResponseEntity<?> inquiryIntrabank(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountData", "");
        responseBody.put("inquiryStatus", "");
        responseBody.put("inquiryReason", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("partnerReferenceNo", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("virtualAccountName", "");
        responseBody.put("virtualAccountEmail", "");
        responseBody.put("virtualAccountPhone", "");
        responseBody.put("sourceAccountNo", "");
        responseBody.put("sourceAccountType", "");
        responseBody.put("inquiryRequestId", "");
        responseBody.put("totalAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("billDetails", "");
        responseBody.put("billCode", "");
        responseBody.put("billNo", "");
        responseBody.put("billName", "");
        responseBody.put("billShortName", "");
        responseBody.put("billDescription", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("billSubCompany", "");
        responseBody.put("billAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("billAmountLabel", "");
        responseBody.put("billAmountValue", "");
        responseBody.put("additionalInfo", "");
        responseBody.put("freeTexts", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("virtualAccountTrxType", "");
        responseBody.put("feeAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("productName", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : GET /1.0/transfer-va/inquiry-intrabank "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }

    @PostMapping("/payment-intrabank")
    public ResponseEntity<?> paymentIntrabank(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountdata", "");
        responseBody.put("paymentFlagReason", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("virtualAccountName", "");
        responseBody.put("virtualAccountEmail", "");
        responseBody.put("virtualAccountPhone", "");
        responseBody.put("sourceAccountNo", "");
        responseBody.put("sourceAccountType", "");
        responseBody.put("inquiryRequestId", "");
        responseBody.put("paymentRequestId", "");
        responseBody.put("partnerReferenceNo", "");
        responseBody.put("referenceNo", "");
        responseBody.put("paidAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("paidBills", "");
        responseBody.put("totalAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("trxDateTime", "");
        responseBody.put("referenceNo", "");
        responseBody.put("journalNum", "");
        responseBody.put("paymentType", "");
        responseBody.put("flagAdvise", "");
        responseBody.put("billDetails", "");
        responseBody.put("billCode", "");
        responseBody.put("billNo", "");
        responseBody.put("billName", "");
        responseBody.put("billShortName", "");
        responseBody.put("billDescription", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("billSubCompany", "");
        responseBody.put("billAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("additionalInfo", "");
        responseBody.put("status", "");
        responseBody.put("reason", "");
        responseBody.put("indonesia", "");
        responseBody.put("english", "");
        responseBody.put("freeTexts", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("feeAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("productName", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : POST /1.0/transfer-va/payment-intrabank "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }

    @PostMapping("/notify-payment-intrabank")
    public ResponseEntity<?> notifyPaymentIntrabank(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountdata", "");
        responseBody.put("paymentFlagReason", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("inquiryRequestId", "");
        responseBody.put("paymentRequestId", "");
        responseBody.put("partnerReferenceNo", "");
        responseBody.put("trxDateTime", "");
        responseBody.put("paymentStatus", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : POST /1.0/transfer-va/notify-payment-intrabank "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping("/report")
    public ResponseEntity<?> report(@RequestBody Map<String, Object> requestBody) {
        Map<String, Object> responseBody = new HashMap<>();
        responseBody.put("responseCode", "");
        responseBody.put("responseMessage", "");
        responseBody.put("virtualAccountdata", "");
        responseBody.put("paymentFlagReason", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("partnerServiceId", "");
        responseBody.put("customerNo", "");
        responseBody.put("virtualAccountNo", "");
        responseBody.put("virtualAccountName", "");
        responseBody.put("virtualAccountEmail", "");
        responseBody.put("virtualAccountPhone", "");
        responseBody.put("sourceAccountNo", "");
        responseBody.put("sourceAccountType", "");
        responseBody.put("trxId", "");
        responseBody.put("inquiryRequestId", "");
        responseBody.put("paymentRequestId", "");
        responseBody.put("paidAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("paidBills", "");
        responseBody.put("totalAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("trxDateTime", "");
        responseBody.put("referenceNo", "");
        responseBody.put("journalNum", "");
        responseBody.put("paymentType", "");
        responseBody.put("flagAdvise", "");
        responseBody.put("billDetails", "");
        responseBody.put("billCode", "");
        responseBody.put("billNo", "");
        responseBody.put("billName", "");
        responseBody.put("billShortName", "");
        responseBody.put("billDescription", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("billSubCompany", "");
        responseBody.put("billAmount", "");
        responseBody.put("Value", "");
        responseBody.put("Currency", "");
        responseBody.put("additionalInfo", "");
        responseBody.put("status", "");
        responseBody.put("reason", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("freeTexts", "");
        responseBody.put("english", "");
        responseBody.put("indonesia", "");
        responseBody.put("additionalInfo", "");

        log.info("Request : GET /1.0/transfer-va/report "+requestBody+", Response : "+responseBody);
        return ResponseEntity.ok().body(responseBody);
    }
    
}
