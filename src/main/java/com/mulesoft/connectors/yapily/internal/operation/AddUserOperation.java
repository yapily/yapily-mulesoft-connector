package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.AddUserInputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.AddUserOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.AddUserOperationRefinement;
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
public class AddUserOperation extends AddUserOperationRefinement {
  public AddUserOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public AddUserOperation() {
    super();
  }

  /**
   * Create a new user in your application
   *
   * <p>This operation makes an HTTP POST request to the /users endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param addUserBody the content to use
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Add User")
  @Summary("Create a new user in your application")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = AddUserOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void addUser(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Content(primary = true)
          @DisplayName("Body")
          @TypeResolver(AddUserInputMetadataResolver.class)
          TypedValue<InputStream> addUserBody,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.addUser(config, connection, addUserBody, parameters, overrides, callback);
  }
}
