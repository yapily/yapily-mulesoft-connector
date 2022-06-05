package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.GetAccountBalancesOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.GetAccountBalancesOperationRefinement;
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
public class GetAccountBalancesOperation extends GetAccountBalancesOperationRefinement {
  public GetAccountBalancesOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetAccountBalancesOperation() {
    super();
  }

  /**
   * Used to return the balance for the end user associated with the presented consent token.<br>
   * <br>
   * __Note__: This endpoint is only for obtaining the balance information of an account belonging
   * to an `Institution` that exposes their APIs through the [CBI Globe
   * Gateway](https://docs.yapily.com/pages/knowledge/open-banking/cbi_globe//). If the
   * `Institution` you wish to obtain balance data is not in the CBI Globe, use [Get
   * Account](https://docs.yapily.com/api/reference/#operation/getAccount) or [Get
   * Accounts](https://docs.yapily.com/api/reference/#operation/getAccounts) to get balance data.
   * <br>
   * <br>
   * Feature: `ACCOUNT_BALANCES`
   *
   * <p>This operation makes an HTTP GET request to the /accounts/{accountId}/balances endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param accountIdUriParam __Mandatory__. The account Id of the user's bank account.
   * @param rawQueryParam __Optional__. Used to obtain the raw request and response to and from the
   *     <code>Institution</code>.
   * @param consentHeader __Mandatory__. The `consent-token` containing the user's authorisation to
   *     make the request.
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
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Get Account Balances")
  @Summary(
      "Used to return the balance for the end user associated with the presented consent token.<br><br>\n"
          + "__Note__: This endpoint is only for obtaining the balance information of an account belonging to an `Institution` that exposes their APIs through the [CBI Globe Gateway](https://docs.yapily.")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = GetAccountBalancesOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void getAccountBalances(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @DisplayName("Account Id")
          @Summary("__Mandatory__. The account Id of the user's bank account.")
          String accountIdUriParam,
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
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.getAccountBalances(
        config,
        connection,
        accountIdUriParam,
        rawQueryParam,
        consentHeader,
        psuIdHeader,
        psuCorporateIdHeader,
        psuIpAddressHeader,
        parameters,
        overrides,
        callback);
  }
}
