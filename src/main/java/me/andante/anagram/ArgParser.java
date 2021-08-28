package me.andante.anagram;

import java.util.HashMap;

public class ArgParser {
    public static final String ARG_PREFIX = "--";

    public static HashMap<String, Object> toMap(String[] args) {
        HashMap<String, Object> map = new HashMap<>();

        for (int i = 0; i < args.length; i++) {
            String arg = args[i];
            String rawArg = arg.substring(2);

            if (arg.startsWith(ARG_PREFIX)) {
                int argValIndex = i + 1;
                if (argValIndex > args.length - 1 || args[argValIndex].startsWith(ARG_PREFIX)) {
                     map.put(rawArg, true);
                } else {
                    map.put(rawArg, args[argValIndex]);
                }
            }
        }

        return map;
    }
}
