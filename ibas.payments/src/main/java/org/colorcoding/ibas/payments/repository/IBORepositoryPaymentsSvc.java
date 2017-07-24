package org.colorcoding.ibas.payments.repository;

import org.colorcoding.ibas.bobas.common.*;
import org.colorcoding.ibas.bobas.repository.*;
import org.colorcoding.ibas.payments.bo.payment.*;

/**
* Payments仓库服务
*/
public interface IBORepositoryPaymentsSvc extends IBORepositorySmartService {


    //--------------------------------------------------------------------------------------------//
    /**
     * 查询-付款
     * @param criteria 查询
     * @param token 口令
     * @return 操作结果
     */
    OperationResult<Payment> fetchPayment(ICriteria criteria, String token);

    /**
     * 保存-付款
     * @param bo 对象实例
     * @param token 口令
     * @return 操作结果
     */
    OperationResult<Payment> savePayment(Payment bo, String token);

    //--------------------------------------------------------------------------------------------//

}
