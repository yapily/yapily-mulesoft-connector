package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.CreatePaymentInputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.CreatePaymentOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.CreatePaymentOperationRefinement;
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
public class CreatePaymentOperation extends CreatePaymentOperationRefinement {
  public CreatePaymentOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public CreatePaymentOperation() {
    super();
  }

  /**
   * Used to initiate a payment after obtaining the user's authorisation. <br>
   * <br>
   * Features:
   *
   * <ul>
   *   <li>`INITIATE_DOMESTIC_PERIODIC_PAYMENT`
   *   <li>`INITIATE_DOMESTIC_SCHEDULED_PAYMENT`
   *   <li>`INITIATE_DOMESTIC_SINGLE_INSTANT_PAYMENT`
   *   <li>`INITIATE_DOMESTIC_SINGLE_PAYMENT`
   *   <li>`INITIATE_DOMESTIC_VARIABLE_RECURRING_PAYMENT`
   *   <li>`INITIATE_INTERNATIONAL_PERIODIC_PAYMENT`
   *   <li>`INITIATE_INTERNATIONAL_SCHEDULED_PAYMENT`
   *   <li>`INITIATE_INTERNATIONAL_SINGLE_PAYMENT`
   * </ul>
   *
   * This operation makes an HTTP POST request to the /payments endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param rawQueryParam __Optional__. Used to obtain the raw request and response to and from the
   *     <code>Institution</code>.
   * @param consentHeader __Mandatory__. The `consent-token` containing the user's authorisation to
   *     make the request.
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
   * @param createPaymentBody the content to use
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Create Payment")
  @Summary("Used to initiate a payment after obtaining the user's authorisation.")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = CreatePaymentOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void createPayment(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Optional
          @DisplayName("raw")
          @Summary(
              "__Optional__. Used to obtain the raw request and response to and from the <code>Institution</code>.")
          boolean rawQueryParam,
      @DisplayName("consent")
          @Summary(
              "__Mandatory__. The `consent-token` containing the user's authorisation to make the request.")
          String consentHeader,
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
          @Summary("__Mandatory__. The payment request object defining the details of the payment.")
          @TypeResolver(CreatePaymentInputMetadataResolver.class)
          TypedValue<InputStream> createPaymentBody,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.createPayment(
        config,
        connection,
        rawQueryParam,
        consentHeader,
        psuIdHeader,
        psuCorporateIdHeader,
        psuIpAddressHeader,
        createPaymentBody,
        parameters,
        overrides,
        callback);
  }
}
