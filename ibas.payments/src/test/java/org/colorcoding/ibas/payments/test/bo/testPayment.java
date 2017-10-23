package org.colorcoding.ibas.payments.test.bo;

import junit.framework.TestCase;
import org.colorcoding.ibas.bobas.common.ICriteria;
import org.colorcoding.ibas.bobas.common.IOperationResult;
import org.colorcoding.ibas.businesspartner.data.emBusinessPartnerType;
import org.colorcoding.ibas.payments.bo.payment.IPaymentItem;
import org.colorcoding.ibas.payments.bo.payment.Payment;
import org.colorcoding.ibas.payments.repository.BORepositoryPayments;
import org.colorcoding.ibas.payments.repository.IBORepositoryPaymentsApp;

/**
* 付款 测试
* 
*/
public class testPayment extends TestCase {
    /**
     * 获取连接口令
    */
    String getToken() {
        return "68fc6bac014d06ad94c5734116487cff";
    }
    
    /**
     * 基本项目测试
     * @throws Exception 
    */
    public void testBasicItems() throws Exception {
        Payment bo = new Payment();
        // 测试属性赋值
        bo.setBusinessPartnerCode("C0003");
        bo.setBusinessPartnerName("中铁铁龙");
        bo.setBusinessPartnerType(emBusinessPartnerType.CUSTOMER);
        // 测试付款-项目
        IPaymentItem paymentitem1 = bo.getPaymentItems().create();
        IPaymentItem paymentitem2 = bo.getPaymentItems().create();
        // 测试属性赋值
        paymentitem1.setAmount(100);
        paymentitem2.setAmount(200);
        // 测试对象的保存和查询
        IOperationResult<?> operationResult = null;
        ICriteria criteria = null;
        IBORepositoryPaymentsApp boRepository = new BORepositoryPayments();
        //设置用户口令
        boRepository.setUserToken(this.getToken());

        // 测试保存
        operationResult = boRepository.savePayment(bo);
        assertEquals(operationResult.getMessage(), operationResult.getResultCode(), 0);

        //测试修改
        paymentitem1.setAmount(200);
        operationResult = boRepository.savePayment(bo);
        assertEquals(operationResult.getMessage(), operationResult.getResultCode(), 0);

        //测试删除
        paymentitem2.delete();
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
