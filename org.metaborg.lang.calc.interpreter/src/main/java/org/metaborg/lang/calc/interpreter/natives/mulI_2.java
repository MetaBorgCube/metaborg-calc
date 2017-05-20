package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.mulI_2NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChildren({ @NodeChild(value = "left", type = TermBuild.class),
		@NodeChild(value = "right", type = TermBuild.class) })
public abstract class mulI_2 extends TermBuild {

	public mulI_2(SourceSection source) {
		super(source);
	}

	@Specialization
	public int doInt(int left, int right) {
		return left * right;
	}

	public static TermBuild create(SourceSection source, TermBuild left,
			TermBuild right) {
		return mulI_2NodeGen.create(source, left, right);
	}

}
