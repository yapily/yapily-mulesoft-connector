package com.mulesoft.connectors.yapily.internal.operation.refinement;

import com.mulesoft.connectors.yapily.internal.operation.base.GetAccountPeriodicPaymentsOperationBase;
import org.mule.runtime.api.el.ExpressionLanguage;

/** Middle part of the Operation. Can be used by the user to add custom code into the operation. */
public class GetAccountPeriodicPaymentsOperationRefinement
    extends GetAccountPeriodicPaymentsOperationBase {
  public GetAccountPeriodicPaymentsOperationRefinement(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetAccountPeriodicPaymentsOperationRefinement() {
    super();
  }
}
