package com.mulesoft.connectors.yapily.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.input.JsonInputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.extension.Yapily;

public class CreateConsentWithCodeInputMetadataResolver extends JsonInputMetadataResolver {
  @Override
  public String getSchemaPath() {
    return "/rest_sdk_generated_schemas/create-consent-with-code-input-schema.json";
  }

  @Override
  public String getResolverName() {
    return "create-consent-with-code-input-type-resolver";
  }

  @Override
  public String getCategoryName() {
    return Yapily.API_METADATA_CATEGORY;
  }
}
