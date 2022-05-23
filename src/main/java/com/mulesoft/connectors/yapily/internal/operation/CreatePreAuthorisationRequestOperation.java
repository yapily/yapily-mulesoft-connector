package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.CreatePreAuthorisationRequestInputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.CreatePreAuthorisationRequestOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.CreatePreAuthorisationRequestOperationRefinement;
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
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;

/** Lower part of the Operation. It has the operation declaration with its annotations. */
public class CreatePreAuthorisationRequestOperation
    extends CreatePreAuthorisationRequestOperationRefinement {
  public CreatePreAuthorisationRequestOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public CreatePreAuthorisationRequestOperation() {
    super();
  }

  /**
   * Used to initiate the pre-authorisation process for any `Institution` that contains the
   * `INITIATE_PRE_AUTHORISATION` feature to authenticate the user. <br>
   * <br>
   * Feature: `INITIATE_PRE_AUTHORISATION`
   *
   * <p>This operation makes an HTTP POST request to the /pre-auth-requests endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param rawQueryParam __Optional__. Used to obtain the raw request and response to and from the
   *     <code>Institution</code>.
   * @param createPreAuthorisationRequestBody the content to use
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Create Pre Authorisation Request")
  @Summary(
      "Used to initiate the pre-authorisation process for any `Institution` that contains the `INITIATE_PRE_AUTHORISATION` feature to authenticate the user. <br><br>Feature: `INITIATE_PRE_AUTHORISATION`")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = CreatePreAuthorisationRequestOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void createPreAuthorisationRequest(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Optional
          @DisplayName("raw")
          @Summary(
              "__Optional__. Used to obtain the raw request and response to and from the <code>Institution</code>.")
          boolean rawQueryParam,
      @Content(primary = true)
          @DisplayName("Body")
          @TypeResolver(CreatePreAuthorisationRequestInputMetadataResolver.class)
          TypedValue<InputStream> createPreAuthorisationRequestBody,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.createPreAuthorisationRequest(
        config,
        connection,
        rawQueryParam,
        createPreAuthorisationRequestBody,
        parameters,
        overrides,
        callback);
  }
}
