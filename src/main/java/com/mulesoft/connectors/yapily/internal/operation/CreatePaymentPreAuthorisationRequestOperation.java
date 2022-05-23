package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.CreatePaymentPreAuthorisationRequestInputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.CreatePaymentPreAuthorisationRequestOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.CreatePaymentPreAuthorisationRequestOperationRefinement;
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
public class CreatePaymentPreAuthorisationRequestOperation
    extends CreatePaymentPreAuthorisationRequestOperationRefinement {
  public CreatePaymentPreAuthorisationRequestOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public CreatePaymentPreAuthorisationRequestOperation() {
    super();
  }

  /**
   * Used to initiate the pre-authorisation process for payments for CbiGlobe `Institution` that
   * contains the `INITIATE_ONETIME_PRE_AUTHORISATION_PAYMENTS` feature to authenticate the user.
   * <br>
   * <br>
   * Feature: `INITIATE_ONETIME_PRE_AUTHORISATION_PAYMENTS`
   *
   * <p>This operation makes an HTTP POST request to the /payment-pre-auth-requests endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param rawQueryParam __Optional__. Used to obtain the raw request and response to and from the
   *     <code>Institution</code>.
   * @param createPaymentPreAuthorisationRequestBody the content to use
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Create Payment Pre Authorisation Request")
  @Summary(
      "Used to initiate the pre-authorisation process for payments for CbiGlobe `Institution` that contains the `INITIATE_ONETIME_PRE_AUTHORISATION_PAYMENTS` feature to authenticate the user. <br><br>Feature: `INITIATE_ONETIME_PRE_AUTHORISATION_PAYMENTS`")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = CreatePaymentPreAuthorisationRequestOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void createPaymentPreAuthorisationRequest(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Optional
          @DisplayName("raw")
          @Summary(
              "__Optional__. Used to obtain the raw request and response to and from the <code>Institution</code>.")
          boolean rawQueryParam,
      @Content(primary = true)
          @DisplayName("Body")
          @Summary(
              "__Mandatory__. The payment pre authorisation request object defining the details of the payment and pre auth.")
          @TypeResolver(CreatePaymentPreAuthorisationRequestInputMetadataResolver.class)
          TypedValue<InputStream> createPaymentPreAuthorisationRequestBody,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.createPaymentPreAuthorisationRequest(
        config,
        connection,
        rawQueryParam,
        createPaymentPreAuthorisationRequestBody,
        parameters,
        overrides,
        callback);
  }
}
