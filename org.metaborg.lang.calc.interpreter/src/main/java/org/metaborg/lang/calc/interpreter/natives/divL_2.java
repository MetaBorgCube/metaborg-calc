package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.divL_2NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChildren({ @NodeChild(value = "left", type = TermBuild.class),
		@NodeChild(value = "right", type = TermBuild.class) })
public abstract class divL_2 extends TermBuild {

	public divL_2(SourceSection source) {
		super(source);
	}

	@Specialization
	public long doInt(long left, long right) {
		return left / right;
	}

	public static TermBuild create(SourceSection source, TermBuild left,
			TermBuild right) {
		return divL_2NodeGen.create(source, left, right);
	}

}
