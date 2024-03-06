package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

class PaymentTest {
    Map<String, String> paymentData;
    List<Product> products;
    Order order;

    @BeforeEach
    void setup() {
        this.paymentData = new HashMap<>();
        this.products = new ArrayList<>();

        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(2);
        this.products.add(product1);

        Product product2 = new Product();
        product2.setProductId("a2c62328-4a37-4664-83c7-f32db8620155");
        product2.setProductName("Sabun Cap Usep");
        product2.setProductQuantity(1);
        this.products.add(product2);

        order = new Order("eb558e9f-1c39-460e-8860-71af6af63bd6",
                products, 1708560000L, "Bambang Suryanto");
    }

    @Test
    void testCreatePaymentWithNullOrder() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                    "", null, paymentData);
        });
    }

    @Test
    void testCreatePaymentVoucherPendingStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData);
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e6e60d39-41fb-4ff0-8631-3491e483c180", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals("PENDING", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentVoucherSuccessStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData, "SUCCESS");
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e6e60d39-41fb-4ff0-8631-3491e483c180", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentVoucherRejectedStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData, "REJECTED");
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e6e60d39-41fb-4ff0-8631-3491e483c180", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals("REJECTED", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentVoucherInvalidStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                    "", order, paymentData, "RAWR");
        });
        paymentData.clear();
    }

    @Test
    void testCreatePaymentVoucherNullStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                    "", order, paymentData, null);
        });
        paymentData.clear();
    }

    @Test
    void testCreatePaymentBankTransferPendingStatus() {
        paymentData.put("bankName", "BNI");
        paymentData.put("referenceCode", "0123456789");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData);
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e6e60d39-41fb-4ff0-8631-3491e483c180", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals("PENDING", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentBankTransferSuccessStatus() {
        paymentData.put("bankName", "BNI");
        paymentData.put("referenceCode", "0123456789");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData, "SUCCESS");
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e6e60d39-41fb-4ff0-8631-3491e483c180", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals("SUCCESS", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentBankTransferRejectedStatus() {
        paymentData.put("bankName", "BNI");
        paymentData.put("referenceCode", "0123456789");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData, "REJECTED");
        assertSame(payment.getOrder(), order);
        assertNull(payment.getPaymentData());
        assertEquals("e6e60d39-41fb-4ff0-8631-3491e483c180", payment.getId());
        assertEquals("", payment.getMethod());
        assertEquals("REJECTED", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testCreatePaymentBankTransferInvalidStatus() {
        paymentData.put("bankName", "BNI");
        paymentData.put("referenceCode", "0123456789");

        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                    "", order, paymentData, "RAWR");
        });
        paymentData.clear();
    }

    @Test
    void testCreatePaymentBankTransferNullStatus() {
        paymentData.put("bankName", "BNI");
        paymentData.put("referenceCode", "0123456789");

        assertThrows(IllegalArgumentException.class, () -> {
            new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                    "", order, paymentData, null);
        });
        paymentData.clear();
    }

    @Test
    void testSetStatusPaymentVoucherToSuccess() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData);
        payment.setStatus("SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testSetStatusPaymentVoucherToRejected() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData);
        payment.setStatus("REJECTED");
        assertEquals("REJECTED", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testSetStatusPaymentVoucherToInvalidStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData);
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus("RAWR");
        });
        paymentData.clear();
    }

    @Test
    void testSetStatusPaymentVoucherToNullStatus() {
        paymentData.put("voucherCode", "ESHOP1234ABC5678");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData);
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus(null);
        });
        paymentData.clear();
    }

    @Test
    void testSetStatusPaymentBankTransferToSuccess() {
        paymentData.put("bankName", "BNI");
        paymentData.put("referenceCode", "0123456789");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData);
        payment.setStatus("SUCCESS");
        assertEquals("SUCCESS", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testSetStatusPaymentBankTransferToRejected() {
        paymentData.put("bankName", "BNI");
        paymentData.put("referenceCode", "0123456789");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData);
        payment.setStatus("REJECTED");
        assertEquals("REJECTED", payment.getStatus());
        paymentData.clear();
    }

    @Test
    void testSetStatusPaymentBankTransferToInvalidStatus() {
        paymentData.put("bankName", "BNI");
        paymentData.put("referenceCode", "0123456789");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData);
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus("RAWR");
        });
        paymentData.clear();
    }

    @Test
    void testSetStatusPaymentBankTransferToNullStatus() {
        paymentData.put("bankName", "BNI");
        paymentData.put("referenceCode", "0123456789");

        Payment payment = new Payment("e6e60d39-41fb-4ff0-8631-3491e483c180",
                "", order, paymentData);
        assertThrows(IllegalArgumentException.class, () -> {
            payment.setStatus(null);
        });
        paymentData.clear();
    }
}