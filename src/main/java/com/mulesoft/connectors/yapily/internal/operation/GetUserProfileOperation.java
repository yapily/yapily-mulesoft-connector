package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.GetUserProfileOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.GetUserProfileOperationRefinement;
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
public class GetUserProfileOperation extends GetUserProfileOperationRefinement {
  public GetUserProfileOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetUserProfileOperation() {
    super();
  }

  /**
   * Used to retrieve a `TransactionGroups` for a `User`. Status will be `PENDING` until all
   * ProfileConsents are `COMPLETED`.
   *
   * <p>This operation makes an HTTP GET request to the /users/{userUuid}/profile/transaction-groups
   * endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param userUuidUriParam __Mandatory__. The Yapily generated UUID for the user.
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Get User Profile")
  @Summary(
      "Used to retrieve a `TransactionGroups` for a `User`.  Status will be `PENDING` until all ProfileConsents are `COMPLETED`.")
  @MediaType("application/json")
  @OutputResolver(
      output = GetUserProfileOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void getUserProfile(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @DisplayName("User Uuid") @Summary("__Mandatory__. The Yapily generated UUID for the user.")
          String userUuidUriParam,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.getUserProfile(config, connection, userUuidUriParam, parameters, overrides, callback);
  }
}
