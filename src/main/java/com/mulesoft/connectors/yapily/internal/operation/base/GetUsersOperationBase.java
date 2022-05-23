package com.mulesoft.connectors.yapily.internal.operation.base;

import com.mulesoft.connectivity.rest.commons.api.binding.HttpRequestBinding;
import com.mulesoft.connectivity.rest.commons.api.binding.HttpResponseBinding;
import com.mulesoft.connectivity.rest.commons.api.configuration.RestConfiguration;
import com.mulesoft.connectivity.rest.commons.api.connection.RestConnection;
import com.mulesoft.connectivity.rest.commons.api.error.RestError;
import com.mulesoft.connectivity.rest.commons.api.operation.BaseRestOperation;
import com.mulesoft.connectivity.rest.commons.api.operation.ConfigurationOverrides;
import com.mulesoft.connectivity.rest.commons.api.operation.RequestParameters;
import com.mulesoft.connectivity.rest.commons.internal.util.RestRequestBuilder;
import com.mulesoft.connectivity.rest.commons.internal.util.StreamUtils;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import org.mule.runtime.api.el.ExpressionLanguage;
import org.mule.runtime.extension.api.exception.ModuleException;
import org.mule.runtime.extension.api.runtime.process.CompletionCallback;
import org.mule.runtime.http.api.HttpConstants;

/** Higher part of the Operation. It has the implementation of the operation. */
public abstract class GetUsersOperationBase extends BaseRestOperation {
  protected static final String OPERATION_PATH = "/users";

  protected static final RestRequestBuilder.ParameterArrayFormat QUERY_PARAM_FORMAT =
      RestRequestBuilder.ParameterArrayFormat.MULTIMAP;

  public GetUsersOperationBase(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetUsersOperationBase() {
    super();
  }

  protected void getUsers(
      RestConfiguration config,
      RestConnection connection,
      List<String> filterapplicationUserIdQueryParams,
      RequestParameters parameters,
      ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    try {
      Map<String, Object> customParameterBindings = new HashMap<>();
      getUsersMain(
          config,
          connection,
          filterapplicationUserIdQueryParams,
          customParameterBindings,
          parameters,
          overrides,
          callback);
    } catch (ModuleException e) {
      callback.error(e);
    } catch (Throwable e) {
      callback.error(new ModuleException("Unknown error", RestError.CONNECTIVITY, e));
    }
  }

  protected void getUsersMain(
      RestConfiguration config,
      RestConnection connection,
      List<String> filterapplicationUserIdQueryParams,
      Map<String, Object> customParameterBindings,
      RequestParameters parameters,
      ConfigurationOverrides overrides,
      CompletionCallback<InputStream, Object> callback) {
    Map<String, Object> parameterBindings = new HashMap<>();
    parameterBindings = StreamUtils.resolveCursorProvider(parameterBindings);
    customParameterBindings = StreamUtils.resolveCursorProvider(customParameterBindings);
    RestRequestBuilder builder =
        getRequestBuilderWithBindings(
                connection.getBaseUri(),
                OPERATION_PATH,
                HttpConstants.Method.GET,
                parameters,
                overrides,
                connection,
                config,
                parameterBindings,
                customParameterBindings)
            .setQueryParamFormat(QUERY_PARAM_FORMAT)
            .addHeader("accept", "application/json;charset=UTF-8")
            .addQueryParam(
                "filter[applicationUserId]",
                filterapplicationUserIdQueryParams.stream()
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList()));
    doRequest(
        config,
        connection,
        builder,
        overrides.getResponseTimeoutAsMillis(),
        parameterBindings,
        customParameterBindings,
        callbackObjectAttributesAdapter(callback));
  }

  @Override
  protected String getRequestBodyMediaType() {
    return "application/json";
  }

  @Override
  protected String getResponseBodyMediaType() {
    return "application/json;charset=UTF-8";
  }

  @Override
  protected HttpRequestBinding getRequestBindings() {
    HttpRequestBinding bindings = new HttpRequestBinding();
    return bindings;
  }

  @Override
  protected HttpResponseBinding getResponseBindings() {
    HttpResponseBinding bindings = new HttpResponseBinding();
    return bindings;
  }
}
