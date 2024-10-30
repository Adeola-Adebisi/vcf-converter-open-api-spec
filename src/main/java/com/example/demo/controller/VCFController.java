package com.example.demo.controller;

import com.example.demo.service.api.VcfApi;
import com.example.demo.service.model.AccountInformationResponseDto;
import com.example.demo.service.model.AuthenticationDto;
import com.example.demo.service.model.AuthenticationResponseDto;
import com.example.demo.service.model.CardholderInformationResponseDto;
import com.example.demo.service.model.CompanyInformationResponseDto;
import com.example.demo.service.model.TransactionInformationResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VCFController extends RequestContextProvider implements VcfApi {
  @Override
  public ResponseEntity<AccountInformationResponseDto> getAccountInformation(String instid)
      throws Exception {
    return ResponseEntity.ok(VcfApi.super.getAccountInformation(instid).getBody());
  }
  @Override
  public ResponseEntity<AuthenticationResponseDto> authentication(
          AuthenticationDto authenticationDto) throws Exception {
    return ResponseEntity.ok(VcfApi.super.authentication(authenticationDto).getBody());
  }
  @Override
  public ResponseEntity<CardholderInformationResponseDto> getCardholderInformation(String instid)
          throws Exception {
    return ResponseEntity.ok(VcfApi.super.getCardholderInformation(instid).getBody());
  }
  @Override
  public ResponseEntity<CompanyInformationResponseDto> getCompanyInformation(String instid)
          throws Exception {
    return ResponseEntity.ok(VcfApi.super.getCompanyInformation(instid).getBody());
  }
  @Override
  public ResponseEntity<TransactionInformationResponseDto> getTransactionInformation(String instid, Integer startDate, Integer endDate) throws Exception {
    return ResponseEntity.ok(VcfApi.super.getTransactionInformation(instid, startDate, endDate).getBody());
  }
}
