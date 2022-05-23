package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.operation.refinement.DeleteProfileConsentOperationRefinement;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;

/** Lower part of the Operation. It has the operation declaration with its annotations. */
public class DeleteProfileConsentOperation extends DeleteProfileConsentOperationRefinement {
  public DeleteProfileConsentOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public DeleteProfileConsentOperation() {
    super();
  }

  /**
   * Used to delete a `ProfileConsent` for a `User`. This will remove the consent and all associated
   * financial data from the 'Financial Profile'.
   *
   * <p>This operation makes an HTTP DELETE request to the
   * /users/{userUuid}/profile/consents/{profileConsentId} endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param userUuidUriParam __Mandatory__. The Yapily generated UUID for the user.
   * @param profileConsentIdUriParam __Mandatory__. The ID of the ProfileConsent
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Delete Profile Consent")
  @Summary(
      "Used to delete a `ProfileConsent` for a `User`. This will remove the consent and all associated financial data from the 'Financial Profile'.")
  public void deleteProfileConsent(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @DisplayName("User Uuid") @Summary("__Mandatory__. The Yapily generated UUID for the user.")
          String userUuidUriParam,
      @DisplayName("Profile Consent Id") @Summary("__Mandatory__. The ID of the ProfileConsent")
          String profileConsentIdUriParam,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<Void, Void> callback) {
    super.deleteProfileConsent(
        config,
        connection,
        userUuidUriParam,
        profileConsentIdUriParam,
        parameters,
        overrides,
        callback);
  }
}
