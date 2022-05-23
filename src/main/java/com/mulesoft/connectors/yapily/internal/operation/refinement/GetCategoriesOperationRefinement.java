package com.mulesoft.connectors.yapily.internal.operation.refinement;

import com.mulesoft.connectors.yapily.internal.operation.base.GetCategoriesOperationBase;
import org.mule.runtime.api.el.ExpressionLanguage;

/** Middle part of the Operation. Can be used by the user to add custom code into the operation. */
public class GetCategoriesOperationRefinement extends GetCategoriesOperationBase {
  public GetCategoriesOperationRefinement(ExpressionLanguage arg0) {
    super(arg0);
  }

  public GetCategoriesOperationRefinement() {
    super();
  }
}
