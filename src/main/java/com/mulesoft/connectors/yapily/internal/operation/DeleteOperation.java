package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.DeleteOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.DeleteOperationRefinement;
import java.io.InputStream;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.OutputResolver;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;

/** Lower part of the Operation. It has the operation declaration with its annotations. */
public class DeleteOperation extends DeleteOperationRefinement {
  public DeleteOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public DeleteOperation() {
    super();
  }

  /**
   * Delete a consent using the consent Id
   *
   * <p>This operation makes an HTTP DELETE request to the /consents/{consentId} endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param consentIdUriParam __Mandatory__. The consent Id of the `Consent` to update.
   * @param forceDeleteQueryParam __Optional__. Whether to force the deletion.
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Delete")
  @Summary("Delete a consent using the consent Id")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = DeleteOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void delete(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @DisplayName("Consent Id")
          @Summary("__Mandatory__. The consent Id of the `Consent` to update.")
          String consentIdUriParam,
      @Optional(defaultValue = "true")
          @DisplayName("Force Delete")
          @Summary("__Optional__. Whether to force the deletion.")
          boolean forceDeleteQueryParam,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.delete(
        config,
        connection,
        consentIdUriParam,
        forceDeleteQueryParam,
        parameters,
        overrides,
        callback);
  }
}
