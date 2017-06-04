package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.powB_2NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChildren({ @NodeChild(value = "left", type = TermBuild.class),
		@NodeChild(value = "right", type = TermBuild.class) })
public abstract class powB_2 extends TermBuild {

	public powB_2(SourceSection source) {
		super(source);
	}

	@Specialization
	public java.math.BigDecimal doInt(java.math.BigDecimal left, java.math.BigDecimal right) {
		return left.pow(right.intValueExact());
	}

	public static TermBuild create(SourceSection source, TermBuild left,
			TermBuild right) {
		return powB_2NodeGen.create(source, left, right);
	}

}
