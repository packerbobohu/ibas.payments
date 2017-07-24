/**
 * @license
 * Copyright color-coding studio. All Rights Reserved.
 *
 * Use of this source code is governed by an Apache License, Version 2.0
 * that can be found in the LICENSE file at http://www.apache.org/licenses/LICENSE-2.0
 */

import * as ibas from "ibas/index";
import * as bo from "./bo/index";
import { IBORepositoryPayments, BO_REPOSITORY_PAYMENTS } from "../api/index";
import { DataConverter4py } from "./DataConverters";

/** 业务对象仓库 */
export class BORepositoryPayments extends ibas.BORepositoryApplication implements IBORepositoryPayments {

    /** 创建此模块的后端与前端数据的转换者 */
    protected createConverter(): ibas.IDataConverter {
        return new DataConverter4py;
    }

    /**
     * 查询 付款
     * @param fetcher 查询者
     */
    fetchPayment(fetcher: ibas.FetchCaller<bo.Payment>): void {
        super.fetch(bo.Payment.name, fetcher);
    }
    /**
     * 保存 付款
     * @param saver 保存者
     */
    savePayment(saver: ibas.SaveCaller<bo.Payment>): void {
        super.save(bo.Payment.name, saver);
    }

}
// 注册业务对象仓库到工厂
ibas.boFactory.register(BO_REPOSITORY_PAYMENTS, BORepositoryPayments);
