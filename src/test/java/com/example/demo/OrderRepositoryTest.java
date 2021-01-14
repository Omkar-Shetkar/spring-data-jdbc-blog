package com.example.demo;

import com.example.demo.order.OrderRepository;
import com.example.demo.order.PurchaseOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@Transactional
@ContextConfiguration(classes = DomainConfig.class)
public class OrderRepositoryTest {

    @Autowired
    OrderRepository orderRepository;

    @Test
    public void createUpdateDeleteOrder() {
        PurchaseOrder order = new PurchaseOrder();
        order.addItem(4, "Captain Future Comet Lego set");
        order.addItem(2, "Cute blue angler fish plush toy");

        PurchaseOrder saved = orderRepository.save(order);

        assertThat(orderRepository.count()).isEqualTo(1);
        assertThat(orderRepository.countItems()).isEqualTo(2);

        orderRepository.delete(saved);

        assertThat(orderRepository.count()).isEqualTo(0);
        assertThat(orderRepository.countItems()).isEqualTo(0);

    }
}
