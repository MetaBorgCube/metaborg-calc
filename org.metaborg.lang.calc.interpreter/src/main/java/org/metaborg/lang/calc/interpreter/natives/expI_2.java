package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.expI_2NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChildren({ @NodeChild(value = "left", type = TermBuild.class),
		@NodeChild(value = "right", type = TermBuild.class) })
public abstract class expI_2 extends TermBuild {

	public expI_2(SourceSection source) {
		super(source);
	}

	@Specialization
	public int doInt(int left, int right) {
		return (int)java.lang.Math.pow(left,right) ;
	}

	public static TermBuild create(SourceSection source, TermBuild left,
			TermBuild right) {
		return expI_2NodeGen.create(source, left, right);
	}

}
