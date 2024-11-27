package com.hoonjin.study.spring.btcores.external;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;

import java.util.List;
import java.util.Set;

@Slf4j
public class CommandLineV2 {

    public static void main(String[] args) {
        for (String arg : args) {
            log.info("arg = {}", arg);
        }

        ApplicationArguments arguments = new DefaultApplicationArguments(args);
        log.info("sourceArgs = {}", List.of(arguments.getSourceArgs()));
        log.info("NonOptionArgs = {}", arguments.getNonOptionArgs());
        log.info("OptionNames = {}", arguments.getOptionNames());

        Set<String> optionNames = arguments.getOptionNames();
        for (String optionName : optionNames) {
            log.info("option arg {}={}", optionName, arguments.getOptionValues(optionName));
        }

        List<String> test = arguments.getOptionValues("test");
        List<String> mode = arguments.getOptionValues("mode");
        log.info("test = {}, mode = {}", test, mode);

    }
}
