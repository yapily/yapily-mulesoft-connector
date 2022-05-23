package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.GetAccountScheduledPaymentsOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.GetAccountScheduledPaymentsOperationRefinement;
import java.io.InputStream;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.extension.api.annotation.error.Throws;
import org.mule.runtime.extension.api.annotation.metadata.OutputResolver;
import org.mule.runtime.extension.api.annotation.param.Config;
import org.mule.runtime.extension.api.annotation.param.Connection;
import org.mule.runtime.extension.api.annotation.param.MediaType;
import org.mule.runtime.extension.api.annotation.param.Optional;
import org.mule.runtime.extension.api.annotation.param.ParameterGroup;
import org.mule.runtime.extension.api.annotation.param.display.DisplayName;
import org.mule.runtime.extension.api.annotation.param.display.Summary;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;

/** Lower part of the Operation. It has the operation declaration with its annotations. */
public class GetAccountScheduledPaymentsOperation
    extends GetAccountScheduledPaymentsOperationRefinement {
  public GetAccountScheduledPaymentsOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetAccountScheduledPaymentsOperation() {
    super();
  }

  /**
   * Used to get the list of scheduled payments for an account.<br>
   * <br>
   * Feature: `ACCOUNT_SCHEDULED_PAYMENT`
   *
   * <p>This operation makes an HTTP GET request to the /accounts/{accountId}/scheduled-payments
   * endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param accountIdUriParam __Mandatory__. The account Id of the user's bank account.
   * @param limitQueryParam __Optional__. The maximum number of transaction records to be returned.
   *     Must be between 0 and 1000.
   * @param rawQueryParam __Optional__. Used to obtain the raw request and response to and from the
   *     <code>Institution</code>.
   * @param consentHeader __Mandatory__. The `consent-token` containing the user's authorisation to
   *     make the request.
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Get Account Scheduled Payments")
  @Summary(
      "Used to get the list of scheduled payments for an account.<br><br>Feature: `ACCOUNT_SCHEDULED_PAYMENT`")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = GetAccountScheduledPaymentsOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void getAccountScheduledPayments(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @DisplayName("Account Id")
          @Summary("__Mandatory__. The account Id of the user's bank account.")
          String accountIdUriParam,
      @Optional
          @DisplayName("limit")
          @Summary(
              "__Optional__. The maximum number of transaction records to be returned. Must be between 0 and 1000.")
          Integer limitQueryParam,
      @Optional
          @DisplayName("raw")
          @Summary(
              "__Optional__. Used to obtain the raw request and response to and from the <code>Institution</code>.")
          boolean rawQueryParam,
      @DisplayName("consent")
          @Summary(
              "__Mandatory__. The `consent-token` containing the user's authorisation to make the request.")
          String consentHeader,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.getAccountScheduledPayments(
        config,
        connection,
        accountIdUriParam,
        limitQueryParam,
        rawQueryParam,
        consentHeader,
        parameters,
        overrides,
        callback);
  }
}
