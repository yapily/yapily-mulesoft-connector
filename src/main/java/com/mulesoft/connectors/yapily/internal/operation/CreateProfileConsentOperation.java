package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.CreateProfileConsentOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.CreateProfileConsentOperationRefinement;
import java.io.InputStream;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.OutputResolver;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;

/** Lower part of the Operation. It has the operation declaration with its annotations. */
public class CreateProfileConsentOperation extends CreateProfileConsentOperationRefinement {
  public CreateProfileConsentOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public CreateProfileConsentOperation() {
    super();
  }

  /**
   * Used to add a consent to a `Financial Profile` for a `User`. The response is asynchronous,
   * returned with pending status, while retrieval of financial data is commenced. There is a limit
   * of 10,000 transactions for enrichment.
   *
   * <p>This operation makes an HTTP POST request to the /users/{userUuid}/profile/consents endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param userUuidUriParam __Mandatory__. The Yapily generated UUID for the user.
   * @param consentHeader __Mandatory__. The `consent-token` obtained from the original
   *     authorisation.
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Create Profile Consent")
  @Summary(
      "Used to add a consent to a `Financial Profile` for a `User`.  The response is asynchronous, returned with pending status, while retrieval of financial data is commenced.  There is a limit of 10,000 transactions for enrichment.")
  @MediaType("application/json")
  @OutputResolver(
      output = CreateProfileConsentOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void createProfileConsent(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @DisplayName("User Uuid") @Summary("__Mandatory__. The Yapily generated UUID for the user.")
          String userUuidUriParam,
      @DisplayName("consent")
          @Summary("__Mandatory__. The `consent-token` obtained from the original authorisation.")
          String consentHeader,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.createProfileConsent(
        config, connection, userUuidUriParam, consentHeader, parameters, overrides, callback);
  }
}
