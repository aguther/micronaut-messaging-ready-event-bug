package com.example;

import io.micronaut.context.ApplicationContext;
import io.micronaut.context.event.ShutdownEvent;
import io.micronaut.context.event.StartupEvent;
import io.micronaut.discovery.event.ServiceReadyEvent;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Inject;
import jakarta.inject.Singleton;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class TestSingleton {

  private static final Logger logger = LoggerFactory.getLogger( TestSingleton.class );

  @Inject
  private ApplicationContext applicationContext;

  @PostConstruct
  public void onStart() {
    logger.info( "post-construct" );
  }

  @EventListener
  public void onStartup( StartupEvent event ) {
    logger.info( "startup event" );
  }

  @EventListener
  public void onReady( ServiceReadyEvent event ) {
    logger.info( "service ready event" );
  }

  @EventListener
  public void onShutdown( ShutdownEvent event ) {
    logger.info( "shutdown event" );
  }

  @PreDestroy
  public void onPreDestroy() {
    logger.info( "pre-destroy" );
  }
}
