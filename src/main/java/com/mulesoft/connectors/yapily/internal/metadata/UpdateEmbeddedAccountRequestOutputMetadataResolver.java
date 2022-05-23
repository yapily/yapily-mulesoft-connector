package com.mulesoft.connectors.yapily.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.output.JsonOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.extension.Yapily;

public class UpdateEmbeddedAccountRequestOutputMetadataResolver extends JsonOutputMetadataResolver {
  @Override
  public String getSchemaPath() {
    return "/rest_sdk_generated_schemas/initiate-embedded-account-request-output-schema.json";
  }

  @Override
  public String getResolverName() {
    return "update-embedded-account-request-output-type-resolver";
  }

  @Override
  public String getCategoryName() {
    return Yapily.API_METADATA_CATEGORY;
  }
}
