package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.GetConsentBySingleAccessConsentInputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.GetConsentBySingleAccessConsentOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.GetConsentBySingleAccessConsentOperationRefinement;
import java.io.InputStream;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.api.metadata.TypedValue;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.OutputResolver;
import org.mule.runtime.extension.api.annotation.metadata.TypeResolver;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.Content;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;

/** Lower part of the Operation. It has the operation declaration with its annotations. */
public class GetConsentBySingleAccessConsentOperation
    extends GetConsentBySingleAccessConsentOperationRefinement {
  public GetConsentBySingleAccessConsentOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetConsentBySingleAccessConsentOperation() {
    super();
  }

  /**
   * Exchange a One-time-token for the consent token
   *
   * <p>This operation makes an HTTP POST request to the /consent-one-time-token endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param getConsentBySingleAccessConsentBody the content to use
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Get Consent By Single Access Consent")
  @Summary("Exchange a One-time-token for the consent token")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = GetConsentBySingleAccessConsentOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void getConsentBySingleAccessConsent(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Content(primary = true)
          @DisplayName("Body")
          @Summary("The request body containing the `OneTimeTokenRequest` json payload")
          @TypeResolver(GetConsentBySingleAccessConsentInputMetadataResolver.class)
          TypedValue<InputStream> getConsentBySingleAccessConsentBody,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.getConsentBySingleAccessConsent(
        config, connection, getConsentBySingleAccessConsentBody, parameters, overrides, callback);
  }
}
