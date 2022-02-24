package com.smartrm.infracore.event;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.util.Properties;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author: liuyuancheng
 * @description:
 */
public class DomainEventListener implements Runnable {

  private static Logger LOGGER = LoggerFactory.getLogger(DomainEventListener.class);

  private KafkaConsumer<String, String> kafkaConsumer;
  private DomainEventHandler handler;
  private Class eventType;
  private boolean isClose;

  private ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule())
      .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);


  public void close() {
    isClose = true;
  }

  public DomainEventListener(Properties props, Class eventType, DomainEventHandler handler) {
//    kafkaConsumer = new KafkaConsumer<String, String>(props);
    this.eventType = eventType;
    this.handler = handler;
  }

  @Override
  public void run() {
//    kafkaConsumer.subscribe(Arrays.asList(eventType.getSimpleName()));
//    while (!isClose) {
//      ConsumerRecords<String, String> records = kafkaConsumer.poll(Duration.ofMillis(100));
//      for (ConsumerRecord<String, String> record : records) {
//        LOGGER.info("listener receive msg:{}", record.value());
//        try {
//          DomainEvent event = (DomainEvent) objectMapper.readValue(record.value(), eventType);
//          handler.onApplicationEvent(event);
//        } catch (Exception e) {
//          LOGGER.error("fail to handle event.", e);
//          LOGGER.info("failed event:{}", record.value());
//        }
//      }
//      kafkaConsumer.commitAsync();
//    }
  }
}
