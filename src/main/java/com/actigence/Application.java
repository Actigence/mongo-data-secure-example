package com.actigence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.core.env.SimpleCommandLinePropertySource;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * Created by Anubhav on 11/24/2015.
 */
@ComponentScan
@EnableAutoConfiguration
@EnableAsync
@EnableScheduling
public class Application {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private Environment environment;

    @PostConstruct
    public void initApplication() throws IOException {
        log.info("PostContruct called " + environment);
        if (environment.getActiveProfiles().length == 0) {
            log.warn("No Spring profile configured, running with default configuration");
        } else {
            log.info("Running with Spring profile(s) : {}", Arrays.toString(environment.getActiveProfiles()));
        }
    }

    public static void main(String[] args) throws UnknownHostException {
        SpringApplication app = new SpringApplication(Application.class);
        app.setShowBanner(false);

        SimpleCommandLinePropertySource source = new SimpleCommandLinePropertySource(args);

        // Check if the selected profile has been set as argument.
        // if not the development profile will be added
        addDefaultProfile(app, source);
        log.info("Inside Application class");
        app.run(args).getEnvironment();
    }

    /**
     * Set a default profile if it has not been set
     */
    private static void addDefaultProfile(SpringApplication app, SimpleCommandLinePropertySource source) {
        String activeProfile = System.getenv("pdfapp_profile");
        log.info("System variable for activeProfile: " + activeProfile);
        if (activeProfile == null || activeProfile.trim().equals("")) {
            activeProfile = "dev";
        }
        app.setAdditionalProfiles(activeProfile);
    }
}
