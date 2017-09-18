package org.colorcoding.ibas.payments.repository;

import org.colorcoding.ibas.bobas.common.ICriteria;
import org.colorcoding.ibas.bobas.common.IOperationResult;
import org.colorcoding.ibas.bobas.common.OperationResult;
import org.colorcoding.ibas.bobas.repository.BORepositoryServiceApplication;
import org.colorcoding.ibas.payments.bo.payment.IPayment;
import org.colorcoding.ibas.payments.bo.payment.Payment;

/**
 * Payments仓库
 */
public class BORepositoryPayments extends BORepositoryServiceApplication
		implements IBORepositoryPaymentsSvc, IBORepositoryPaymentsApp {

	// --------------------------------------------------------------------------------------------//
	/**
	 * 查询-付款
	 * 
	 * @param criteria
	 *            查询
	 * @param token
	 *            口令
	 * @return 操作结果
	 */
	public OperationResult<Payment> fetchPayment(ICriteria criteria, String token) {
		return super.fetch(criteria, token, Payment.class);
	}

	/**
	 * 查询-付款（提前设置用户口令）
	 * 
	 * @param criteria
	 *            查询
	 * @return 操作结果
	 */
	public IOperationResult<IPayment> fetchPayment(ICriteria criteria) {
		return new OperationResult<IPayment>(this.fetchPayment(criteria, this.getUserToken()));
	}

	/**
	 * 保存-付款
	 * 
	 * @param bo
	 *            对象实例
	 * @param token
	 *            口令
	 * @return 操作结果
	 */
	public OperationResult<Payment> savePayment(Payment bo, String token) {
		return super.save(bo, token);
	}

	/**
	 * 保存-付款（提前设置用户口令）
	 * 
	 * @param bo
	 *            对象实例
	 * @return 操作结果
	 */
	public IOperationResult<IPayment> savePayment(IPayment bo) {
		return new OperationResult<IPayment>(this.savePayment((Payment) bo, this.getUserToken()));
	}

	// --------------------------------------------------------------------------------------------//

}
