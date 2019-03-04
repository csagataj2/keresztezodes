package keresztezodes.j.diagrams;

import hu.elte.txtuml.api.layout.Row;
import hu.elte.txtuml.api.layout.StateMachineDiagram;
import keresztezodes.x.model.gyLampa;
import keresztezodes.x.model.gyLampa.Init;
import keresztezodes.x.model.gyLampa.Piros;
import keresztezodes.x.model.gyLampa.ZVillog;
import keresztezodes.x.model.gyLampa.Zold;

public class GyLampaSMDiagram extends StateMachineDiagram<gyLampa> {

	// Init will be in the first row
	// The others will be in the second row
	@Row({ Init.class })
	@Row({ Piros.class, Zold.class, ZVillog.class })
	class KerLay extends Layout {
	}
}
