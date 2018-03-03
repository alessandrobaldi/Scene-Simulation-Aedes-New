/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufes.inf.lprm.scene.examples.aedes.situations;

import br.ufes.inf.lprm.scene.examples.aedes.entities.*;
import org.kie.api.definition.type.Key;
import br.ufes.inf.lprm.scene.model.Situation;
import br.ufes.inf.lprm.scene.model.SituationType;
import br.ufes.inf.lprm.situation.bindings.part;
import br.ufes.inf.lprm.situation.model.bindings.Part;
import br.ufes.inf.lprm.situation.model.bindings.Snapshot;
import java.util.List;
import java.util.Random;

/**
 *
 * @author alessandro
 */
public class mosquitoAptFly extends SituationType{
    @Key
    @part(label = "$house")
    private House actual;
    @part(label = "$mosq")
    private Mosquito flying;

    public mosquitoAptFly(Class<?> type, List<Part> list, List<Snapshot> list1) {
        super(type, list, list1);
    }
    public void setActual(House actual) {
		this.actual = actual;
	}
    public House getActual() {
        return actual;
    }
    
    public void setFlying(Mosquito flying) {
		this.flying = flying;
	}

	public Mosquito getFlying() {
		return flying;
	}

}
    
