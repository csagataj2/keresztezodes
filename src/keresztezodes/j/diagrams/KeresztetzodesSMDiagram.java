package keresztezodes.j.diagrams;

import hu.elte.txtuml.api.layout.Row;
import hu.elte.txtuml.api.layout.StateMachineDiagram;
import keresztezodes.x.model.keresztezodes;
import keresztezodes.x.model.keresztezodes.AutokL;
import keresztezodes.x.model.keresztezodes.AutokM;
import keresztezodes.x.model.keresztezodes.AutokV;
import keresztezodes.x.model.keresztezodes.GyalogM;
import keresztezodes.x.model.keresztezodes.Init;

public class KeresztetzodesSMDiagram extends StateMachineDiagram<keresztezodes> {

	// Init will be in the first row
	// The others will be in the second row
	@Row({ Init.class })
	@Row({ GyalogM.class, AutokV.class, AutokM.class, AutokL.class })
	class KerLay extends Layout {
	}
}
