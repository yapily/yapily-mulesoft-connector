package com.mulesoft.connectors.yapily.api.metadata;

public enum GetStatementsOperationSortQueryParamEnum {
  DATE("-date");

  private String value;

  GetStatementsOperationSortQueryParamEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
