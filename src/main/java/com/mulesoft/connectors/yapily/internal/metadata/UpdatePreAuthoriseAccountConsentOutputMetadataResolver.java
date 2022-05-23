package com.mulesoft.connectors.yapily.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.output.JsonOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.extension.Yapily;

public class UpdatePreAuthoriseAccountConsentOutputMetadataResolver
    extends JsonOutputMetadataResolver {
  @Override
  public String getSchemaPath() {
    return "/rest_sdk_generated_schemas/re-authorise-account-output-schema.json";
  }

  @Override
  public String getResolverName() {
    return "update-pre-authorise-account-consent-output-type-resolver";
  }

  @Override
  public String getCategoryName() {
    return Yapily.API_METADATA_CATEGORY;
  }
}
