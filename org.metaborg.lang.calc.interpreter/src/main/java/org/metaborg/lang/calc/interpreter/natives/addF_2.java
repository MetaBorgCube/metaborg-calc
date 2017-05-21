package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.addF_2NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChildren({ @NodeChild(value = "left", type = TermBuild.class),
		@NodeChild(value = "right", type = TermBuild.class) })
public abstract class addF_2 extends TermBuild {

	public addF_2(SourceSection source) {
		super(source);
	}

	@Specialization
	public float doInt(float left, float right) {
		return left + right;
	}

	public static TermBuild create(SourceSection source, TermBuild left,
			TermBuild right) {
		return addF_2NodeGen.create(source, left, right);
	}

}
