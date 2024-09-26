package com.javacountries.javacountries;

import java.util.concurrent.atomic.AtomicLong;

public class Country
{
     private static final AtomicLong counter = new AtomicLong();

     private long id;
     private String name;
     private double population;
     private double landsize;
     private int age;

    public Country( String name, double population, double landsize, int age)
    {
        this.id = counter.incrementAndGet();
        this.name = name;
        this.population = population;
        this.landsize = landsize;
        this.age = age;

    }

    public static AtomicLong getCounter()
    {
        return counter;
    }

    public long getId()
    {
        return id;
    }


    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPopulation()
    {
        return population;
    }

    public void setPopulation(double population)
    {
        this.population = population;
    }

    public double getLandsize()
    {
        return landsize;
    }

    public void setLandsize(double landsize)
    {
        this.landsize = landsize;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}


