package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.InitiateEmbeddedAccountRequestInputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.InitiateEmbeddedAccountRequestOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.InitiateEmbeddedAccountRequestOperationRefinement;
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
public class InitiateEmbeddedAccountRequestOperation
    extends InitiateEmbeddedAccountRequestOperationRefinement {
  public InitiateEmbeddedAccountRequestOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public InitiateEmbeddedAccountRequestOperation() {
    super();
  }

  /**
   * Used to initiate the embedded authorisation process for an `Institution` that contains the
   * `INITIATE_EMBEDDED_ACCOUNT_REQUEST` feature in order to obtain the the user's authorisation to
   * access their account information. <br>
   * <br>
   * See [Embedded Account
   * Flows](https://docs.yapily.com/guides/financial-data/account-authorisation-flows/embedded/) for
   * more information about this flow.<br>
   * <br>
   * Feature: `INITIATE_EMBEDDED_ACCOUNT_REQUEST`
   *
   * <p>This operation makes an HTTP POST request to the /embedded-account-auth-requests endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param rawQueryParam __Optional__. Used to obtain the raw request and response to and from the
   *     <code>Institution</code>.
   * @param psuIdHeader __Conditional__. Represents the user's login ID for the `Institution` to a
   *     personal account. <br>
   *     <br>
   *     See [PSU identifiers](https://docs.yapily.com/knowledge/psu_identifiers/) to see if this
   *     header is required.
   * @param psuCorporateIdHeader __Conditional__. Represents the user's login ID for the
   *     `Institution` to a business account. <br>
   *     <br>
   *     See [PSU identifiers](https://docs.yapily.com/knowledge/psu_identifiers/) to see if this
   *     header is required.
   * @param psuIpAddressHeader __Conditional__. The IP address of the PSU. <br>
   *     <br>
   *     See [PSU identifiers](https://docs.yapily.com/knowledge/psu_identifiers/) to see if this
   *     header is required.
   * @param initiateEmbeddedAccountRequestBody the content to use
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Initiate Embedded Account Request")
  @Summary(
      "Used to initiate the embedded authorisation process for an `Institution` that contains the `INITIATE_EMBEDDED_ACCOUNT_REQUEST` feature in order to obtain the the user's authorisation to access their account information. <br><br>See [Embedded Account Flows](https://docs.yapily.")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = InitiateEmbeddedAccountRequestOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void initiateEmbeddedAccountRequest(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Optional
          @DisplayName("raw")
          @Summary(
              "__Optional__. Used to obtain the raw request and response to and from the <code>Institution</code>.")
          boolean rawQueryParam,
      @Optional
          @DisplayName("Psu id")
          @Summary(
              "__Conditional__. Represents the user's login ID for the `Institution` to a personal account. <br><br>See [PSU identifiers](https://docs.yapily.com/knowledge/psu_identifiers/) to see if this header is required.")
          String psuIdHeader,
      @Optional
          @DisplayName("Psu corporate id")
          @Summary(
              "__Conditional__. Represents the user's login ID for the `Institution` to a business account. <br><br>See [PSU identifiers](https://docs.yapily.com/knowledge/psu_identifiers/) to see if this header is required.")
          String psuCorporateIdHeader,
      @Optional
          @DisplayName("Psu ip address")
          @Summary(
              "__Conditional__. The IP address of the PSU. <br><br>See [PSU identifiers](https://docs.yapily.com/knowledge/psu_identifiers/) to see if this header is required.")
          String psuIpAddressHeader,
      @Content(primary = true)
          @DisplayName("Body")
          @Summary(
              "The request body containing an `AccountEmbeddedAuthorisationRequest` json payload")
          @TypeResolver(InitiateEmbeddedAccountRequestInputMetadataResolver.class)
          TypedValue<InputStream> initiateEmbeddedAccountRequestBody,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.initiateEmbeddedAccountRequest(
        config,
        connection,
        rawQueryParam,
        psuIdHeader,
        psuCorporateIdHeader,
        psuIpAddressHeader,
        initiateEmbeddedAccountRequestBody,
        parameters,
        overrides,
        callback);
  }
}
