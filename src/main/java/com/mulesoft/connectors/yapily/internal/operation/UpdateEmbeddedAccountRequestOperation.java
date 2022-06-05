package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.UpdateEmbeddedAccountRequestInputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.UpdateEmbeddedAccountRequestOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.UpdateEmbeddedAccountRequestOperationRefinement;
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
public class UpdateEmbeddedAccountRequestOperation
    extends UpdateEmbeddedAccountRequestOperationRefinement {
  public UpdateEmbeddedAccountRequestOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public UpdateEmbeddedAccountRequestOperation() {
    super();
  }

  /**
   * Used to pass the SCA Code received from the `Institution` (and the SCA method selected by the
   * user where multiple SCA methods are supported by the `Institution`) in order to complete the
   * embedded authorisation to access the user's financial data. <br>
   * <br>
   * See [Embedded Account
   * Flows](https://docs.yapily.com/pages/key-concepts/account-data/account-authorisation/embedded-account-flows/)
   * for more information about this flow.<br>
   * <br>
   * Feature: `INITIATE_EMBEDDED_ACCOUNT_REQUEST`
   *
   * <p>This operation makes an HTTP PUT request to the /embedded-account-auth-requests/{consentId}
   * endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param consentIdUriParam __Mandatory__. The consent Id of the `Consent` to update.
   * @param rawQueryParam __Optional__. Used to obtain the raw request and response to and from the
   *     <code>Institution</code>.
   * @param psuIdHeader __Conditional__. Represents the user's login ID for the `Institution` to a
   *     personal account. <br>
   *     <br>
   *     See [PSU
   *     identifiers](https://docs.yapily.com/pages/knowledge/open-banking/psu_identifiers/) to see
   *     if this header is required.
   * @param psuCorporateIdHeader __Conditional__. Represents the user's login ID for the
   *     `Institution` to a business account. <br>
   *     <br>
   *     See [PSU
   *     identifiers](https://docs.yapily.com/pages/knowledge/open-banking/psu_identifiers/) to see
   *     if this header is required.
   * @param psuIpAddressHeader __Conditional__. The IP address of the PSU. <br>
   *     <br>
   *     See [PSU
   *     identifiers](https://docs.yapily.com/pages/knowledge/open-banking/psu_identifiers/) to see
   *     if this header is required.
   * @param updateEmbeddedAccountRequestBody the content to use
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Update Embedded Account Request")
  @Summary(
      "Used to pass the SCA Code received from the `Institution` (and the SCA method selected by the user where multiple SCA methods are supported by the `Institution`) in order to complete the embedded authorisation to access the user's financial data. <br><br>See [Embedded Account Flows](https://docs.")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = UpdateEmbeddedAccountRequestOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void updateEmbeddedAccountRequest(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @DisplayName("Consent Id")
          @Summary("__Mandatory__. The consent Id of the `Consent` to update.")
          String consentIdUriParam,
      @Optional
          @DisplayName("raw")
          @Summary(
              "__Optional__. Used to obtain the raw request and response to and from the <code>Institution</code>.")
          boolean rawQueryParam,
      @Optional
          @DisplayName("Psu id")
          @Summary(
              "__Conditional__. Represents the user's login ID for the `Institution` to a personal account. <br><br>See [PSU identifiers](https://docs.yapily.com/pages/knowledge/open-banking/psu_identifiers/) to see if this header is required.")
          String psuIdHeader,
      @Optional
          @DisplayName("Psu corporate id")
          @Summary(
              "__Conditional__. Represents the user's login ID for the `Institution` to a business account. <br><br>See [PSU identifiers](https://docs.yapily.com/pages/knowledge/open-banking/psu_identifiers/) to see if this header is required.")
          String psuCorporateIdHeader,
      @Optional
          @DisplayName("Psu ip address")
          @Summary(
              "__Conditional__. The IP address of the PSU. <br><br>See [PSU identifiers](https://docs.yapily.com/pages/knowledge/open-banking/psu_identifiers/) to see if this header is required.")
          String psuIpAddressHeader,
      @Content(primary = true)
          @DisplayName("Body")
          @TypeResolver(UpdateEmbeddedAccountRequestInputMetadataResolver.class)
          TypedValue<InputStream> updateEmbeddedAccountRequestBody,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.updateEmbeddedAccountRequest(
        config,
        connection,
        consentIdUriParam,
        rawQueryParam,
        psuIdHeader,
        psuCorporateIdHeader,
        psuIpAddressHeader,
        updateEmbeddedAccountRequestBody,
        parameters,
        overrides,
        callback);
  }
}
