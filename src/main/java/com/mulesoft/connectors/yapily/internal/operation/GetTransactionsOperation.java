package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.api.metadata.GetTransactionsOperationSortQueryParamEnum;
import com.mulesoft.connectors.yapily.internal.metadata.GetTransactionsOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.GetTransactionsOperationRefinement;
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
public class GetTransactionsOperation extends GetTransactionsOperationRefinement {
  public GetTransactionsOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetTransactionsOperation() {
    super();
  }

  /**
   * Used to get the account transactions for an account<br>
   * <br>
   * Feature: `ACCOUNT_TRANSACTIONS`
   *
   * <p>This operation makes an HTTP GET request to the /accounts/{accountId}/transactions endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param accountIdUriParam __Mandatory__. The account Id of the user's bank account.
   * @param withQueryParams __Optional__. Can be `categories` or `merchant`. When set, will include
   *     enrichment data in the transactions returned. <br>
   *     <br>
   *     Enrichment data is optional, e.g. when 'merchant' enrichment data is requested, the
   *     enrichment response will include merchant data only if it can be evaluated from the
   *     transaction.
   * @param fromQueryParam __Optional__. Returned transactions will be on or after this date
   *     (yyyy-MM-dd'T'HH:mm:ss.SSSZ).
   * @param beforeQueryParam __Optional__. Returned transactions will be on or before this date
   *     (yyyy-MM-dd'T'HH:mm:ss.SSSZ).
   * @param limitQueryParam __Optional__. The maximum number of transaction records to be returned.
   *     Must be between 0 and 1000.
   * @param sortQueryParam __Optional__. Sort transaction records by date ascending with 'date' or
   *     descending with '-date'. The default sort order is descending
   * @param offsetQueryParam __Optional__. The number of transaction records to be skipped. Used
   *     primarily with paginated results.
   * @param cursorQueryParam __Optional__. This property is not currently in use.
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
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Get Transactions")
  @Summary(
      "Used to get the account transactions for an account<br><br>Feature: `ACCOUNT_TRANSACTIONS`")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = GetTransactionsOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void getTransactions(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @DisplayName("Account Id")
          @Summary("__Mandatory__. The account Id of the user's bank account.")
          String accountIdUriParam,
      @Optional
          @NullSafe
          @DisplayName("with")
          @Summary(
              "__Optional__. Can be `categories` or `merchant`. When set, will include enrichment data in the transactions returned. <br><br>Enrichment data is optional, e.g.")
          List<String> withQueryParams,
      @Optional
          @DisplayName("from")
          @Summary(
              "__Optional__. Returned transactions will be on or after this date (yyyy-MM-dd'T'HH:mm:ss.SSSZ). ")
          String fromQueryParam,
      @Optional
          @DisplayName("before")
          @Summary(
              "__Optional__. Returned transactions will be on or before this date (yyyy-MM-dd'T'HH:mm:ss.SSSZ).")
          String beforeQueryParam,
      @Optional
          @DisplayName("limit")
          @Summary(
              "__Optional__. The maximum number of transaction records to be returned. Must be between 0 and 1000.")
          Integer limitQueryParam,
      @Optional
          @DisplayName("sort")
          @Summary(
              "__Optional__. Sort transaction records by date ascending with 'date' or descending with '-date'. The default sort order is descending")
          GetTransactionsOperationSortQueryParamEnum sortQueryParam,
      @Optional
          @DisplayName("offset")
          @Summary(
              "__Optional__. The number of transaction records to be skipped. Used primarily with paginated results.")
          Integer offsetQueryParam,
      @Optional
          @DisplayName("cursor")
          @Summary("__Optional__. This property is not currently in use.")
          String cursorQueryParam,
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
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.getTransactions(
        config,
        connection,
        accountIdUriParam,
        withQueryParams,
        fromQueryParam,
        beforeQueryParam,
        limitQueryParam,
        sortQueryParam,
        offsetQueryParam,
        cursorQueryParam,
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