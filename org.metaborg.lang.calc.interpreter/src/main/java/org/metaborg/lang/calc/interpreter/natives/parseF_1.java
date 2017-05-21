package org.metaborg.lang.calc.interpreter.natives;

import org.metaborg.lang.calc.interpreter.natives.parseI_1NodeGen;
import org.metaborg.meta.lang.dynsem.interpreter.nodes.building.TermBuild;

import com.oracle.truffle.api.dsl.NodeChild;
import com.oracle.truffle.api.dsl.Specialization;
import com.oracle.truffle.api.source.SourceSection;

@NodeChild(value = "stringbuild", type = TermBuild.class)
public abstract class parseF_1 extends TermBuild {

	public parseF_1(SourceSection source) {
		super(source);
	}

	@Specialization
	public float doInt(String s) {
		return Float.parseFloat(s);
	}

	public static TermBuild create(SourceSection source, TermBuild stringbuild) {
		return parseI_1NodeGen.create(source, stringbuild);
	}
}
