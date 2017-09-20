package org.colorcoding.ibas.payments.test.bo;

import junit.framework.TestCase;
import org.colorcoding.ibas.bobas.data.*;
import org.colorcoding.ibas.bobas.common.*;
import org.colorcoding.ibas.bobas.repository.*;
import org.colorcoding.ibas.payments.data.*;
import org.colorcoding.ibas.payments.bo.payment.*;
import org.colorcoding.ibas.payments.repository.*;

/**
* 付款 测试
* 
*/
public class testPayment extends TestCase {
    /**
     * 获取连接口令
    */
    String getToken() {
        return "";
    }
    
    /**
     * 基本项目测试
     * @throws Exception 
    */
    public void testBasicItems() throws Exception {
        Payment bo = new Payment();
        // 测试属性赋值

        // 测试付款-项目
        IPaymentItem paymentitem = bo.getPaymentItems().create();
        // 测试属性赋值

        paymentitem.setBusinessPartnerCode("C0002");
        paymentitem.setBusinessPartnerCode("奥维思博");
        paymentitem.setAmount(100);


        // 测试对象的保存和查询
        IOperationResult<?> operationResult = null;
        ICriteria criteria = null;
        IBORepositoryPaymentsApp boRepository = new BORepositoryPayments();
        //设置用户口令
        boRepository.setUserToken(this.getToken());

        // 测试保存
        operationResult = boRepository.savePayment(bo);
        assertEquals(operationResult.getMessage(), operationResult.getResultCode(), 0);
        Payment boSaved = (Payment)operationResult.getResultObjects().firstOrDefault();


        // 测试查询
        criteria = boSaved.getCriteria();
        criteria.setResultCount(10);
        operationResult = boRepository.fetchPayment(criteria);
        assertEquals(operationResult.getMessage(), operationResult.getResultCode(), 0);


    }

}
