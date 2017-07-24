package org.colorcoding.ibas.payments.repository;

import org.colorcoding.ibas.bobas.common.*;
import org.colorcoding.ibas.bobas.repository.*;
import org.colorcoding.ibas.payments.bo.payment.*;

/**
* Payments仓库应用
*/
public interface IBORepositoryPaymentsApp extends IBORepositoryApplication {

    //--------------------------------------------------------------------------------------------//
    /**
     * 查询-付款
     * @param criteria 查询
     * @return 操作结果
     */
    IOperationResult<IPayment> fetchPayment(ICriteria criteria);

    /**
     * 保存-付款
     * @param bo 对象实例
     * @return 操作结果
     */
    IOperationResult<IPayment> savePayment(IPayment bo);

    //--------------------------------------------------------------------------------------------//

}
