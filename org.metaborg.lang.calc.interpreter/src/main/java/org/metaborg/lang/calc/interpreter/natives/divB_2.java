package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.divB_2NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChildren({ @NodeChild(value = "left", type = TermBuild.class),
		@NodeChild(value = "right", type = TermBuild.class) })
public abstract class divB_2 extends TermBuild {

	public divB_2(SourceSection source) {
		super(source);
	}

	@Specialization
	public java.math.BigDecimal doBigDecimal(java.math.BigDecimal left, java.math.BigDecimal right) {
		return left.divide(right, new java.math.MathContext(4));
	}

	public static TermBuild create(SourceSection source, TermBuild left,
			TermBuild right) {
		return divB_2NodeGen.create(source, left, right);
	}

}
