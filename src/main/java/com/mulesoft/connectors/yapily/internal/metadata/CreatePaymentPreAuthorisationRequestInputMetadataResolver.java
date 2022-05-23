package com.mulesoft.connectors.yapily.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.input.JsonInputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.extension.Yapily;

public class CreatePaymentPreAuthorisationRequestInputMetadataResolver
    extends JsonInputMetadataResolver {
  @Override
  public String getSchemaPath() {
    return "/rest_sdk_generated_schemas/create-payment-pre-authorisation-request-input-schema.json";
  }

  @Override
  public String getResolverName() {
    return "create-payment-pre-authorisation-request-input-type-resolver";
  }

  @Override
  public String getCategoryName() {
    return Yapily.API_METADATA_CATEGORY;
  }
}
