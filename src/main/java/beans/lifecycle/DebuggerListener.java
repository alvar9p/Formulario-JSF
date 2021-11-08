package beans.lifecycle;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class DebuggerListener implements javax.faces.event.PhaseListener{

    // Variable que nos va a permitir mandar mensajes a la consola
    // utilizando el api de log4j
    
    Logger log = LogManager.getRootLogger();
    
    
    @Override
    public void afterPhase(PhaseEvent pe) {
        if(log.isInfoEnabled())
            log.info(("Después de la fase" + pe.getPhaseId().toString()));
    }

    @Override
    public void beforePhase(PhaseEvent pe) {
        // Si está habilitado este nivel, vamos a mandar la sgte información
        // La etapa en la que estamos, y la etapa actual
        if(log.isInfoEnabled()){
            log.info("Antes de la fase: " + pe.getPhaseId().toString());
        }
    }

    @Override
    public PhaseId getPhaseId() {
        return PhaseId.ANY_PHASE;
    }
    
    
    
}
