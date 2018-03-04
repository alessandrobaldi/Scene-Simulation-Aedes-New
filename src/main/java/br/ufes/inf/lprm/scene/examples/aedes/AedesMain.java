package br.ufes.inf.lprm.scene.examples.aedes;

import br.ufes.inf.lprm.scene.SceneApplication;
import br.ufes.inf.lprm.scene.base.listeners.SCENESessionListener;
import br.ufes.inf.lprm.scene.examples.aedes.entities.*;
import java.util.Date;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;
import org.drools.core.time.SessionPseudoClock;
import org.kie.api.KieServices;
import org.kie.api.definition.type.FactType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.api.runtime.KieSessionConfiguration;
import org.kie.api.runtime.conf.ClockTypeOption;
import org.kie.api.runtime.rule.FactHandle;


/**
 * This is a sample class to launch a rule.
 */

class RuleEngineThread extends Thread {	
	private KieSession ksession;
	public RuleEngineThread(KieSession ksession) {
		this.ksession = ksession;
	}
    public void run() {  	
    	this.ksession.fireUntilHalt(); 	
    }
}



public class AedesMain {

    public static final void main(String[] args) {
        try {
        	
            // load up the knowledge base
                    Date refDate = new Date(System.currentTimeMillis());
    boolean realMode = false;
    SessionPseudoClock clock = null;
        
            
			KieServices ks = KieServices.Factory.get();
                        KieSessionConfiguration config = KieServices.Factory.get().newKieSessionConfiguration();
    if(realMode) {
        config.setOption( ClockTypeOption.get("realtime") );                        
    } else {
        config.setOption( ClockTypeOption.get("pseudo") );  
    }
			KieContainer kContainer = ks.getKieClasspathContainer();
			KieSession kSession = kContainer.newKieSession("Aedes",config);
            kSession.addEventListener(new SCENESessionListener());

			SceneApplication app = new SceneApplication(ClassPool.getDefault(), kSession, "Aedes");

            final RuleEngineThread eng = new RuleEngineThread(kSession);
			eng.start();

			//FactType factType = kSession.getKieBase().getFactType("br.ufes.inf.lprm.scene.examples.fever.entities", "Person");

			Scenary ufes = new Scenary("c0,c1,c2,c3,c4,c5,c6,c7,c8,c9","c0-c1,c1-c2,c2-c3,c3-c4,c4-c5,c5-c6,c6-c7,c7-c8,c8-c9","","c0,c1,c2,c3,c4,c5,c6,c7,c8,c9","c0",50);
			
			FactHandle fh1 = kSession.insert(ufes);

						
        } catch (Throwable t) { 
            t.printStackTrace();
        }
    }

}
