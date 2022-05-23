package com.mulesoft.connectors.yapily.api.metadata;

public enum GetTransactionsOperationSortQueryParamEnum {
  DATE("-date");

  private String value;

  GetTransactionsOperationSortQueryParamEnum(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
