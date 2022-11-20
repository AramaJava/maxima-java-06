package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/*
   Взять необходимые классы из модуля 2
   Классы Logistics и TransportFactory модуля сделать бинами,
   использовать разные способы их конфигурирования.
*/



public class App
{
    public static void main( String[] args )
    {
        System.out.println( "Hello Spring!" );

        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        //Manul murzik = context.getBean(Manul.class);
        //Sphynx ramzec = context.getBean(Sphynx.class);

        TransportFactory tf = context.getBean(TransportFactory.class);
        Logistics logistics = context.getBean(Logistics.class);




        System.out.println(tf);
        System.out.println(logistics);

    }
}
