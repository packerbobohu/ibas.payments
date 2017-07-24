package org.colorcoding.ibas.payments.service.soap;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.colorcoding.ibas.bobas.common.*;
import org.colorcoding.ibas.bobas.cxf.WebServicePath;
import org.colorcoding.ibas.payments.repository.*;
import org.colorcoding.ibas.payments.bo.payment.*;

/**
* Payments 数据服务JSON
*/
@WebService
@WebServicePath("data")
public class DataService extends BORepositoryPayments {

    //--------------------------------------------------------------------------------------------//
    /**
     * 查询-付款
     * @param criteria 查询
     * @param token 口令
     * @return 操作结果
     */
    @WebMethod
    public OperationResult<Payment> fetchPayment(@WebParam(name = "criteria") Criteria criteria, @WebParam(name = "token") String token) {
        return super.fetchPayment(criteria, token);
    }

    /**
     * 保存-付款
     * @param bo 对象实例
     * @param token 口令
     * @return 操作结果
     */
    @WebMethod
    public OperationResult<Payment> savePayment(@WebParam(name = "bo") Payment bo, @WebParam(name = "token") String token) {
        return super.savePayment(bo, token);
    }

    //--------------------------------------------------------------------------------------------//

}
