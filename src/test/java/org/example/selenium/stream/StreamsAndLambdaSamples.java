package org.example.selenium.stream;

import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamsAndLambdaSamples {
    @Test
    public  void TestWithArrayList() {
        //create a list and count words starting wth "A"
        ArrayList<String> names = new ArrayList<>();
        names.add("Sonal");
        names.add("Arnav");
        names.add("Shubham");
        names.add("Ashutosh");
        names.add("Rahul");
        names.add("Abir");
        int count = 0;
        for (int i=0;i<names.size();i++){
           String name = names.get(i);

           if(name.startsWith("A"))
               count++;

        }
        System.out.println(count);
    }
    @Test
    public void TestWithStreamFilterLambda(){
        //create a list and count words starting wth "A"
        ArrayList<String> names = new ArrayList<>();
        names.add("Sonal");
        names.add("Arnav");
        names.add("Shubham");
        names.add("Ashutosh");
        names.add("Rahul");
        names.add("Abir");
        Long c = names.stream().filter(s->s.startsWith("A")).count();
        System.out.println(c);

        Long d = Stream.of("Arnav","Don","Shubham").filter(s->
        {
            s.startsWith("A");
            return true;
        }
        ).count();
        System.out.println(d);

        //print all the names of ArrayLisy where name lenght is greater then 4
        names.stream().filter(s->s.length()>4).forEach(s-> System.out.println(s));
        //limit to display only 2 result
        names.stream().filter(s->s.length()>4).limit(2).forEach(s-> System.out.println(s));
    }
    @Test
    public void TestWithStreamsMap(){
        //select words ends with a and coomverts into uppercase using maps
        Stream.of("Arnav","Don","Shubham","Rama").filter(s->s.endsWith("a")).map(s->s.toUpperCase())
                .forEach(s-> System.out.println(s));
        //print names which have first name as letter a with uppercase and sorted
        List<String> names = Arrays.asList("Arnav","Don","Shubham","Rama","Abram","Ayan");
       names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
                .forEach(s-> System.out.println(s));
       //merge two lists

        ArrayList<String> nameBefore = new ArrayList<>();
        nameBefore.add("Sonal");
        nameBefore.add("Arnav");
        nameBefore.add("Shubham");
       nameBefore.add("Ashutosh");
       nameBefore.add("Rahul");
        nameBefore.add("Abir");
        Stream<String> newStream =Stream.concat(nameBefore.stream(),names.stream());
        newStream.sorted().forEach(s-> System.out.println(s));
        //check if any string name Adam available
        Stream<String> newStreamOne =Stream.concat(nameBefore.stream(),names.stream());
        boolean flag =newStreamOne.anyMatch(s->s.equalsIgnoreCase("Adam"));
        Assert.assertTrue(flag);

    }
    @Test
    public void streamCollect(){
        //collect into a string or map or sets
        List<String> namesList=Stream.of("Arnav","Don","Shubham","Rama","Abram","Ayan").
                filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
                .collect(Collectors.toList());
        System.out.println(namesList);
        //only first 2
        Stream.of("Arnav","Don","Shubham","Rama","Abram","Ayan").
                filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase())
                .limit(2).forEach(s-> System.out.println(s));


        //find unique values and sort the lists
        List<Integer> values = Arrays.asList(3,2,4,2,5,6,7,8,9,7);
        values.stream().distinct().sorted().forEach(s-> System.out.println(s));
    }
}
