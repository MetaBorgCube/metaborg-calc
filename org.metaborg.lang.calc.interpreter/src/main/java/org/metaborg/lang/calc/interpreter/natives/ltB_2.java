package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.ltB_2NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChildren({ @NodeChild(value = "left", type = TermBuild.class),
		@NodeChild(value = "right", type = TermBuild.class) })
public abstract class ltB_2 extends TermBuild {

	public ltB_2(SourceSection source) {
		super(source);
	}

	@Specialization
	public boolean doBigDecimal(java.math.BigDecimal left, java.math.BigDecimal right) {
		return left.compareTo(right) == -1;
	}

	public static TermBuild create(SourceSection source, TermBuild left,
			TermBuild right) {
		return ltB_2NodeGen.create(source, left, right);
	}

}
