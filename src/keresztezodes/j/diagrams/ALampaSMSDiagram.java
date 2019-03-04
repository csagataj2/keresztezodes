package keresztezodes.j.diagrams;

import hu.elte.txtuml.api.layout.Row;
import hu.elte.txtuml.api.layout.StateMachineDiagram;
import keresztezodes.x.model.aLampa;
import keresztezodes.x.model.aLampa.Init;
import keresztezodes.x.model.aLampa.Piros;
import keresztezodes.x.model.aLampa.PirosSarga;
import keresztezodes.x.model.aLampa.Sarga;
import keresztezodes.x.model.aLampa.Zold;

public class ALampaSMSDiagram extends StateMachineDiagram<aLampa> {

	// Init will be in the first row
	// The others will be in the second row
	@Row({ Init.class })
	@Row({ Piros.class, PirosSarga.class, Zold.class, Sarga.class })
	class KerLay extends Layout {
	}
}
