package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.parseI_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "stringbuild", type = TermBuild.class)
public abstract class parseL_1 extends TermBuild {

	public parseL_1(SourceSection source) {
		super(source);
	}

	@Specialization
	public long doInt(String s) {
		return Long.parseLong(s);
	}

	public static TermBuild create(SourceSection source, TermBuild stringbuild) {
		return parseI_1NodeGen.create(source, stringbuild);
	}
}
