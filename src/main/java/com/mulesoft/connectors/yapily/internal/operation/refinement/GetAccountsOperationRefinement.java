package com.mulesoft.connectors.yapily.internal.operation.refinement;

import com.mulesoft.connectors.yapily.internal.operation.base.GetAccountsOperationBase;
import org.mule.runtime.api.el.ExpressionLanguage;

/** Middle part of the Operation. Can be used by the user to add custom code into the operation. */
public class GetAccountsOperationRefinement extends GetAccountsOperationBase {
  public GetAccountsOperationRefinement(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetAccountsOperationRefinement() {
    super();
  }
}
