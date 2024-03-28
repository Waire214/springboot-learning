package com.goninja.spring2.common;

public class SwimCoach implements Coach{
    public SwimCoach() {
        System.out.println("In SwimCoach(): " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "swim 1000 meters as a warm up";
    }
}
