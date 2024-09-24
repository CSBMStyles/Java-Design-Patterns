package patterns.comportamiento.mediator.excersice.components;

import patterns.comportamiento.mediator.excersice.mediator.Mediator;

/**
 * Common component interface.
 */
public interface Component {
    void setMediator(Mediator mediator);

    String getName();
}
