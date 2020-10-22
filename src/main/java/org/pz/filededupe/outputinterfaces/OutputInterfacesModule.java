package org.pz.filededupe.outputinterfaces;

import com.google.inject.AbstractModule;

import java.time.Clock;

/**
 * Module for binding output interfaces
 *
 * Binding {@link Clock} for better control of time during tests.
 *
 * @author dsaraiva
 */
public class OutputInterfacesModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(HtmlOutput.class).to(HtmlOutputImpl.class);
        bind(StandardOutput.class).to(StandardOutputImpl.class);
        bind(Clock.class).toInstance(Clock.systemDefaultZone());
    }
}