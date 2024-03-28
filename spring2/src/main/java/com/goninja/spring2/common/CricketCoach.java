package com.goninja.spring2.common;

import com.goninja.spring2.common.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component //marks the class as a spring bean and makes it available for dependency injection
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes ---->>>>>!!!!!!!!";
    }

    // define our init method
//    @PostConstruct
//    public void doMyStartupStuff() {
//        System.out.println("In doMyStartupStuff(): " + getClass().getSimpleName());
//    }
////        define our destroy method
//    @PreDestroy
//public void doMyCleanupStuff() {
//    System.out.println("In doMyCleanupStuff(): " + getClass().getSimpleName());
//}

}
