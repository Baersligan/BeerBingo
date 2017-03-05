package com.example.lando.beerbingo;

import android.util.Log;

import java.util.HashMap;

/**
 * Created by Lando on 3/4/2017.
 */

public class Challenge {

    public HashMap<String, HashMap> challengeMap;

    public Challenge(){
        generateExamples();
    }

    private void generateExamples(){

        challengeMap = new HashMap<String, HashMap>();
        HashMap<String, String> challengeTmp = new HashMap<String, String>();
        challengeTmp.put("Title", "First Challenge");
        challengeTmp.put("Beer", "Staropramen");
        challengeTmp.put("Bar", "Crazy Horse");
        challengeTmp.put("Description", "Drink a Staropramen at Crazy Horse and blablabalb aasdf asdf asdf asdjf asdf");
        challengeTmp.put("imgURL", "http://dreamicus.com/data/beer/beer-04.jpg");

        challengeMap.put("1", challengeTmp);

        HashMap<String, String> challengeTmp2 = new HashMap<String, String>();

        challengeTmp2.put("Title", "Second Challenge");
        challengeTmp2.put("Beer", "San Miguel");
        challengeTmp2.put("Bar", "Lion Bar");
        challengeTmp2.put("Description", "Drink a San Miguel at Lion Bar bla adf ei jdsf sdfasd asdf e dsfkl");
        challengeTmp2.put("imgURL", "http://wallpaper-gallery.net/images/beer-wallpaper/beer-wallpaper-20.jpg");

        challengeMap.put("2", challengeTmp2);
    }
}
