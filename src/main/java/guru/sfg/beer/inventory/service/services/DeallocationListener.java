package guru.sfg.beer.inventory.service.services;

import guru.sfg.beer.inventory.service.config.JMSConfig;
import guru.sfg.brewery.model.events.AllocateOrderRequest;
import guru.sfg.brewery.model.events.DeallocateOrderRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
@Slf4j
public class DeallocationListener {

    private final AllocationService allocationService;

    @JmsListener(destination = JMSConfig.DEALLOCATE_ORDER_QUEUE)
    public void listen(@Payload DeallocateOrderRequest deallocateOrderRequest) {
        allocationService.deallocateOrder(deallocateOrderRequest.getBeerOrderDto());
    }
}
