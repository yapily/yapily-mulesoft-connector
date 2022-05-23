package com.mulesoft.connectors.yapily.internal.metadata;

import com.mulesoft.connectors.yapily.internal.extension.Yapily;

/**
 * Metadata output attributes resolver for {@link
 * com.mulesoft.connectivity.rest.commons.api.operation.HttpResponseAttributes}.
 */
public class HttpResponseAttributesMetadataResolver
    extends com.mulesoft.connectivity.rest.commons.api.datasense.metadata.output
        .HttpResponseAttributesMetadataResolver {
  @Override
  public String getCategoryName() {
    return Yapily.API_METADATA_CATEGORY;
  }
}
