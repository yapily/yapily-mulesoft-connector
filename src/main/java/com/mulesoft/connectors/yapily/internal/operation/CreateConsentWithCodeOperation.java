package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.CreateConsentWithCodeInputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.CreateConsentWithCodeOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.CreateConsentWithCodeOperationRefinement;
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
public class CreateConsentWithCodeOperation extends CreateConsentWithCodeOperationRefinement {
  public CreateConsentWithCodeOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public CreateConsentWithCodeOperation() {
    super();
  }

  /**
   * Used to obtain a Yapily Consent object containing the `consentToken` once the user has
   * authenticated and you have an OAuth2 authorisation code `auth-code` and state `auth-state`.
   *
   * <p>This operation makes an HTTP POST request to the /consent-auth-code endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param createConsentWithCodeBody the content to use
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Create Consent With Code")
  @Summary(
      "Used to obtain a Yapily Consent object containing the `consentToken` once the user has authenticated and you have an OAuth2 authorisation code `auth-code` and state `auth-state`.")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = CreateConsentWithCodeOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void createConsentWithCode(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Content(primary = true)
          @DisplayName("Body")
          @Summary("The request body containing the `ConsentAuthCodeRequest` json payload")
          @TypeResolver(CreateConsentWithCodeInputMetadataResolver.class)
          TypedValue<InputStream> createConsentWithCodeBody,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.createConsentWithCode(
        config, connection, createConsentWithCodeBody, parameters, overrides, callback);
  }
}
