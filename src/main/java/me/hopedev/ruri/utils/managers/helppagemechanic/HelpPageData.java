package me.hopedev.ruri.utils.managers.helppagemechanic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class HelpPageData {

    private final int page;
    private final String prefix = "ruri!";
    public HelpPageData(int page) {
        this.page = page;
    }

    public final String getPage() {
        StringBuilder builder = new StringBuilder();
        switch (this.page) {
            case 1:
                getData().forEach((s, s2) -> builder.append("``" + this.prefix + " ").append(s).append("`` » *").append(s2).append("*\n"));
                break;
            case 2:
                System.out.println("pog0");
                break;
        }
        return builder.toString();
    }



    private static Map<String, String> getData() {
        Map<String, String> data = new HashMap<>();

        data.put("about", "About Ruri");

        return data;
    }

}
