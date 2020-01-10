package com.offcn.pay;

public class PayServiceImpl implements PayService {
    @Override
    public void add(Double money) {
        System.out.println("支付增加");
    }

    @Override
    public void update(Double money) {
        System.out.println("支付更新");
    }

    @Override
    public void delete(Integer id) {
        System.out.println("支付删除");
    }
}
