/**
 * @license
 * Copyright color-coding studio. All Rights Reserved.
 *
 * Use of this source code is governed by an Apache License, Version 2.0
 * that can be found in the LICENSE file at http://www.apache.org/licenses/LICENSE-2.0
 */

import * as ibas from "ibas/index";
import * as paymentApps from "../../bsapp/payment/index";
import * as paymentViews from "./payment/index";

/**
 * 视图导航
 */
export default class Navigation extends ibas.ViewNavigation {

    /**
     * 创建实例
     * @param id 应用id
     */
    protected newView(id: string): ibas.IView {
        let view: ibas.IView = null;
        switch (id) {
            case paymentApps.PaymentListApp.APPLICATION_ID:
                view = new paymentViews.PaymentListView();
                break;
            case paymentApps.PaymentChooseApp.APPLICATION_ID:
                view = new paymentViews.PaymentChooseView();
                break;
            case paymentApps.PaymentViewApp.APPLICATION_ID:
                view = new paymentViews.PaymentViewView();
                break;
            case paymentApps.PaymentEditApp.APPLICATION_ID:
                view = new paymentViews.PaymentEditView();
                break;
            default:
                break;
        }
        return view;
    }
}
