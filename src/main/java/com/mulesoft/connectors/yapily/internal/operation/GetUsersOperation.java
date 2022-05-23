package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.GetUsersOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.GetUsersOperationRefinement;
import java.io.InputStream;
import java.util.List;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.OutputResolver;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.NullSafe;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;

/** Lower part of the Operation. It has the operation declaration with its annotations. */
public class GetUsersOperation extends GetUsersOperationRefinement {
  public GetUsersOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetUsersOperation() {
    super();
  }

  /**
   * Get all the users configured in your application
   *
   * <p>This operation makes an HTTP GET request to the /users endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param filterapplicationUserIdQueryParams __Optional__. Filter records based on the list of
   *     `applicationUserId` users provided.
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Get Users")
  @Summary("Get all the users configured in your application")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = GetUsersOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void getUsers(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Optional
          @NullSafe
          @DisplayName("Filter[application User Id]")
          @Summary(
              "__Optional__. Filter records based on the list of `applicationUserId` users provided.")
          List<String> filterapplicationUserIdQueryParams,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.getUsers(
        config, connection, filterapplicationUserIdQueryParams, parameters, overrides, callback);
  }
}
