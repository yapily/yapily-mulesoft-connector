package com.mulesoft.connectors.yapily.internal.operation.refinement;

import com.mulesoft.connectors.yapily.internal.operation.base.GetAccountScheduledPaymentsOperationBase;
import org.mule.runtime.api.el.ExpressionLanguage;

/** Middle part of the Operation. Can be used by the user to add custom code into the operation. */
public class GetAccountScheduledPaymentsOperationRefinement
    extends GetAccountScheduledPaymentsOperationBase {
  public GetAccountScheduledPaymentsOperationRefinement(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetAccountScheduledPaymentsOperationRefinement() {
    super();
  }
}
