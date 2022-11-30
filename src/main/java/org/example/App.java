package org.example;

import org.example.config.SpringConfig;
import org.example.model.City;
import org.example.model.transport.Transport;
import org.example.services.Logistics;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
    Классы Logistics и TransportFactory модуля сделать бинами,
    использовать разные способы их конфигурирования.

    Модифицировать класс Logistics так,
    чтобы при отсутствии доступных транспортов фабрикой
    создавался бы новый транспорт.

    Метод getTransport в классе TransportFactory не должен быть статическим !!

*/


public class App {
    public static void main(String[] args) {

        System.out.println("Hello Spring!");

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
  
        Transport transport = context.getBean(Logistics.class).getShipping(
                new City("Сургут", 30, true, true), 200, 3);

        System.out.println(transport);


    }
}
