package id.ac.ui.cs.advprog.eshop.model;

import java.util.Map;

public class PaymentVoucherCode extends Payment {


    public PaymentVoucherCode(String id, String method, Order order, Map<String, String> paymentData, String status) {
        super(id, method, order, paymentData, status);
    }

    public PaymentVoucherCode(String id, String method, Order order, Map<String, String> paymentData) {
        super(id, method, order, paymentData);
    }

    @Override
    protected void setPaymentData(Map<String, String> paymentData) {
    }
}