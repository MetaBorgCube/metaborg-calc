package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.leqI_2NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChildren({ @NodeChild(value = "left", type = TermBuild.class),
		@NodeChild(value = "right", type = TermBuild.class) })
public abstract class leqI_2 extends TermBuild {

	public leqI_2(SourceSection source) {
		super(source);
	}

	@Specialization
	public boolean doInt(int left, int right) {
		return left <= right ? true : false;
	}

	public static TermBuild create(SourceSection source, TermBuild left,
			TermBuild right) {
		return leqI_2NodeGen.create(source, left, right);
	}

}
