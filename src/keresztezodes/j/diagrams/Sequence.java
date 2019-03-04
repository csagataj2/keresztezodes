package keresztezodes.j.diagrams;

import static hu.elte.txtuml.api.model.seqdiag.Sequence.assertState;
import static hu.elte.txtuml.api.model.seqdiag.Sequence.fromActor;
import static hu.elte.txtuml.api.model.seqdiag.Sequence.send;

import hu.elte.txtuml.api.model.Action;
import hu.elte.txtuml.api.model.seqdiag.ExecMode;
import hu.elte.txtuml.api.model.seqdiag.ExecutionMode;
import hu.elte.txtuml.api.model.seqdiag.Position;
import hu.elte.txtuml.api.model.seqdiag.SequenceDiagram;
import keresztezodes.x.model.KeresztA;
import keresztezodes.x.model.KeresztGy;
import keresztezodes.x.model.Lepes;
import keresztezodes.x.model.Valt;
import keresztezodes.x.model.aLampa;
import keresztezodes.x.model.gyLampa;
import keresztezodes.x.model.keresztezodes;

public class Sequence extends SequenceDiagram {

	// A aLampa will be in the first position
	@Position(1)
	aLampa a;

	// A gyLampa will be in the second position
	@Position(2)
	gyLampa gy;

	@Position(3)
	keresztezodes k;

	// Initialize the traffic light and the road
	@Override
	public void initialize() {
		// Create the objects
		a = Action.create(aLampa.class);
		gy = Action.create(gyLampa.class);
		k = Action.create(keresztezodes.class);

		// Link the traffic light and the road via the keresztezodes association
		Action.link(KeresztA.a.class, a, KeresztA.k.class, k);
		Action.link(KeresztGy.gy.class, gy, KeresztGy.k.class, k);

		// Start the lights and the road
		Action.start(a);
		Action.start(gy);
		Action.start(k);
	}

	@Override
	@ExecutionMode(ExecMode.STRICT)
	public void run() {
		// We check if the traffic light A is in the correct state
		// and if the traffic light Gy is in the correct state
		assertState(k, keresztezodes.GyalogM.class);
		assertState(gy, gyLampa.Zold.class);
		assertState(a, aLampa.Piros.class);

		fromActor(new Valt(), k);
		assertState(k, keresztezodes.AutokV.class);
		send(k, new Lepes(), gy);
		send(k, new Lepes(), a);
		assertState(gy, gyLampa.ZVillog.class);
		assertState(a, aLampa.PirosSarga.class);

		fromActor(new Valt(), k);
		assertState(k, keresztezodes.AutokM.class);
		send(k, new Lepes(), gy);
		send(k, new Lepes(), a);
		assertState(gy, gyLampa.Piros.class);
		assertState(a, aLampa.Zold.class);

		fromActor(new Valt(), k);
		assertState(k, keresztezodes.AutokL.class);
		send(k, new Lepes(), a);
		assertState(gy, gyLampa.Piros.class);
		assertState(a, aLampa.Sarga.class);

		fromActor(new Valt(), k);
		assertState(k, keresztezodes.GyalogM.class);
		send(k, new Lepes(), gy);
		send(k, new Lepes(), a);
		assertState(gy, gyLampa.Zold.class);
		assertState(a, aLampa.Piros.class);
	}
}