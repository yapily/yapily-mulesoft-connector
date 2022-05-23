package com.mulesoft.connectors.yapily.internal.operation;

import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.CONNECTOR_OVERRIDES;
import static com.mulesoft.connectivity.rest.commons.internal.RestConstants.REQUEST_PARAMETERS_GROUP_NAME;

import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RequestErrorTypeProvider;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectors.yapily.internal.metadata.GetConsentsOutputMetadataResolver;
import com.mulesoft.connectors.yapily.internal.metadata.HttpResponseAttributesMetadataResolver;
import com.mulesoft.connectors.yapily.internal.operation.refinement.GetConsentsOperationRefinement;
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
public class GetConsentsOperation extends GetConsentsOperationRefinement {
  public GetConsentsOperation(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetConsentsOperation() {
    super();
  }

  /**
   * Used to retrieve all the consents created for each user within an application
   *
   * <p>This operation makes an HTTP GET request to the /consents endpoint
   *
   * @param config the configuration to use
   * @param connection the connection to use
   * @param filterapplicationUserIdQueryParams __Optional__. Filter records based on the list of
   *     `applicationUserId` users provided.
   * @param filteruserUuidQueryParams __Optional__. Filter records based on the list of `userUuid`
   *     users provided.
   * @param filterinstitutionQueryParams __Optional__. Filter records based on the list of
   *     `Institution` provided.
   * @param filterstatusQueryParams __Optional__. Filter records based on the list of `Consent`
   *     [statuses](https://docs.yapily.com/api/#tocS_AuthorisationStatus).
   * @param fromQueryParam __Optional__. Returned transactions will be on or after this date
   *     (yyyy-MM-dd'T'HH:mm:ss.SSSZ).
   * @param beforeQueryParam __Optional__. Returned transactions will be on or before this date
   *     (yyyy-MM-dd'T'HH:mm:ss.SSSZ).
   * @param limitQueryParam __Optional__. The maximum number of transaction records to be returned.
   *     Must be between 0 and 1000.
   * @param offsetQueryParam __Optional__. The number of transaction records to be skipped. Used
   *     primarily with paginated results.
   * @param parameters the {@link RequestParameters}
   * @param overrides the {@link ConfigurationOverrides}
   * @param callback the operation's {@link CompletionCallback}
   */
  @Throws(RequestErrorTypeProvider.class)
  @DisplayName("Get Consents")
  @Summary("Used to retrieve all the consents created for each user within an application")
  @MediaType("application/json;charset=UTF-8")
  @OutputResolver(
      output = GetConsentsOutputMetadataResolver.class,
      attributes = HttpResponseAttributesMetadataResolver.class)
  public void getConsents(
      @Config RestConfiguration config,
      @Connection RestConnection connection,
      @Optional
          @NullSafe
          @DisplayName("Filter[application User Id]")
          @Summary(
              "__Optional__. Filter records based on the list of `applicationUserId` users provided.")
          List<String> filterapplicationUserIdQueryParams,
      @Optional
          @NullSafe
          @DisplayName("Filter[user Uuid]")
          @Summary("__Optional__. Filter records based on the list of `userUuid` users provided.")
          List<String> filteruserUuidQueryParams,
      @Optional
          @NullSafe
          @DisplayName("filter[institution]")
          @Summary("__Optional__. Filter records based on the list of `Institution` provided.")
          List<String> filterinstitutionQueryParams,
      @Optional
          @NullSafe
          @DisplayName("filter[status]")
          @Summary(
              "__Optional__. Filter records based on the list of `Consent` [statuses](https://docs.yapily.com/api/#tocS_AuthorisationStatus).")
          List<String> filterstatusQueryParams,
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
      @Optional(defaultValue = "0")
          @DisplayName("offset")
          @Summary(
              "__Optional__. The number of transaction records to be skipped. Used primarily with paginated results.")
          Integer offsetQueryParam,
      @ParameterGroup(name = REQUEST_PARAMETERS_GROUP_NAME) RequestParameters parameters,
      @ParameterGroup(name = CONNECTOR_OVERRIDES) ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    super.getConsents(
        config,
        connection,
        filterapplicationUserIdQueryParams,
        filteruserUuidQueryParams,
        filterinstitutionQueryParams,
        filterstatusQueryParams,
        fromQueryParam,
        beforeQueryParam,
        limitQueryParam,
        offsetQueryParam,
        parameters,
        overrides,
        callback);
  }
}
