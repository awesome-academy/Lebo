package com.atom.android.lebo.data.repository.bill

import com.atom.android.lebo.base.BaseResponse
import com.atom.android.lebo.data.datasource.bill.IBillDataSource
import com.atom.android.lebo.model.Bill
import com.atom.android.lebo.model.Order
import io.reactivex.rxjava3.core.Single

class BillRepository(private val remote: IBillDataSource.Remote) : IBillRepository {

    override fun createOrder(order: Order): Single<BaseResponse<Bill>> {
        return remote.createOrder(order)
    }
}
