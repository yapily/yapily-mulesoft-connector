package com.mulesoft.connectors.yapily.internal.connection.provider;

import com.mulesoft.connectors.yapily.internal.connection.provider.refinement.BasicAuthConnectionProviderRefinement;
import org.mule.runtime.extension.api.annotation.Alias;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;

/**
 * This is the last layer of the connection provider generation gap pattern. It is what finally gets
 * exposed as the connection provider, including all customizations made in the refinement layer.
 */
@Alias("basic-auth")
@DisplayName("Basic Auth Connection Provider")
public class BasicAuthConnectionProvider extends BasicAuthConnectionProviderRefinement {}
