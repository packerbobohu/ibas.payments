package org.colorcoding.ibas.payments.bo.payment;

import java.beans.PropertyChangeEvent;
import javax.xml.bind.annotation.*;
import org.colorcoding.ibas.bobas.common.*;
import org.colorcoding.ibas.bobas.bo.*;
import org.colorcoding.ibas.payments.MyConfiguration;

/**
* 付款-项目 集合
*/
@XmlType(name = PaymentItems.BUSINESS_OBJECT_NAME, namespace = MyConfiguration.NAMESPACE_BO)
@XmlSeeAlso({ PaymentItem.class })
public class PaymentItems extends BusinessObjects<IPaymentItem, IPayment> implements IPaymentItems {

    /**
    * 业务对象名称
    */
    public static final String BUSINESS_OBJECT_NAME = "PaymentItems";

    /**
     * 序列化版本标记
     */
    private static final long serialVersionUID = 9060154529699363515L;

    /**
     * 构造方法
     */
    public PaymentItems() {
        super();
    }

    /**
     * 构造方法
     * @param parent 父项对象
     */
    public PaymentItems(IPayment parent) {
        super(parent);
    }

    /**
     * 元素类型
     */
    public Class<?> getElementType() {
        return PaymentItem.class;
    }

    /**
    * 创建付款-项目
    * 
    * @return 付款-项目
    */
    public IPaymentItem create() {
        IPaymentItem item = new PaymentItem();
        if (this.add(item)) {
            return item;
        }
        return null;
    }

    @Override
    protected void afterAddItem(IPaymentItem item) {
        super.afterAddItem(item);
        // TODO 设置关联值
        ((PaymentItem)item).setBusinessPartnerCode(this.getParent().getBusinessPartnerCode());
        ((PaymentItem)item).setBusinessPartnerName(this.getParent().getBusinessPartnerName());
    }

    @Override
    public ICriteria getElementCriteria() {
        ICriteria criteria = super.getElementCriteria();
        // TODO 添加关联查询条件
        return criteria;
    }

    @Override
    public void onParentPropertyChanged(PropertyChangeEvent evt) {
        super.onParentPropertyChanged(evt);
        // TODO 设置关联值
    }
}
