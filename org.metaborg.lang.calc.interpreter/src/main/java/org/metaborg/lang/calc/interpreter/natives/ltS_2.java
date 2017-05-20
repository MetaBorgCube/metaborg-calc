package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.ltS_2NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.NodeChildren;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChildren({@NodeChild(value = "left", type = TermBuild.class), @NodeChild(value = "right", type = TermBuild.class) })
public abstract class ltS_2 extends TermBuild {

	public ltS_2(SourceSection source) {
		super(source);
	}

	@Specialization
	public boolean doString(String left, String right) {
		return left.compareTo(right) < 0 ? true : false;
	}

	public static TermBuild create(SourceSection source, TermBuild left, TermBuild right) {
		return ltS_2NodeGen.create(source, left, right);
	}

}
