package com.mulesoft.connectors.yapily.internal.metadata;

import com.mulesoft.connectivity.rest.commons.api.datasense.metadata.output.StringOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.extension.Yapily;

public class GetStatementFileOutputMetadataResolver extends StringOutputMetadataResolver {
  @Override
  public String getResolverName() {
    return "get-statement-file-output-type-resolver";
  }

  @Override
  public String getCategoryName() {
    return Yapily.API_METADATA_CATEGORY;
  }
}
