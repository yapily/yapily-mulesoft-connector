package com.mulesoft.connectors.yapily.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.input.JsonInputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.extension.Yapily;

public class CreateBulkPaymentAuthorisationInputMetadataResolver extends JsonInputMetadataResolver {
  @Override
  public String getSchemaPath() {
    return "/rest_sdk_generated_schemas/create-bulk-payment-authorisation-input-schema.json";
  }

  @Override
  public String getResolverName() {
    return "create-bulk-payment-authorisation-input-type-resolver";
  }

  @Override
  public String getCategoryName() {
    return Yapily.API_METADATA_CATEGORY;
  }
}
