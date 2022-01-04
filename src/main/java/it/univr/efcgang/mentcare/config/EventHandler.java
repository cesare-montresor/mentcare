package it.univr.efcgang.mentcare.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AppEventHandler {

    @EventListener(ApplicationReadyEvent.class)
    public void OnReady() {
        System.out.println("System: OnReady");
        DemoData demo = new DemoData();
        demo.addDemoData();

    }

}
