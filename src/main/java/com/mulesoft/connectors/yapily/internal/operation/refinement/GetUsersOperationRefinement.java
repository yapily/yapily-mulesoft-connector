package com.mulesoft.connectors.yapily.internal.operation.refinement;

import com.mulesoft.connectors.yapily.internal.operation.base.GetUsersOperationBase;
import org.mule.runtime.api.el.ExpressionLanguage;

/** Middle part of the Operation. Can be used by the user to add custom code into the operation. */
public class GetUsersOperationRefinement extends GetUsersOperationBase {
  public GetUsersOperationRefinement(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetUsersOperationRefinement() {
    super();
  }
}
